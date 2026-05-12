package com.example.habittracker.dto;

public class DashboardResponse {
    private long totalHabits;
    private long completedToday;
    private long pendingToday;

    public DashboardResponse() {
    }

    public DashboardResponse(long totalHabits, long completedToday, long pendingToday) {
        this.totalHabits = totalHabits;
        this.completedToday = completedToday;
        this.pendingToday = pendingToday;
    }

    public long getTotalHabits() {
        return totalHabits;
    }

    public void setTotalHabits(long totalHabits) {
        this.totalHabits = totalHabits;
    }

    public long getCompletedToday() {
        return completedToday;
    }

    public void setCompletedToday(long completedToday) {
        this.completedToday = completedToday;
    }

    public long getPendingToday() {
        return pendingToday;
    }

    public void setPendingToday(long pendingToday) {
        this.pendingToday = pendingToday;
    }
}
