package com.epg.restservice.models;

public class DailyTvProgram {
    private final String title;
    private final String state;
    private final int time;

    public DailyTvProgram(String title, String state, int time) {
        this.title = title;
        this.state = state;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getState() {
        return state;
    }

    public int getTime() {
        return time;
    }
}