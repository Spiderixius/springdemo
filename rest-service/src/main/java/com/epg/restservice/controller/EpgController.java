package com.epg.restservice.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EpgController {

    @RequestMapping(value = "/epg", method = RequestMethod.POST)
    public String epgJsonData(@RequestBody String epgJson) {

        return epgJson;
    }
}
