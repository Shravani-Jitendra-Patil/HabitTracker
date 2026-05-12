package com.example.habittracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "habits")
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "habit_name", nullable = false, length = 100)
    private String habitName;

    @Column(nullable = false, length = 50)
    private String category;

    @Column(length = 255)
    private String description;

    @Column(nullable = false)
    private String frequency;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    public Habit() {
    }

    public Habit(Long id, String habitName, String category, String description, String frequency, LocalDate createdDate) {
        this.id = id;
        this.habitName = habitName;
        this.category = category;
        this.description = description;
        this.frequency = frequency;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
