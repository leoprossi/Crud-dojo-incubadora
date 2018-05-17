package br.com.s2it.incubadora.DojoSolucao.service;

import br.com.s2it.incubadora.DojoSolucao.entity.SugestaoEntity;
import br.com.s2it.incubadora.DojoSolucao.repository.SugestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.spi.LocaleNameProvider;

@Service
public class SugestaoService {

    @Autowired
    private SugestaoRepository repository;

    public List<SugestaoEntity> findAll() {
        return (List<SugestaoEntity>) repository.findAll();
    }

    public SugestaoEntity findById(Long id) throws NoSuchElementException {
        Optional<SugestaoEntity> opt = repository.findById(id);
        if(opt.get() == null) {
            throw new NoSuchElementException();
        }
        return opt.get();
//        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Elementon encontrado"));
    }

    public void save(SugestaoEntity entity) {
        repository.save(entity);
    }

    public void update(Long id, SugestaoEntity entity) {
//        SugestaoEntity s = findById(id);
        entity.setId(id);
        repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
