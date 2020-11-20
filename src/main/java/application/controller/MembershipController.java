package application.controller;

import application.model.Membership;
import application.service.MembershipService;
import application.service.MembershipServiceImpl;
import org.hibernate.usertype.UserVersionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.List;

@Controller
@RequestMapping("/api/membership")
public class MembershipController {

    @Autowired
    private MembershipServiceImpl service;

    @GetMapping(value = "/all")
    public @ResponseBody
    List<Membership> getMemberships() {
        return service.findAllMemberships();
    }

    @GetMapping(value = "/name")
    public @ResponseBody
    Membership getMembershipByName(@RequestBody String name) { return service.findByName(name); }

    @PostMapping(value = "/new")
    public @ResponseBody
    Membership addMembership(@RequestBody String name) {
        Membership membership = new Membership(name.substring(0, name.length() - 1));
        service.save(membership);
        return service.findByName(membership.getName());
    }
}
