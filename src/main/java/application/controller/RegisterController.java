package application.controller;

import application.model.User;
import application.service.UserService;
import application.service.UserServiceImpl;
import application.web.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value="/register")
    public ModelAndView registrationPage() {
        return new ModelAndView("registration", "user", new UserRegistration());
    }

    @PostMapping(value = "/register")
    public ModelAndView processRegistration(@ModelAttribute("user") UserRegistration userRegistration) {
        User user = new User(userRegistration.getUsername(), bCryptPasswordEncoder.encode(userRegistration.getPassword()), "ROLE_USER");
        userService.save(user);
        return new ModelAndView("redirect:/login");
    }
}

