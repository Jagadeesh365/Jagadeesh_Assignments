package in.lpu.Q5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {


	private  static  int limit=0;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = "/failure")
    public String failure(Model model){
        limit++;
        if(limit==3){
            limit=0;
            model.addAttribute("msg","limit exceeded");
           return "failure";

        }
        model.addAttribute("LoginError","error Your username and password are invalid.");
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
