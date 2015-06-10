package pl.edu.agh.soa.ba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {
	
	@RequestMapping(value = "/")
	public final ModelAndView initialRequest(){
		return new ModelAndView("index");
	}
}
