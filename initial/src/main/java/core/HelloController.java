package core;

import org.springframework.web.bind.annotation.RestController;

import database.DBRunner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String handler (Model model) {
		/*
		for(int i = 0 ; i < DBRunner.currency.length; i++) {
			String rsiLoc = DBRunner.currency[i].getCode() + "-rsi";
			String emaLoc = DBRunner.currency[i].getCode() + "-ema";
			double rsi = DBRunner.currency[i].getRSI();
			double ema = DBRunner.currency[i].getEMA();
			model.addAttribute(rsiLoc, rsi);
			model.addAttribute(emaLoc, ema);
		}
		model.addAttribute("okay", 21.51898734177216);
		/*
		for(int i = 0; i < DBRunner.currency.length; i++) {
			System.out.println(DBRunner.currency[i].getCode() + " " +  model.getAttribute(DBRunner.currency[i].getCode() + "-rsi"));
		}
		*/
	    return "myView";
	}

}
