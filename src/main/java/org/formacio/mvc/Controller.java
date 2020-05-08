package org.formacio.mvc;


import org.formacio.repositori.AgendaService;
import org.formacio.repositori.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private AgendaService agenda;
	
	@RequestMapping(path = "/nombre", method = RequestMethod.GET)
	@ResponseBody
	public int getName() {
		return agenda.nombreContactes();
	}
	
	@RequestMapping(path = "/telefon", method = RequestMethod.GET)
	@ResponseBody
	public String getPhone(@RequestParam String id) {
		return agenda.recupera(id).getTelefon();
	}
	
	@RequestMapping(path = "/contacte/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Persona getUser(@PathVariable("id") String id) {
		if (agenda.recupera(id) == null) {
			throw new OperationException();
		} else {
			return agenda.recupera(id);
		}
		
	}
	
	@RequestMapping(path = "/afegir", method = RequestMethod.POST)
	@ResponseBody
	public String addUser(@RequestParam String id, 
			@RequestParam String nom, 
			@RequestParam String telefon) {
		agenda.inserta(id, nom, telefon);
		return "ok";
	}

}
