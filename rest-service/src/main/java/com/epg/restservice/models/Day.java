package com.epg.restservice.models;

public enum Day {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private final String code;

    Day(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}