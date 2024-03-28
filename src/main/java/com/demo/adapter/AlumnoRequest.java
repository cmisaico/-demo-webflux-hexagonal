package com.demo.adapter;

import com.demo.domain.Estado;
import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class AlumnoRequest {
    @NotNull(message = "{alumno.id.vacio}")
    @NonNull
    private Long id;

    @NotBlank(message = "{alumno.nombre.vacio}")
    @Size(min = 3, max = 50, message = "{user.nombre.longitud}")
    private String nombre;

    @NotBlank(message = "{alumno.apellido.vacio}")
    @Size(min = 3, max = 50, message = "{user.apellido.longitud}")
    private String apellido;

    @NotNull(message = "{alumno.estado.nulo}")
    private Estado estado;

    @Min(value = 18, message = "{alumno.edad.menor}")
    @Max(value = 40, message = "{alumno.edad.mayor}")
    private int edad;
}
