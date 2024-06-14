package dh.backend.clinicamvc.Dto.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PacienteResponseDto {
    private Integer id;
    private String apellido;
    private String nombre;
    private String dni;
    private LocalDate fechaIngreso;
}
