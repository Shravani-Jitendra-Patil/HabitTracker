import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Habit } from '../../models/habit.model';

@Component({
  selector: 'app-habit-list',
  templateUrl: './habit-list.component.html',
  styleUrls: ['./habit-list.component.css']
})
export class HabitListComponent {
  @Input() habits: Habit[] = [];
  @Output() editHabit = new EventEmitter<Habit>();
  @Output() deleteHabit = new EventEmitter<number>();
  @Output() toggleStatus = new EventEmitter<{ id: number; completed: boolean }>();
}
