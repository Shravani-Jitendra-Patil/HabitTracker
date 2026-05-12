package com.example.habittracker.repository;

import com.example.habittracker.model.Habit;
import com.example.habittracker.model.HabitLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HabitLogRepository extends JpaRepository<HabitLog, Long> {
    Optional<HabitLog> findByHabitAndLogDate(Habit habit, LocalDate logDate);
    List<HabitLog> findByHabitAndCompletedTrueOrderByLogDateDesc(Habit habit);
    long countByLogDateAndCompletedTrue(LocalDate logDate);
}
