package dev.sb.mb.model;

import lombok.*;

import javax.validation.constraints.*;

@Setter
@Getter
public class Student {
    private Long id;

    @NotBlank
    @Size(max = 60)
    private String userName;

    @NotBlank
    @Email
    @Size(max = 254)
    private String email;
}
