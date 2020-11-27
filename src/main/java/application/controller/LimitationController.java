package application.controller;

import application.model.Limitation;
import application.service.LimitationServiceImpl;
import application.service.MembershipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/limitation")
public class LimitationController {

    @Autowired
    private LimitationServiceImpl service;

    @GetMapping(value="/perk")
    public @ResponseBody
    List<Limitation> getLimitationsOfPerk(@RequestParam("id") Long id) {
        return service.findByPerk(id);
    }
}
