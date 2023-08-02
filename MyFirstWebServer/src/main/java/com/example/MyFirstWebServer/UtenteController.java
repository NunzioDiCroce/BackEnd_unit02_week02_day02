package com.example.MyFirstWebServer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

	@Autowired
	UtenteService utenteService;

	// 1. - POST http://localhost:3001/utenti (+ req.body)
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED) // <-- 201
	public Utente saveUser(@RequestBody Utente body) {
		Utente utenteCreato = utenteService.salva(body);
		return utenteCreato;
	}

	// 2. - GET http://localhost:3001/utenti (+ opzionalmente query params)
	@GetMapping("")
	public List<Utente> getUsers() {
		return utenteService.recuperaUtenti();
	}

	// 3. - GET http://localhost:3001/utenti/{id}
	@GetMapping("/{userId}")
	public Utente findById(@PathVariable long userId) throws Exception {
		return utenteService.recuperaUtentePerId(userId).orElseThrow(() -> new Exception("NON TROVATO"));
	}

	// 4. - PUT http://localhost:3001/utenti/{id} (+ req.body)
	@PutMapping("/{userId}")
	public Utente findAndUpdate(@PathVariable long userId, @RequestBody Utente body) throws Exception {
		return utenteService.aggiornaUtentePerId(userId, body).orElseThrow(() -> new Exception("NON TROVATO"));
	}

	// 5. - DELETE http://localhost:3001/utenti/{id}
	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
	public void findAndDelete(@PathVariable long userId) {
		utenteService.eliminaUtentePerId(userId);
	}

}
