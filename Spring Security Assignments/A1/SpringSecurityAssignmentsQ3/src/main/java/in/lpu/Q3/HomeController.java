package in.lpu.Q3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");

		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");

		return "login";


	}
	@GetMapping("/")
	public String  showHome() {
		return "HomePage";

	}

	@GetMapping("/welcome")
	public String  showWelcome() {
		return "WelcomePage";

	}

	@GetMapping("/admin")
	public String  showAdmin() {
		return "AdminPage";

	}

	@GetMapping("/emp")
	public String  showEmployee() {
		return "EmployeePage";

	}
	@GetMapping("/std")
	public String  showStudent() {
		return "StudentPage";

	}

	@GetMapping("/denied")
	public String  showDenied() {
		return "DeniedPage";

	}





}
