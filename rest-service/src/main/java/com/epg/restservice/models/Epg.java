package com.epg.restservice.models;

import java.util.List;

public class Epg {
    private final List<DailyTvProgram> monday;
    private final List<DailyTvProgram> tuesday;
    private final List<DailyTvProgram> wednesday;
    private final List<DailyTvProgram> thursday;
    private final List<DailyTvProgram> friday;
    private final List<DailyTvProgram> saturday;
    private final List<DailyTvProgram> sunday;

    public Epg(List<DailyTvProgram> monday, List<DailyTvProgram> tuesday, List<DailyTvProgram> wednesday, List<DailyTvProgram> thursday, List<DailyTvProgram> friday, List<DailyTvProgram> saturday, List<DailyTvProgram> sunday) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    public List<DailyTvProgram> getMonday() {
        return monday;
    }

    public List<DailyTvProgram> getTuesday() {
        return tuesday;
    }

    public List<DailyTvProgram> getWednesday() {
        return wednesday;
    }

    public List<DailyTvProgram> getThursday() {
        return thursday;
    }

    public List<DailyTvProgram> getFriday() {
        return friday;
    }

    public List<DailyTvProgram> getSaturday() {
        return saturday;
    }

    public List<DailyTvProgram> getSunday() {
        return sunday;
    }
}