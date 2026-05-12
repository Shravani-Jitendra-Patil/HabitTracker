import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Habit } from '../../models/habit.model';

@Component({
  selector: 'app-habit-form',
  templateUrl: './habit-form.component.html',
  styleUrls: ['./habit-form.component.css']
})
export class HabitFormComponent implements OnChanges {
  @Input() selectedHabit: Habit | null = null;
  @Output() saveHabit = new EventEmitter<Habit>();
  @Output() cancelEdit = new EventEmitter<void>();

  habitForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.habitForm = this.fb.group({
      habitName: ['', Validators.required],
      category: ['', Validators.required],
      description: [''],
      frequency: ['Daily', Validators.required]
    });
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['selectedHabit']) {
      if (this.selectedHabit) {
        this.habitForm.patchValue(this.selectedHabit);
      } else {
        this.habitForm.reset({ frequency: 'Daily' });
      }
    }
  }

  submitForm(): void {
    if (this.habitForm.invalid) {
      this.habitForm.markAllAsTouched();
      return;
    }

    const habit: Habit = {
      ...this.selectedHabit,
      ...this.habitForm.value
    };
    this.saveHabit.emit(habit);
    if (!this.selectedHabit) {
      this.habitForm.reset({ frequency: 'Daily' });
    }
  }

  onCancel(): void {
    this.habitForm.reset({ frequency: 'Daily' });
    this.cancelEdit.emit();
  }
}
