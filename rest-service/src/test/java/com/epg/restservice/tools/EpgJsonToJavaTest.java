package com.epg.restservice.tools;

import com.epg.restservice.models.DailyTvProgram;
import com.epg.restservice.models.Epg;
import com.epg.restservice.models.TvProgram;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EpgJsonToJavaTest {
    private List<DailyTvProgram> monday;
    private List<DailyTvProgram> tuesday;
    private List<DailyTvProgram> wednesday;
    private List<DailyTvProgram> thursday;
    private List<DailyTvProgram> friday;
    private List<DailyTvProgram> saturday;
    private List<DailyTvProgram> sunday;

    private DailyTvProgram dailyTvProgram1;
    private DailyTvProgram dailyTvProgram2;
    Epg epg;

    @BeforeEach
    void prepareData() {
        monday = new ArrayList<>();
        tuesday = new ArrayList<>();
        wednesday = new ArrayList<>();
        thursday = new ArrayList<>();
        friday = new ArrayList<>();
        saturday = new ArrayList<>();
        sunday = new ArrayList<>();


    }

    @Test
    void checkThatItOnlyCreatesOneTvProgram() {
        dailyTvProgram1 = new DailyTvProgram("Nyhederne", "begin", 3600);
        dailyTvProgram2 = new DailyTvProgram("Nyhederne", "end", 6700);
        monday.add(dailyTvProgram1);
        monday.add(dailyTvProgram2);

        epg = new Epg(monday, tuesday, wednesday, thursday, friday, saturday, sunday);

        EpgJsonToJava epgJsonToJava = new EpgJsonToJava();
        List<TvProgram> actual = epgJsonToJava.processEpgJson(epg);
        int expected = 1;

        assertEquals(expected, actual.size());
    }

    @Test
    void checkWhenEmptyThatNothingIsParsed() {
        epg = new Epg(monday, tuesday, wednesday, thursday, friday, saturday, sunday);

        EpgJsonToJava epgJsonToJava = new EpgJsonToJava();
        List<TvProgram> actual = epgJsonToJava.processEpgJson(epg);
        int expected = 0;

        assertEquals(expected, actual.size());
    }
}