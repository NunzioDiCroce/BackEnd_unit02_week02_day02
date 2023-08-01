package com.example.MyFirstWebServer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UtenteService {

	// DEFINIZIONE ARRAYLIST DI UTENTI
	private List<Utente> utenti = new ArrayList<>();

	// METODO PER SALVARE UN UTENTE IN ARRAYLIST
	public Utente salva(Utente utente) {
		this.utenti.add(utente);
		return utente;

	}

	// METODO PER RECUPERARE GLI UTENTI
	public List<Utente> recuperaUtenti() {
		return this.utenti;
	}

	// METODO PER RECUPERARE UN UTENTE SPECIFICO
	public Optional<Utente> recuperaUtentePerId(long id) {
		Utente utenteCercato = null;
		for (Utente utente : utenti) {
			if (utente.getId() == id) {
				utenteCercato = utente;
			}
		}
		return Optional.ofNullable(utenteCercato);
	}

	// METODO PER ELIMINARE UN UTENTE SPECIFICO

}
