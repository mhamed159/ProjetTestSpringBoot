package com.mhamedbaguenne.projetSpringBoot.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Employee, Long> {


}

