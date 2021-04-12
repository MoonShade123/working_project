package com.work.working_project_1.model;

import com.work.working_project_1.phoneValidation.Phone;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @ApiModelProperty(hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Username must be filled")
    private String username;

    @NotBlank(message = "Password must be filled")
    private String password;

    @ApiModelProperty(hidden = true)
    private LocalDateTime registrationTime = LocalDateTime.now();

    @Column(unique = true)
    @NotBlank(message = "Phone number must be filled")
    @Phone
    @Size(min = 8, max = 13)
    private String phoneNumber;

    @ApiModelProperty(hidden = true)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Users_role",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))

    private Collection<Role> role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                username.equals(user.username) &&
                password.equals(user.password) &&
                Objects.equals(registrationTime, user.registrationTime) &&
                phoneNumber.equals(user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, registrationTime, phoneNumber);
    }
}
