package hu.ordersystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainShowController {

	@RequestMapping("/left")
	public String left() {
		return "main/left";
	}
	
	@RequestMapping("/top")
	public String top() {
		return "main/top";
	}
	
	@RequestMapping("/right")
	public String right() {
		return "main/right";
	}
	
	@RequestMapping("/footer")
	public String footer() {
		return "main/footer";
	}
}
