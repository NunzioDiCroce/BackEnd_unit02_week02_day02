package com.example.MyFirstWebServer;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
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
	public void eliminaUtentePerId(long id) {
		ListIterator<Utente> iterator = this.utenti.listIterator(); // ITERATORE PER MODIFICARE UNA LISTA
		while (iterator.hasNext()) {
			Utente utenteCorrente = iterator.next();
			if (utenteCorrente.getId() == id) {
				iterator.remove();
			}
		}

	}

	// METODO PER AGGIORNARE UN UTENTE SPECIFICO
	public Optional<Utente> aggiornaUtentePerId(long id, Utente utente) {
		Utente utenteCercato = null;
		for (Utente utenteCorrente : utenti) {
			if (utenteCorrente.getId() == id) {
				utenteCercato = utenteCorrente;
				utenteCercato.setUserName(utente.getUserName());
				utenteCercato.setNome(utente.getNome());
				utenteCercato.setMail(utente.getMail());
				utenteCercato.setPrenotazioni(utente.getPrenotazioni());

			}

		}
		return Optional.ofNullable(utenteCercato);

	}

}
