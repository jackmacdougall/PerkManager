package application.controller;

import application.model.Membership;
import application.model.User;

import application.service.MembershipService;
import application.service.MembershipServiceImpl;
import application.service.UserService;
import application.service.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.ir.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @Autowired
    private MembershipServiceImpl membershipService;

    @GetMapping(value = "/username")
    public @ResponseBody
    User getUserByUsername(@RequestParam("username") String username) {
        return service.findByUsername(username);
    }

    @GetMapping(value = "/id")
    public @ResponseBody
    User getUserById(@RequestBody Long id) {
        return service.findById(id).get();
    }

    @PostMapping(value = "/membership/new")
    public @ResponseBody
    void addNewMembershipToUser(@RequestBody String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(json);
            User user = mapper.convertValue(node.get("userObj"), User.class);
            String membershipName = mapper.convertValue(node.get("membershipName"), String.class);
            Membership membership = new Membership(membershipName);
            user.addMembership(membership);
            service.save(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @PostMapping(value = "/membership")
    public @ResponseBody
    void addMembershipToUser(@RequestBody String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(json);
            User user = mapper.convertValue(node.get("userObj"), User.class);
            Membership membership = mapper.convertValue(node.get("membershipObj"), Membership.class);
            user.addMembership(membership);
            service.save(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
