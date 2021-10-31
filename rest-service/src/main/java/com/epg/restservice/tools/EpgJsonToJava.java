package com.epg.restservice.tools;

import com.epg.restservice.models.DailyTvProgram;
import com.epg.restservice.models.Day;
import com.epg.restservice.models.Epg;
import com.epg.restservice.models.TvProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EpgJsonToJava {
    Map<Integer, String> noProgramDays = new HashMap<>();
    List<TvProgram> tvPrograms = new ArrayList<>();

    public List<TvProgram> processEpgJson(Epg epgJson) {
        processDailyPrograms(epgJson.getMonday(), Day.MONDAY.toString());
        processDailyPrograms(epgJson.getTuesday(), Day.TUESDAY.toString());
        processDailyPrograms(epgJson.getWednesday(), Day.WEDNESDAY.toString());
        processDailyPrograms(epgJson.getThursday(), Day.THURSDAY.toString());
        processDailyPrograms(epgJson.getFriday(), Day.FRIDAY.toString());
        processDailyPrograms(epgJson.getSaturday(), Day.SATURDAY.toString());
        processDailyPrograms(epgJson.getSunday(), Day.SUNDAY.toString());
        return tvPrograms;
    }

    public String buildHumanFriendlyOutput(List<TvProgram> tvPrograms) {
        StringBuilder resultBuilder = new StringBuilder();
        String previousDay = "";
        int indexToIgnore = -1;

        for (int i = 0; i < tvPrograms.size(); i++) {
            StringBuilder lineBuilder = new StringBuilder();

            String firstTitle = tvPrograms.get(i).getTitle();
            String firstDay = tvPrograms.get(i).getDay();
            String firstStartTime = tvPrograms.get(i).getStartTime();
            String firstEndTime = tvPrograms.get(i).getEndTime();

            if (!firstDay.equals(previousDay)) {
                lineBuilder.append("\n").append(firstDay).append("\n");
                previousDay = firstDay;
            }

            if (i != indexToIgnore) {
                lineBuilder.append(firstTitle).append(" ").append(firstStartTime).append(" - ").append(firstEndTime);
            }

            for (int j = i + 1; j < tvPrograms.size(); j++) {
                String secondTitle = tvPrograms.get(j).getTitle();
                String secondDay = tvPrograms.get(j).getDay();
                String secondStartTime = tvPrograms.get(j).getStartTime();
                String secondEndTime = tvPrograms.get(j).getEndTime();

                if (secondTitle.equals(firstTitle) && secondDay.equals(firstDay)) {
                    lineBuilder.append(", ").append(secondStartTime).append(" - ").append(secondEndTime);
                    indexToIgnore = j;
                }
            }

            for(Map.Entry<Integer, String> entry : noProgramDays.entrySet()) {
                if (entry.getKey() == i + 1) {
                    lineBuilder.append("\n\n").append(entry.getValue()).append("\n").append("Nothing to air today.");
                }
            }
            if (i != indexToIgnore) {
                resultBuilder.append(lineBuilder).append("\n");
            }
        }
        return resultBuilder.toString();
    }


    private void processDailyPrograms(List<DailyTvProgram> dailyTvPrograms, String day) {
        if (dailyTvPrograms.isEmpty()) {
            noProgramDays.put(tvPrograms.size(), day);
        } else {
            for (DailyTvProgram dailyTvProgram : dailyTvPrograms) {
                String title = dailyTvProgram.getTitle();
                String state = dailyTvProgram.getState();
                int time = dailyTvProgram.getTime();

                appendProgramToListOfPrograms(tvPrograms, day, title, state, time);
            }
        }
        if (dailyTvPrograms.size() == 1 && !dailyTvPrograms.get(0).getState().equals("begin")) {
            noProgramDays.put(tvPrograms.size(), day);
        }
    }

    private void appendProgramToListOfPrograms(List<TvProgram> tvPrograms, String day, String title, String state, int time) {
        if (state.equals("begin")) {
            tvPrograms.add(new TvProgram(title, time, day));
        } else if (state.equals("end")) {
            tvPrograms.get(tvPrograms.size() - 1).setEndTime(time);
        }
    }
}