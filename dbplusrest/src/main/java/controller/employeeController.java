package controller;

import entity.employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.employeeService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class employeeController {

    @Autowired
    private employeeService employeeService;


    @GetMapping("/hello")
    public String greet(){
        return "hello, 123456";
    }
    @GetMapping("/employees")
    public List<employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<employee> getEmployeeById(@PathVariable Long id) {
//        employee employee = employeeService.getEmployeeById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
//        return ResponseEntity.ok(employee);
//    }

    @PostMapping("/createEmployee")
    public employee createEmployee(@RequestBody employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<employee> updateEmployee(@PathVariable Long id, @RequestBody employee employeeDetails) {
        employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
