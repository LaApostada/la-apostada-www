package apostada.controladores;

//import apostada.servicios.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	//@Autowired
	//private UsersService usersService;

	@RequestMapping("/Home")
	public String greeting(Model model) {
		//model.addAttribute("name", usersService.getNumUsers() + " users");

		return "home";
	}
	
}
