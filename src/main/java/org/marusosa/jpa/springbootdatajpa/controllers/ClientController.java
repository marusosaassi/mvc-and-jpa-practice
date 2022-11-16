package org.marusosa.jpa.springbootdatajpa.controllers;

import org.marusosa.jpa.springbootdatajpa.models.dao.ClientDaoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientController {

    @Autowired
    //@Qualifier("clientDaoJPA")
    private ClientDaoInterface clientDaoInterface;

    @RequestMapping(value="/listClients", method= RequestMethod.GET)
    public String listClients(Model model) {
        //model is to pass data to the view
        model.addAttribute("title", "Client list");
        model.addAttribute("clients", clientDaoInterface.findAll());
        return "listClients";
    }
}
