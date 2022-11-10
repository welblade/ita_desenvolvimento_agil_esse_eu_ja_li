package cap.wesantos.jali.domain.mapper;

import cap.wesantos.jali.data.model.Trofeu;
import cap.wesantos.jali.rest.controller.dto.TrofeuResponseTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TrofeuMapper {

    @Mapping(target = "categoria", source = "categoria.nome")
    TrofeuResponseTO toResponseTO(Trofeu trofeu);
}
