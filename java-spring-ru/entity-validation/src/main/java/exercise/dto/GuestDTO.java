package exercise.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
public class GuestDTO {
    private long id;
    @NotBlank
    private String name;
    @Email
    @Column(unique = true)
    private String email;
    @Pattern(regexp = "^\\+\\d{11,13}$")
    private String phoneNumber;
    @Pattern(regexp = "^\\d{4}$")
    private String clubCard;
    @Future
    private LocalDate cardValidUntil;

    private LocalDate createdAt;
}
