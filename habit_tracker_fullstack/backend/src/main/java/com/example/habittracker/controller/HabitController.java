package com.example.habittracker.controller;

import com.example.habittracker.dto.DashboardResponse;
import com.example.habittracker.dto.HabitRequest;
import com.example.habittracker.dto.HabitResponse;
import com.example.habittracker.service.HabitService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/habits")
@CrossOrigin(origins = "http://localhost:4200")
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping
    public List<HabitResponse> getAllHabits() {
        return habitService.getAllHabits();
    }

    @GetMapping("/dashboard")
    public DashboardResponse getDashboard() {
        return habitService.getDashboard();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HabitResponse createHabit(@Valid @RequestBody HabitRequest request) {
        return habitService.createHabit(request);
    }

    @PutMapping("/{id}")
    public HabitResponse updateHabit(@PathVariable Long id, @Valid @RequestBody HabitRequest request) {
        return habitService.updateHabit(id, request);
    }

    @PatchMapping("/{id}/status")
    public HabitResponse updateTodayStatus(@PathVariable Long id, @RequestBody Map<String, Boolean> body) {
        boolean completed = body.getOrDefault("completed", false);
        return habitService.markToday(id, completed);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHabit(@PathVariable Long id) {
        habitService.deleteHabit(id);
    }
}
