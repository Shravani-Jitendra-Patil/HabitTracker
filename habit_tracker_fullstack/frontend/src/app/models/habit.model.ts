export interface Habit {
  id?: number;
  habitName: string;
  category: string;
  description: string;
  frequency: string;
  createdDate?: string;
  completedToday?: boolean;
  streak?: number;
}
