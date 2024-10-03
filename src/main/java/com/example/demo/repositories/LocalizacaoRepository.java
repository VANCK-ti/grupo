package com.example.demo.repositories;

import com.example.demo.entities.Localizacao;
import com.example.demo.intefaces.ILocalizacaoInteface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocalizacaoRepository implements ILocalizacaoInteface {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Localizacao> findAll() {
        String jpql = "SELECT e FROM localizacoes e";

        TypedQuery<Localizacao> query = entityManager.createQuery(jpql, Localizacao.class);

        return query.getResultList();
    }

    @Override
    public Localizacao findById(int id) {
        return entityManager.find(Localizacao.class, id);
    }

    @Override
    @Transactional
    public Localizacao save(Localizacao localizacao) {
        entityManager.persist(localizacao);

        return localizacao;
    }

    @Override
    @Transactional
    public Localizacao update(int id, Localizacao localizacao) {
        Localizacao localizacaoInDb = entityManager.find(Localizacao.class, id);

        localizacaoInDb.setEndereco(localizacao.getEndereco());

        return entityManager.merge(localizacaoInDb);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Localizacao localizacoesInDb = entityManager.find(Localizacao.class, id);

        if (localizacoesInDb != null) {
            entityManager.remove(localizacoesInDb);
        }
    }
}