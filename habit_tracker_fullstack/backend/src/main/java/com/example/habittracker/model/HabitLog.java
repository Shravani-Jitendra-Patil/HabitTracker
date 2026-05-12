package com.example.habittracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "habit_logs", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"habit_id", "log_date"})
})
public class HabitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "habit_id", nullable = false)
    private Habit habit;

    @Column(name = "log_date", nullable = false)
    private LocalDate logDate;

    @Column(nullable = false)
    private Boolean completed;

    public HabitLog() {
    }

    public HabitLog(Long id, Habit habit, LocalDate logDate, Boolean completed) {
        this.id = id;
        this.habit = habit;
        this.logDate = logDate;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Habit getHabit() {
        return habit;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
