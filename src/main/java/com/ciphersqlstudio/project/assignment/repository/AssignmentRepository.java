package com.ciphersqlstudio.project.assignment.repository;

import com.ciphersqlstudio.project.assignment.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}
