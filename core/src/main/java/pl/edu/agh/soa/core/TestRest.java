package pl.edu.agh.soa.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestRest {
	
	User user;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String getUser(){
		user = new User();
		user.setName("Aga");
//		user.setAge(22);
		return "This is rest test ;)";
//		return user;
	}
	
	
}
