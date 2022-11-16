package org.marusosa.jpa.springbootdatajpa.models.dao;

import org.marusosa.jpa.springbootdatajpa.models.entity.Client;

import java.util.List;

public interface ClientDaoInterface {
    public List<Client> findAll();
}
