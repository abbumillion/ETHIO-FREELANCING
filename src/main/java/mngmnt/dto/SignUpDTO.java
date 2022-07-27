package mngmnt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDTO {

    private String fullName;

    private String phoneNumber;

    private String email;

    private String password;

    private String confirmPassword;

    private String role;

    private boolean isActive = true;
}
