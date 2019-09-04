package kavineX;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @RequestMapping("/")
   	public String home(Model model) {
   		return "index.html";
    }
}