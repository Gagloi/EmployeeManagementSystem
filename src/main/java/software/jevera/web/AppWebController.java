package software.jevera.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppWebController {

    @GetMapping(value = "/helloworld")
    public String helloworld(Model model, @RequestParam("name") String name){
        model.addAttribute("name", name);
        return "helloworld";
    }

}