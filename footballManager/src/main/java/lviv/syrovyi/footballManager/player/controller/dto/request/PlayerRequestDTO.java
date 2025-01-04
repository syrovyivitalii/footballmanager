package lviv.syrovyi.footballManager.player.controller.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerRequestDTO {
    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Min(value = 16, message = "Age must be at least 16")
    @Max(value = 65, message = "Age must be at most 65")
    private Integer age;

    @Max(value = 50, message = "Experience must be at most 50")
    private Integer experience;

    @NotNull(message = "Team is mandatory")
    private UUID teamId;
}
