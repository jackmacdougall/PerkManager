package application.controller;

import application.model.*;
import application.service.LimitationServiceImpl;
import application.service.PerkServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/perk")
public class PerkController {

    @Autowired
    private PerkServiceImpl service;

    @Autowired
    private LimitationServiceImpl limitService;

    @PostMapping("/new")
    public @ResponseBody
    void addNewPerk(@RequestBody String perkData) {
        Perk newPerk = service.addPerk(perkData);
        limitService.addLimitations(perkData,newPerk);
    }
}
