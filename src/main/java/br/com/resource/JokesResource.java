package br.com.resource;

import br.com.service.JokesService;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.Application;

public class JokesResource {

    private JokesService jokesService;

    public JokesResource(JokesService jokesService) {
        this.jokesService = jokesService;
    }

    @Consumes("application/json")
    public String getCategories(){
        return null;
    }
}
