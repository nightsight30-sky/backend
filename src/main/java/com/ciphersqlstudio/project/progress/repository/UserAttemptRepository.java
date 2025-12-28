package com.ciphersqlstudio.project.progress.repository;

import com.ciphersqlstudio.project.progress.entity.UserAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAttemptRepository extends JpaRepository<UserAttempt, Long> {

    Optional<UserAttempt> findByUserIdAndAssignmentId(String userId, Long assignmentId);
}
