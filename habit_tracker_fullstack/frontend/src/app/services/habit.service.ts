import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Habit } from '../models/habit.model';
import { Dashboard } from '../models/dashboard.model';

@Injectable({ providedIn: 'root' })
export class HabitService {
  private baseUrl = 'http://localhost:8080/api/habits';

  constructor(private http: HttpClient) {}

  getHabits(): Observable<Habit[]> {
    return this.http.get<Habit[]>(this.baseUrl);
  }

  getDashboard(): Observable<Dashboard> {
    return this.http.get<Dashboard>(`${this.baseUrl}/dashboard`);
  }

  addHabit(habit: Habit): Observable<Habit> {
    return this.http.post<Habit>(this.baseUrl, habit);
  }

  updateHabit(id: number, habit: Habit): Observable<Habit> {
    return this.http.put<Habit>(`${this.baseUrl}/${id}`, habit);
  }

  deleteHabit(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  updateStatus(id: number, completed: boolean): Observable<Habit> {
    return this.http.patch<Habit>(`${this.baseUrl}/${id}/status`, { completed });
  }
}
