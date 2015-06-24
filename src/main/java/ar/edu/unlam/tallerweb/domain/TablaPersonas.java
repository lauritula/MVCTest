package ar.edu.unlam.tallerweb.domain;

import java.util.LinkedList;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class TablaPersonas {
    
    private static TablaPersonas instance = new TablaPersonas();
    private List<Persona> personas = new LinkedList<Persona>();
    private TablaPersonas(){}
    
    public static TablaPersonas getInstance(){
        return instance;
    }
    
    public Boolean crearPersona(Persona persona){
        return this.personas.add(persona);
    }

    public List<Persona> listarTodas(){
        return this.personas;
    }
    
    
}
