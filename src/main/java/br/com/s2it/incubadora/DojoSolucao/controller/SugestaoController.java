package br.com.s2it.incubadora.DojoSolucao.controller;

import br.com.s2it.incubadora.DojoSolucao.entity.SugestaoEntity;
import br.com.s2it.incubadora.DojoSolucao.service.SugestaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Slf4j
@CrossOrigin("*")
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

    @PostMapping(value = "/" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> save(@RequestBody SugestaoEntity sugestao, UriComponentsBuilder builder) {
        service.save(sugestao);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/{id}").buildAndExpand(sugestao.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody SugestaoEntity entity) {
        service.update(id, entity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
