import { Component, OnInit } from '@angular/core';
import { Habit } from './models/habit.model';
import { Dashboard } from './models/dashboard.model';
import { HabitService } from './services/habit.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  habits: Habit[] = [];
  dashboard: Dashboard = { totalHabits: 0, completedToday: 0, pendingToday: 0 };
  selectedHabit: Habit | null = null;
  errorMessage = '';
  successMessage = '';

  constructor(private habitService: HabitService) {}

  ngOnInit(): void {
    this.loadData();
  }

  loadData(): void {
    this.loadHabits();
    this.loadDashboard();
  }

  loadHabits(): void {
    this.habitService.getHabits().subscribe({
      next: data => this.habits = data,
      error: () => this.errorMessage = 'Could not load habits. Is backend running?'
    });
  }

  loadDashboard(): void {
    this.habitService.getDashboard().subscribe({
      next: data => this.dashboard = data
    });
  }

  handleSaveHabit(habit: Habit): void {
    this.errorMessage = '';
    this.successMessage = '';

    if (habit.id) {
      this.habitService.updateHabit(habit.id, habit).subscribe({
        next: () => {
          this.successMessage = 'Habit updated successfully.';
          this.selectedHabit = null;
          this.loadData();
        },
        error: () => this.errorMessage = 'Unable to update habit.'
      });
    } else {
      this.habitService.addHabit(habit).subscribe({
        next: () => {
          this.successMessage = 'Habit added successfully.';
          this.loadData();
        },
        error: () => this.errorMessage = 'Unable to add habit.'
      });
    }
  }

  handleEditHabit(habit: Habit): void {
    this.selectedHabit = { ...habit };
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }

  handleDeleteHabit(id: number): void {
    if (!confirm('Delete this habit?')) {
      return;
    }
    this.habitService.deleteHabit(id).subscribe({
      next: () => {
        this.successMessage = 'Habit deleted successfully.';
        if (this.selectedHabit?.id === id) {
          this.selectedHabit = null;
        }
        this.loadData();
      },
      error: () => this.errorMessage = 'Unable to delete habit.'
    });
  }

  handleToggleStatus(payload: { id: number; completed: boolean }): void {
    this.habitService.updateStatus(payload.id, payload.completed).subscribe({
      next: () => {
        this.successMessage = payload.completed ? 'Habit marked as done.' : 'Habit marked as pending.';
        this.loadData();
      },
      error: () => this.errorMessage = 'Unable to update status.'
    });
  }

  handleCancelEdit(): void {
    this.selectedHabit = null;
  }
}
