package at.davl.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping("/calculator")
public class Calculator {

    @GetMapping("calc")
    public String calculator(
        @RequestParam(value = "firstInteger", required = false) String a,
        @RequestParam(value = "secondInteger", required = false) String b,
        @RequestParam(value = "action", required = false) String action,
        Model model)
    {
        int result = 0;

        System.out.println(action);

        if (Objects.equals(action, "plus")){
            result = Integer.parseInt(a ) + Integer.parseInt(b);
        } else if (Objects.equals(action, "minus")) {
            result = Integer.parseInt(a ) - Integer.parseInt(b);
        }

        model.addAttribute("result", a + action + b +
                "\nYour result is: " + result);

        return "calculator/calculator";
    }

}
