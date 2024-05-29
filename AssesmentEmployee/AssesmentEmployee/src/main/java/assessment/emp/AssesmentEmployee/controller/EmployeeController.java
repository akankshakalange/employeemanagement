package assessment.emp.AssesmentEmployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



import assessment.emp.AssesmentEmployee.Service.EmployeeRepositoryService;
import assessment.emp.AssesmentEmployee.entity.Employee;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@Transactional
public class EmployeeController {
	@Autowired
	private EmployeeRepositoryService empser;
	@GetMapping("/add/emp")
	public String getEmpList(Model model) {
		model.addAttribute("newEmp",new Employee());
		return "newemployee";
		
	}
	
	@PostMapping("/employeeaction")
	public String getNewBook(@Valid @ModelAttribute("newEmp") Employee emp ,BindingResult br,Model model ) {
		if(br.hasErrors()) {
			return "newemployee";
		}
		empser.saveEmp(emp) ;
		model.addAttribute("msg","Employee added sucessfully!");
		return "newemployee";
		
	}
	
	@GetMapping("/existingemp")
	public String getExistingEmployee(Model model ) {
		List<Employee> existingemp=empser.getEmpList();
		model.addAttribute("employees",existingemp);
		return "existingemp";
	}
	

@PostMapping("/emp/delete")
public String deleteEmployee(@RequestParam("id") long id) {
	empser.deleteEmp(id);
	return "redirect:/existingemp";
	
}

@GetMapping("/emp/update")
public String updateEmployeeForm(@RequestParam("id") long id,Model model) {
	Employee employee=empser.getById(id);
	model.addAttribute("employee",employee);
	
	return "update_form";
	
}

@PostMapping("emp/edit")
public String getEmployeeUpdate(@Valid @ModelAttribute("employee") Employee empl,BindingResult br) {
	if(br.hasErrors()) {
		return "update_form";
	}
	empser.updateEmp(empl);
	return "redirect:/existingemp";
			
}
}
