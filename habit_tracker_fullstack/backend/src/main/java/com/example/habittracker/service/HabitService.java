package com.example.habittracker.service;

import com.example.habittracker.dto.DashboardResponse;
import com.example.habittracker.dto.HabitRequest;
import com.example.habittracker.dto.HabitResponse;
import com.example.habittracker.model.Habit;
import com.example.habittracker.model.HabitLog;
import com.example.habittracker.repository.HabitLogRepository;
import com.example.habittracker.repository.HabitRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class HabitService {

    private final HabitRepository habitRepository;
    private final HabitLogRepository habitLogRepository;

    public HabitService(HabitRepository habitRepository, HabitLogRepository habitLogRepository) {
        this.habitRepository = habitRepository;
        this.habitLogRepository = habitLogRepository;
    }

    public List<HabitResponse> getAllHabits() {
        return habitRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Habit::getId).reversed())
                .map(this::mapToResponse)
                .toList();
    }

    public DashboardResponse getDashboard() {
        long total = habitRepository.count();
        long completedToday = habitLogRepository.countByLogDateAndCompletedTrue(LocalDate.now());
        long pending = Math.max(total - completedToday, 0);
        return new DashboardResponse(total, completedToday, pending);
    }

    public HabitResponse createHabit(HabitRequest request) {
        Habit habit = new Habit();
        habit.setHabitName(request.getHabitName().trim());
        habit.setCategory(request.getCategory().trim());
        habit.setDescription(request.getDescription() == null ? "" : request.getDescription().trim());
        habit.setFrequency(request.getFrequency().trim());
        habit.setCreatedDate(LocalDate.now());
        return mapToResponse(habitRepository.save(habit));
    }

    public HabitResponse updateHabit(Long id, HabitRequest request) {
        Habit habit = findHabit(id);
        habit.setHabitName(request.getHabitName().trim());
        habit.setCategory(request.getCategory().trim());
        habit.setDescription(request.getDescription() == null ? "" : request.getDescription().trim());
        habit.setFrequency(request.getFrequency().trim());
        return mapToResponse(habitRepository.save(habit));
    }

    @Transactional
    public void deleteHabit(Long id) {
        Habit habit = findHabit(id);
        habitRepository.delete(habit);
    }

    public HabitResponse markToday(Long id, boolean completed) {
        Habit habit = findHabit(id);
        LocalDate today = LocalDate.now();
        HabitLog log = habitLogRepository.findByHabitAndLogDate(habit, today)
                .orElseGet(() -> {
                    HabitLog newLog = new HabitLog();
                    newLog.setHabit(habit);
                    newLog.setLogDate(today);
                    return newLog;
                });
        log.setCompleted(completed);
        habitLogRepository.save(log);
        return mapToResponse(habit);
    }

    private Habit findHabit(Long id) {
        return habitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Habit not found with id: " + id));
    }

    private HabitResponse mapToResponse(Habit habit) {
        boolean completedToday = habitLogRepository.findByHabitAndLogDate(habit, LocalDate.now())
                .map(HabitLog::getCompleted)
                .orElse(false);
        long streak = calculateStreak(habit);
        return new HabitResponse(
                habit.getId(),
                habit.getHabitName(),
                habit.getCategory(),
                habit.getDescription(),
                habit.getFrequency(),
                habit.getCreatedDate(),
                completedToday,
                streak
        );
    }

    private long calculateStreak(Habit habit) {
        List<HabitLog> logs = habitLogRepository.findByHabitAndCompletedTrueOrderByLogDateDesc(habit);
        if (logs.isEmpty()) {
            return 0;
        }

        long streak = 0;
        LocalDate expectedDate = LocalDate.now();
        for (HabitLog log : logs) {
            if (log.getLogDate().equals(expectedDate)) {
                streak++;
                expectedDate = expectedDate.minusDays(1);
            } else if (log.getLogDate().equals(expectedDate.minusDays(1)) && streak == 0) {
                streak++;
                expectedDate = log.getLogDate().minusDays(1);
            } else if (log.getLogDate().isBefore(expectedDate)) {
                break;
            }
        }
        return streak;
    }
}
