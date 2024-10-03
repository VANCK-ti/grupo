package com.example.demo.intefaces;

import com.example.demo.entities.Localizacao;

import java.util.List;

public interface ILocalizacaoInteface {

    public List<Localizacao> findAll();

    public Localizacao findById(int id);

    public Localizacao save(Localizacao base);

    public Localizacao update(int id, Localizacao base);

    public void deleteById(int id);
}