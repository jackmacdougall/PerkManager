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

    @GetMapping(value = "/username")
    public @ResponseBody
    User getUserByUsername(@RequestParam("username") String username) {
        return service.findByUsername(username);
    }

    @GetMapping(value = "/id")
    public @ResponseBody
    User getUserById(@RequestBody Long id) throws Exception {
        return service.findById(id);
    }

    @PostMapping(value = "/membership/new")
    public @ResponseBody
    void addNewMembershipToUser(@RequestBody String userData) {
        service.addNewMembershipToUser(userData);
    }

    @PostMapping(value = "/membership")
    public @ResponseBody
    void addMembershipToUser(@RequestBody String userData) {
        service.addMembershipToUser(userData);
    }
}
