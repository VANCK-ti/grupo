package com.example.demo.facade;

import com.example.demo.applications.LocalizacaoApplication;
import com.example.demo.entities.Localizacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocalizacaoFacade {

    private LocalizacaoApplication localizacaoApplication;

    @Autowired
    public LocalizacaoFacade(LocalizacaoApplication localizacaoApplication) {
        this.localizacaoApplication = localizacaoApplication;
    }

    public List<Localizacao> findAll() {
        return this.localizacaoApplication.findAll();
    }


    public Localizacao findById(int id) {
        return this.localizacaoApplication.findById(id);
    }


    public Localizacao save(Localizacao localizacoes) {
        return this.localizacaoApplication.save(localizacoes);
    }


    public Localizacao update(int id, Localizacao localizacoes) {
        return this.localizacaoApplication.update(id, localizacoes);
    }


    public void deleteById(int id) {
        this.localizacaoApplication.deleteById(id);
    }
}