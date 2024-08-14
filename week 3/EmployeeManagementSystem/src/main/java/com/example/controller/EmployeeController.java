package com.example.controller;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


public class EmployeeController {

    private EmployeeRepository employeeRepository;

    // Inject Employee Service(use constructor injection)
    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    // expose "/employees" endpoint to return list of employees
    @GetMapping("/employees")
    public List<Employee> employees()
    {
        return employeeRepository.findAll();
    }


    // expose endpoint to return single Employee
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee theEmployee = employeeRepository.getEmployee(employeeId);

        // Throw exception for bad request
        if(theEmployee==null)
            throw new RuntimeException("Employee Id not found--> "+employeeId);


        return theEmployee;
    }

    // expose endpoint to add an employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee)
    {
        //Also just in case they pass an id in JSON... set id to 0
        // this is to force a save of new item instead of update

        theEmployee.setId(0);

        Employee newEmployee = employeeRepository.updateEmployee(theEmployee);

        return newEmployee;

    }


    // expose endpoint to update an employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        Employee updatedEmployee = employeeRepository.updateEmployee(theEmployee);

        return updatedEmployee;
    }


    //expose endpoint to delete an employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId)
    {
        Employee theEmployee = employeeRepository.findById(employeeId).orElse(new Employee()) ;

        if(theEmployee==null)
            throw new RuntimeException("Employee not found--> "+employeeId);
        employeeRepository.deleteEmployee(employeeId);

        return ("Employee deleted with id--> "+ employeeId);
    }
}
