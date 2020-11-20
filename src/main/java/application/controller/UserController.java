package application.controller;

import application.model.Membership;
import application.model.User;

import application.service.MembershipService;
import application.service.MembershipServiceImpl;
import application.service.UserService;
import application.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @GetMapping(value = "/username")
    public @ResponseBody
    User getUserByUsername(@RequestBody String username) {
        return service.findByUsername(username);
    }

    @GetMapping(value = "/id")
    public @ResponseBody
    User getUserById(@RequestBody Long id) {
        return service.findById(id).get();
    }

    @PostMapping(value = "/membership")
    public @ResponseBody
    void addMembershipToUser(@RequestBody User user, @RequestBody Membership membership) {
        user.addMembership(membership);
    }

}
