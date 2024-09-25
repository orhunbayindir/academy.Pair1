package com.etiya.academy.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {
    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    @Size(min = 11, max = 11, message = "Kimlik numarası 11 haneli olmalıdır.")
    private String identityNo;
}
