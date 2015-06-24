package ar.edu.unlam.tallerweb.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb.domain.Persona;

@Controller
//@RequestMapping("/prueba")
public class controladorPrueba {
	
	@RequestMapping("/inicial")
	public  ModelAndView pruebaInicial(){
		ModelAndView modelAndView = new ModelAndView("primeraVista");
		return modelAndView;		
	}
	@RequestMapping("/otro")
	public ModelAndView otraPrueba(@RequestParam(required=false)String nombre, String apellido){
		System.out.println(nombre+apellido);
		ModelAndView modelAndView = new ModelAndView("segundaVista");
		modelAndView.addObject("saludo", nombre + "-" + apellido + "capo");
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/mapa", method = RequestMethod.GET)
	public ModelAndView map(){
		ModelMap miMapa = new ModelMap();
		miMapa.put("nombre", "Laura");
		miMapa.put("apellido", "Tula");
		ModelAndView miVista= new ModelAndView();
		miVista.addAllObjects(miMapa);
		miVista.setViewName("mapa");
		return miVista;
		}
	
	@RequestMapping(value="/nombre/{nombre}/apellido/{apellido}", method = RequestMethod.GET)
	public ModelAndView holaREST(@PathVariable String nombre,@PathVariable String apellido){
		ModelMap miMapa = new ModelMap();
		miMapa.addAttribute("nombre", nombre);
		miMapa.addAttribute("apellido", apellido);
		ModelAndView miVista=new ModelAndView();
		miVista.addAllObjects(miMapa);
		miVista.setViewName("mapa");
		return miVista;
	}
	
	@RequestMapping(value="/lista", method=RequestMethod.GET)
	public ModelAndView lista(){
		ModelMap miMapa = new ModelMap();
		List<Persona> lista = new LinkedList<Persona>();
		Persona p1= new Persona();
		Persona p2= new Persona();
		p1.setNombre("Lara");
		p2.setNombre("Lara2");
		lista.add(p1);
		lista.add(p2);
		miMapa.put("lista",lista);
		return null;
		
	}
}
