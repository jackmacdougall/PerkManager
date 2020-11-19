package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @PostMapping("/login_success_handler")
    public String loginSuccessHandler() {
        return "index";
    }

    @PostMapping("/login_failure_handler")
    public String loginFailureHandler() { return "login"; }

}
