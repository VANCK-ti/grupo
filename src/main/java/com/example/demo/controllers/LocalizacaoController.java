package com.example.demo.controllers;

import com.example.demo.entities.Localizacao;
import com.example.demo.facade.LocalizacaoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localizacoes")
public class LocalizacaoController {

    private LocalizacaoFacade localizacaoFacade;

    @Autowired
    public LocalizacaoController(LocalizacaoFacade localizacoesFacade) {
        this.localizacaoFacade = localizacoesFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Localizacao>> findAll() {
        List<Localizacao> localizacoes = this.localizacaoFacade.findAll();

        return new ResponseEntity<>(localizacoes, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Localizacao> findById(@PathVariable int id) {
        Localizacao localizacao = this.localizacaoFacade.findById(id);

        if (localizacao == null)
            return new ResponseEntity<Localizacao>(localizacao, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Localizacao>(localizacao, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Localizacao> save(@RequestBody Localizacao localizacao) {
        Localizacao localizacoesSaved = localizacaoFacade.save(localizacao);

        return new ResponseEntity<Localizacao>(localizacoesSaved, HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Localizacao> update(
            @PathVariable int id,
            @RequestBody Localizacao localizacoes) {

        Localizacao localizacoesUpdated = localizacaoFacade.update(id, localizacoes);

        if (localizacoesUpdated == null)
            return new ResponseEntity<Localizacao>(localizacoesUpdated, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Localizacao>(localizacoesUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        localizacaoFacade.deleteById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
