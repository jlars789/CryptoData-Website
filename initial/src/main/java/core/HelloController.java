package core;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String handler (Model model) {
		System.out.println("Reloaded");
	    return "myView";
	}

}
