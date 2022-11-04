package cap.wesantos.jali.domain.mapper;

import cap.wesantos.jali.data.model.Livro;
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
}
