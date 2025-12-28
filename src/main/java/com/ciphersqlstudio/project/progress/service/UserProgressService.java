package com.ciphersqlstudio.project.progress.service;

import com.ciphersqlstudio.project.progress.dto.ProgressResponse;
import com.ciphersqlstudio.project.progress.dto.ProgressUpdateRequest;
import com.ciphersqlstudio.project.progress.entity.UserAttempt;
import com.ciphersqlstudio.project.progress.repository.UserAttemptRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserProgressService {

    private final UserAttemptRepository repository;

    public UserProgressService(UserAttemptRepository repository) {
        this.repository = repository;
    }

    public ProgressResponse recordAttempt(ProgressUpdateRequest req) {

        UserAttempt attempt = repository
                .findByUserIdAndAssignmentId(req.getUserId(), req.getAssignmentId())
                .orElseGet(() -> {
                    UserAttempt ua = new UserAttempt();
                    ua.setUserId(req.getUserId());
                    ua.setAssignmentId(req.getAssignmentId());
                    ua.setAttemptCount(0);
                    ua.setCompleted(false);
                    return ua;
                });

        attempt.setAttemptCount(attempt.getAttemptCount() + 1);
        attempt.setLastSql(req.getSql());
        attempt.setLastAttemptAt(LocalDateTime.now());

        if (req.isCompleted()) {
            attempt.setCompleted(true);
        }

        repository.save(attempt);

        return new ProgressResponse(
                attempt.getUserId(),
                attempt.getAssignmentId(),
                attempt.getAttemptCount(),
                attempt.isCompleted(),
                attempt.getLastAttemptAt()
        );
    }
}

