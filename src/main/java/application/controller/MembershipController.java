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
import java.util.Set;

@Controller
@RequestMapping("/api/membership")
public class MembershipController {

    @Autowired
    private MembershipServiceImpl service;

    @GetMapping(value = "/all")
    public @ResponseBody
    List<Membership> getAllMemberships() {
        return service.findAllMemberships();
    }

    @GetMapping(value = "/name")
    public @ResponseBody
    Membership getMembershipByName(@RequestParam("name") String name) { return service.findByName(name); }

    @GetMapping(value = "/user")
    public @ResponseBody
    List<Membership> getMembershipWithUser(@RequestParam("username") String username) { return service.findByUsername(username); }

    @GetMapping(value = "/notuser")
    public @ResponseBody
    List<Membership> getMembershipsNotWithUser(@RequestParam("username") String username) {
        return service.findByNotUsername(username);
    }

    @PostMapping(value = "/new")
    public @ResponseBody
    Membership addMembership(@RequestBody String name) {
        Membership membership = new Membership(name.substring(0, name.length() - 1));
        service.addMembership(membership);
        return service.findByName(membership.getName());
    }
}
