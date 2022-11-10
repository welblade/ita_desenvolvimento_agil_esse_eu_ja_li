package cap.wesantos.jali.domain.mapper;

import cap.wesantos.jali.data.model.Livro;
import cap.wesantos.jali.data.model.LivroLido;
import cap.wesantos.jali.data.projection.LivroView;
import cap.wesantos.jali.rest.controller.dto.LivroResponseTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LivroMapper {
    LivroMapper CONVERT = Mappers.getMapper(LivroMapper.class);

    @Mapping(target = "categoria", source = "categoria.nome")
    @Mapping(target = "isLido", ignore = true)
    LivroResponseTO toResponseDTO(Livro livro);

    @Mapping(target = "isLido", source = "lido")
    LivroResponseTO toResponseDTO(LivroView livro);

    @Mapping(target = "id", source = "livro.id")
    @Mapping(target = "nome", source = "livro.nome")
    @Mapping(target = "paginas", source = "livro.paginas")
    @Mapping(target = "categoria", source = "livro.categoria.nome")
    @Mapping(target = "isLido", constant = "true")
    LivroResponseTO toResponseDTO(LivroLido livro);
}
