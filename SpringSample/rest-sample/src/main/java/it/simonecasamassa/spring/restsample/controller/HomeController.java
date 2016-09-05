package it.simonecasamassa.spring.restsample.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({ "/", "/homepage" })
// il metodo mappa entrambe le richieste 
// all'unico metodo home() perchè unico
public class HomeController {

	// @RequestMapping(value="/", method=GET) mapping 
	// a livello di metodo
	@RequestMapping(method = GET)
	public String home() {
		return "index";
	}
}

