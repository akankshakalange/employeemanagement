package assessment.emp.AssesmentEmployee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DashBoardController {
	
		@GetMapping("/gotoaddashboard")
	public String getDashboard() {
		return "Dashbord";
	}
}
