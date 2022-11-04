package cap.wesantos.jali.domain.service;

import cap.wesantos.jali.data.repository.LivroRepository;
import cap.wesantos.jali.domain.mapper.LivroMapper;
import cap.wesantos.jali.rest.controller.dto.LivroResponseTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class LivroServiceImpl implements LivroService {

    @Autowired
    LivroRepository repository;

    @Override
    public List<LivroResponseTO> listarLivros() {
        return repository.findAll().stream()
                .map(LivroMapper.CONVERT::toResponseDTO)
                .collect(Collectors.toList());
    }
}
