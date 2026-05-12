package com.example.habittracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class HabitRequest {
    @NotBlank(message = "Habit name is required")
    @Size(max = 100)
    private String habitName;

    @NotBlank(message = "Category is required")
    @Size(max = 50)
    private String category;

    @Size(max = 255)
    private String description;

    @NotBlank(message = "Frequency is required")
    private String frequency;

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
