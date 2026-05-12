package com.example.habittracker.dto;

import java.time.LocalDate;

public class HabitResponse {
    private Long id;
    private String habitName;
    private String category;
    private String description;
    private String frequency;
    private LocalDate createdDate;
    private boolean completedToday;
    private long streak;

    public HabitResponse() {
    }

    public HabitResponse(Long id, String habitName, String category, String description, String frequency,
                         LocalDate createdDate, boolean completedToday, long streak) {
        this.id = id;
        this.habitName = habitName;
        this.category = category;
        this.description = description;
        this.frequency = frequency;
        this.createdDate = createdDate;
        this.completedToday = completedToday;
        this.streak = streak;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getHabitName() { return habitName; }
    public void setHabitName(String habitName) { this.habitName = habitName; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getFrequency() { return frequency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }
    public LocalDate getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }
    public boolean isCompletedToday() { return completedToday; }
    public void setCompletedToday(boolean completedToday) { this.completedToday = completedToday; }
    public long getStreak() { return streak; }
    public void setStreak(long streak) { this.streak = streak; }
}
