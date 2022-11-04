package cap.wesantos.jali.domain.service;

import cap.wesantos.jali.core.exception.LivroNaoEncontradoException;
import cap.wesantos.jali.data.repository.LivroRepository;
import cap.wesantos.jali.domain.mapper.LivroMapper;
import cap.wesantos.jali.rest.controller.dto.LivroResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    LivroRepository repository;

    @Override
    public List<LivroResponseTO> listarLivros() {
        return repository.findAll().stream()
                .map(LivroMapper.CONVERT::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LivroResponseTO obterPorId(Long id) {
        return repository.findById(id)
                .map(LivroMapper.CONVERT::toResponseDTO)
                .orElseThrow(LivroNaoEncontradoException::new);
    }
}
