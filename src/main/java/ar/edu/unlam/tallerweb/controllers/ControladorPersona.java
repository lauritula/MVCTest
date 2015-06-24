package ar.edu.unlam.tallerweb.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb.domain.Persona;
import ar.edu.unlam.tallerweb.domain.TablaPersonas;

@Controller
public class ControladorPersona {

	//singleton
	@RequestMapping(value="/listaPersonas", method = RequestMethod.GET)
	public ModelAndView lista(){
			ModelMap miLista = new ModelMap();
			TablaPersonas lista = TablaPersonas.getInstance();
			Persona p1= new Persona();
			Persona p2= new Persona();
			p1.setNombre("Laura");
			p2.setNombre("Juliana");
			lista.crearPersona(p1);
			lista.crearPersona(p2);
			miLista.put("lista",lista.listarTodas());
			ModelAndView miVista= new ModelAndView();
			miVista.addAllObjects(miLista);
			miVista.setViewName("listaPersonas");
			return miVista;
		}
}
