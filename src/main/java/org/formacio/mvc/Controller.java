package org.formacio.mvc;

import org.formacio.repositori.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
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
		return agenda.telefon(id);
	}

}
