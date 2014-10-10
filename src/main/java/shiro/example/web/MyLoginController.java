package shiro.example.web;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyLoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
        System.out.println("Dispatch Login page");
		return "login";
	}

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginFail(HttpServletRequest request){
        System.out.println("Login failed");
        return "login";
    }

    @RequestMapping(value = "/home.page", method = RequestMethod.GET)
    public String home(){
        return "home";
    }
	
}
