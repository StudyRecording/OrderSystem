package hu.ordersystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dinnerView")
public class DinnerViewController {
	
	@RequestMapping("/dinnerView")
	public String dinnerView() {
		return "dinnerView/dinnerView";
	}

	
}
