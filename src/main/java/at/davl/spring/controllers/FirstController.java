package at.davl.spring.controllers;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname,
            Model model){
    // how to use it with full Http request
    // return null if we don't have anything
    // public String helloPage(HttpServletRequest request){
        //String name = request.getParameter("name");
        //String surname = request.getParameter("surname");

        //System.out.println("Hello " + name + " " + surname + "!!!");
        model.addAttribute("message",
                "Hello,  " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}
