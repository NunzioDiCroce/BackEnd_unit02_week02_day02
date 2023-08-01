package com.example.MyFirstWebServer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UtenteService {

	// DEFINIZIONE ARRAYLIST DI UTENTI
	private List<Utente> utenti = new ArrayList<>();

	// METODO PER SALVARE UN UTENTE IN ARRAYLIST
	public Utente save(Utente utente) {
		this.utenti.add(utente);
		return utente;

	}

	// METODO PER RECUPERARE GLI UTENTI
	public List<Utente> getUtenti() {
		return this.utenti;
	}

}
