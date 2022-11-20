package org.marusosa.jpa.springbootdatajpa.controllers;

import org.marusosa.jpa.springbootdatajpa.models.dao.ClientDaoInterface;
import org.marusosa.jpa.springbootdatajpa.models.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ClientController {

    @Autowired
    //@Qualifier("clientDaoJPA")
    private ClientDaoInterface clientDaoInterface;

    @RequestMapping(value="/listClients", method=RequestMethod.GET)
    public String listClients(Model model) {
        //model is to pass data to the view
        model.addAttribute("title", "Client list");
        model.addAttribute("clients", clientDaoInterface.findAll());
        return "listClients";
    }

    @RequestMapping(value="/form")
    public String create(Map<String, Object> model){
        Client client = new Client();
        model.put("client", client);
        model.put("title", "Form");
        return "form";
    }

    @RequestMapping(value="/form", method=RequestMethod.POST)
    public String save(Client client){
        clientDaoInterface.save(client);
        return "redirect:listClients";
    }
}
