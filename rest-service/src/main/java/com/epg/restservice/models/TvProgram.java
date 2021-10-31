package com.epg.restservice.models;

public class TvProgram {
    private final String title;
    private final String day;
    private final String startTime;
    private String endTime;

    public TvProgram(String title, int startTime, String day) {
        this.title = title;
        this.startTime = getTimeInHours(startTime);
        this.day = day;
    }

    public String getTitle() {
        return title;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = getTimeInHours(endTime);
    }

    public String getDay() {
        return day;
    }

    private String getTimeInHours(int totalSeconds) {
        int secondsInHour = 3600;
        int hourInMinutes = 60;

        int hours = totalSeconds / secondsInHour;
        int minutes = (totalSeconds % secondsInHour) / hourInMinutes;

        return String.format("%02d:%02d", hours, minutes);
    }
}