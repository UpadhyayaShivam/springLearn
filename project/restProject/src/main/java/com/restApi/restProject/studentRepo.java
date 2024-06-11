package com.restApi.restProject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepo extends JpaRepository<studentEntity, Long> {

}
