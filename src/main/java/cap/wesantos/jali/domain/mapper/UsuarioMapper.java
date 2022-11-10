package cap.wesantos.jali.domain.mapper;

import cap.wesantos.jali.data.model.Usuario;
import cap.wesantos.jali.rest.controller.dto.PerfilUsuarioResponseTO;
import cap.wesantos.jali.rest.controller.dto.UsuarioResponseTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { TrofeuMapper.class, LivroMapper.class})
public interface UsuarioMapper {
    UsuarioMapper CONVERT = Mappers.getMapper(UsuarioMapper.class);

    UsuarioResponseTO toResponseTO (Usuario usuario);
    PerfilUsuarioResponseTO toPerfilResponseTO(Usuario usuario);
}
