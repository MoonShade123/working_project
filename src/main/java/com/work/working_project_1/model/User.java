package com.work.working_project_1.model;

import com.work.working_project_1.commons.UserRole;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private String username;

    @NotNull
    private String password;

    @Builder.Default
    private LocalDateTime registrationTime = LocalDateTime.now();

    @Column(unique = true)
    @NotNull
    private String phoneNumber;

    @Builder.Default
    private UserRole userRole = UserRole.USER;

}
