package com.ciphersqlstudio.project.progress.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "user_attempts",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "assignment_id"})
)
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "assignment_id", nullable = false)
    private Long assignmentId;

    @Column(name = "last_sql", columnDefinition = "TEXT")
    private String lastSql;

    @Column(name = "attempt_count", nullable = false)
    private int attemptCount;

    @Column(name = "is_completed", nullable = false)
    private boolean completed;

    @Column(name = "last_attempt_at", nullable = false)
    private LocalDateTime lastAttemptAt;
}
