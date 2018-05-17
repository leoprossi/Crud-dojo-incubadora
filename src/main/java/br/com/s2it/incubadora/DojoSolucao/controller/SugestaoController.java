package br.com.s2it.incubadora.DojoSolucao.controller;

import br.com.s2it.incubadora.DojoSolucao.entity.SugestaoEntity;
import br.com.s2it.incubadora.DojoSolucao.service.SugestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sugestoes")
public class SugestaoController {

    @Autowired
    private SugestaoService service;

    @GetMapping("/")
    public ResponseEntity<List<SugestaoEntity>> getAll() {
        List<SugestaoEntity> l = service.findAll();
        return ResponseEntity.ok().body(l);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SugestaoEntity> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping("/")
    public void save(@RequestBody SugestaoEntity entity) {
        service.save(entity);
//        return ResponseEntity.ok().body(null);
        this.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody SugestaoEntity entity) {
        service.update(id, entity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
