package assessment.emp.AssesmentEmployee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assessment.emp.AssesmentEmployee.entity.Employee;
import assessment.emp.AssesmentEmployee.repository.EmployeeRepository;
@Service
public class EmployeeRepositoryServiceImpls implements EmployeeRepositoryService {
	@Autowired
	private EmployeeRepository emprepo;

	@Override
	public List<Employee> getEmpList() {
		List<Employee> emp=emprepo.findAll();
		return emp;
	}

	@Override
	public Employee getById(long id) {
		Optional<Employee> findbyid=emprepo.findById(id);
		Employee emp=findbyid.get();
		return emp;
	}

	@Override
	public Employee saveEmp(Employee emp) {
		
		return emprepo.save(emp);
	}

	@Override
	public void deleteEmp(long id) {
		emprepo.deleteById(id);
	}

	@Override
	public Employee updateEmp(Employee emp) {
	
		return emprepo.save(emp);
	}

	
}
