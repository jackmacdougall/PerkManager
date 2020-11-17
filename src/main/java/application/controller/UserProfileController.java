package application.controller;

import application.model.Profile;
import application.service.ProfileService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class UserProfileController {
    private final ProfileService service;

    private UserProfileController(ProfileService service) {
        this.service = service;
    }

    @GetMapping(value = "/login")
    public ResponseEntity<Object> login(@RequestParam("username") String username, @RequestParam("password") String password) throws NotFoundException {
        Profile profile = service.getProfile(username);
        if (profile == null) {
            throw new NotFoundException("Username not found");
        }
        if(profile.getPassword().equals(password)){
            return new ResponseEntity(profile, HttpStatus.OK);
        } else {
            throw new NotFoundException("Incorrect password");
        }
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public Profile createProfile(@RequestBody Profile profile){
        service.createProfile(profile);
        return profile;
    }
}
