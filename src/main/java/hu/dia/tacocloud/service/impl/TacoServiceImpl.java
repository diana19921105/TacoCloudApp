package hu.dia.tacocloud.service.impl;

import hu.dia.tacocloud.model.data.Taco;
import hu.dia.tacocloud.repository.TacoRepository;
import hu.dia.tacocloud.service.TacoService;
import org.springframework.stereotype.Service;

@Service
public class TacoServiceImpl implements TacoService {

    private final TacoRepository tacoRepository;

    public TacoServiceImpl(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @Override
    public Taco save(Taco taco) {
        return tacoRepository.save(taco);
    }
}
