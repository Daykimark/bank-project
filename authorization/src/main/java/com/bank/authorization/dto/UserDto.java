package com.bank.authorization.dto;

import com.bank.authorization.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO для {@link UserEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private Long id;

    @NotNull
    private String role;

    @NotNull
    private Long profileId;

    @NotNull
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final UserDto user = (UserDto) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(role, user.role) &&
                Objects.equals(profileId, user.profileId) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, profileId, password);
    }
}
