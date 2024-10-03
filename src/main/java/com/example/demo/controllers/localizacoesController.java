package com.example.demo.controllers;

import com.example.demo.entities.Localizacao;
import com.example.demo.facade.LocalizacaoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class localizacoesController {

    private LocalizacaoFacade localizacaoFacade;

    @Autowired
    public localizacoesController(LocalizacaoFacade localizacoesFacade){
        this.localizacaoFacade = localizacoesFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Localizacao>> findAll() {
        List<Localizacao> localizacoes = this.localizacaoFacade.findAll();

        return new ResponseEntity<List<Localizacao>>(localizacoes, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Localizacao> findById(@PathVariable int id) {
        Localizacao empresa = this.localizacaoFacade.findById(id);

        return new ResponseEntity<Localizacao>(empresa, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Localizacao> save(@RequestBody Localizacao empresa) {
        Localizacao localizacoesSaved = localizacaoFacade.save(empresa);

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
