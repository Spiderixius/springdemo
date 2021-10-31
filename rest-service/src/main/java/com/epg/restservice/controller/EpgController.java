package com.epg.restservice.controller;

import com.epg.restservice.models.Epg;
import com.epg.restservice.models.TvProgram;
import com.epg.restservice.tools.EpgJsonToJava;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EpgController {
    @RequestMapping(value = "/epg", method = RequestMethod.POST)
    public String epgJsonData(@RequestBody Epg epgJson) {
        EpgJsonToJava jsonToJava = new EpgJsonToJava();
        List<TvProgram> parsedTvPrograms = jsonToJava.processEpgJson(epgJson);
        return jsonToJava.buildHumanFriendlyOutput(parsedTvPrograms);
    }
}
