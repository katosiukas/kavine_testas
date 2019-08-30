package kavineX;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
// import duomenys.web.kavine.*;

@Controller
public class GreetingController {

    @GetMapping("/uzsakymai")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "uzsakymai";
    }
    
    @GetMapping("/produktai")
    public String patiekalai(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "produktai";
    }
    
    @GetMapping("/patiekalai")
    public String patiekalais(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "patiekalai";
    }
    
    @GetMapping("/uzsakymai795")
    public String uzsakymai(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "uzsakymai";
    } 
}