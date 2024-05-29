package assessment.emp.AssesmentEmployee.Service;

import java.util.List;

import assessment.emp.AssesmentEmployee.entity.Employee;

public interface EmployeeRepositoryService {
public List<Employee> getEmpList();
public Employee getById(long id);
public Employee saveEmp(Employee emp);
public void deleteEmp(long id);
public Employee updateEmp(Employee emp);
}
