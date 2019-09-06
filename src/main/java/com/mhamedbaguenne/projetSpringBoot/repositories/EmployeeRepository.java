package com.mhamedbaguenne.projetSpringBoot.repositories;

import com.mhamedbaguenne.projetSpringBoot.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}

