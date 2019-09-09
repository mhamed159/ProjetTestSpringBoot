package com.mhamedbaguenne.projetSpringBoot.controllers;

import com.mhamedbaguenne.projetSpringBoot.models.Employee;
import com.mhamedbaguenne.projetSpringBoot.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping()
    public ResponseEntity<Employee> create (@RequestBody @Valid final Employee employee, BindingResult result ){
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Emplpoyee not valid");
        }
        return new ResponseEntity<Employee>(employeeRepository.save(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll(){
        return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable long id) {

        return employeeRepository.findById(id);

    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable long id) {
        employeeRepository.deleteById(id);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Employee employee, @PathVariable long id) {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (!employeeOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        else {
            employee.setId(id);
            employeeRepository.save(employee);
        }
            return ResponseEntity.noContent().build();
    }

}
