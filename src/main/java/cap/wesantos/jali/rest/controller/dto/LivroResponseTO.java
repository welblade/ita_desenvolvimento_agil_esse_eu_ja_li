package cap.wesantos.jali.rest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LivroResponseTO {
    private Long id;

    private String nome;

    private int paginas;

    private String categoria;
}
