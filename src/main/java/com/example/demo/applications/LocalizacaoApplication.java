package com.example.demo.applications;

import com.example.demo.entities.Localizacao;
import com.example.demo.intefaces.ILocalizacaoInteface;
import com.example.demo.repositories.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
    public class LocalizacaoApplication {

    private ILocalizacaoInteface localizacoesRepository;

    @Autowired
    public LocalizacaoApplication(LocalizacaoRepository localizacaoRepository) {
        this.localizacoesRepository = localizacaoRepository;
    }

    public List<Localizacao> findAll() {
        return this.localizacoesRepository.findAll();
    }

    public Localizacao findById(int id) {
        return this.localizacoesRepository.findById(id);
    }

    public Localizacao save(Localizacao localizacoes) {
        return this.localizacoesRepository.save(localizacoes);
    }

    public Localizacao update(int id, Localizacao localizacoes) {
        Localizacao localizacoesInDb = localizacoesRepository.findById(id);

        if (localizacoesInDb == null) return null;

        return this.localizacoesRepository.update(id, localizacoes);
    }

    public void deleteById(int id) {
        this.localizacoesRepository.deleteById(id);
    }
}