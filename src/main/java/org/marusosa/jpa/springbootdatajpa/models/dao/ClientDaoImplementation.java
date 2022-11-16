package org.marusosa.jpa.springbootdatajpa.models.dao;

import org.marusosa.jpa.springbootdatajpa.models.entity.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
@Repository
public class ClientDaoImplementation implements ClientDaoInterface{
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly=true) //read only because we are only consulting
    @Override
    public List<Client> findAll() {
        return em.createQuery("from Client").getResultList();
    }
}
