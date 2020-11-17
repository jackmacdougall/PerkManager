package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private HomeController(){}

    @GetMapping(value = "/")
    public String load(Model model) {
        return "index";
    }

    @GetMapping(value = "/main")
    public String mainPage() { return "main"; }

}
