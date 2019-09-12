package com.mhamedbaguenne.projetSpringBoot.repositories;


import com.mhamedbaguenne.projetSpringBoot.models.Employee;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;


    public Long createUser(Employee employee) {

        employeeRepository.save(employee);
        return employee.getId();
    }
    public Optional<Employee> getUserById(long id) {
        return  employeeRepository.findById(id);
    }

    public List<Employee> getAllById(long id) {
        return  employeeRepository.findAllById(Collections.singleton(id));
    }

    public void updateEmployee(Employee employee){

        employeeRepository.findById(employee.getId())
                .map(usr -> {
                    usr.setAdresse(employee.getAdresse());
                    usr.setId(employee.getId());
                    usr.setNom(employee.getNom());
                    usr.setPrenom(employee.getPrenom());
                    usr.setNuméro(employee.getNuméro());
                    return employeeRepository.save(usr);
                });

    }
    public void deleteEmployee(Long id){

        employeeRepository.deleteById(id);

    }


}