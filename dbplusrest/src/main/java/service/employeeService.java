package service;


import entity.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.employeeRepo;

import java.util.List;

@Service
public class employeeService {
    @Autowired
    private employeeRepo  employeeRepository;
    public List<employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

//    public Optional<employee> getEmployeeById(Long id) {
//        return employeeRepository.findById(id);
//    }

    public employee createEmployee(employee employee) {
        return employeeRepository.save(employee);
    }

    public employee updateEmployee(Long id, employee employeeDetails) {
        employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.delete(employee);
    }


}
