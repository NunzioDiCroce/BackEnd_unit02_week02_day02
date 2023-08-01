package com.example.MyFirstWebServer;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PostazioneService {

	// DEFINIZIONE ARRAYLIST DI POSTAZIONI
	private List<Postazione> postazioni = new ArrayList<>();

	// METODO PER SALVARE UNA POSTAZIONE IN ARRAYLIST
	public Postazione salva(Postazione postazione) {
		this.postazioni.add(postazione);
		return postazione;

	}

	// METODO PER RECUPERARE LE POSTAZIONI
	public List<Postazione> recuperaPostazioni() {
		return this.postazioni;
	}

	// METODO PER RECUPERARE UNA POSTAZIONE SPECIFICA
	public Optional<Postazione> recuperaPostazionePerId(long id) {
		Postazione postazioneCercata = null;
		for (Postazione postazione : postazioni) {
			if (postazione.getId() == id) {
				postazioneCercata = postazione;
			}
		}
		return Optional.ofNullable(postazioneCercata);
	}

	// METODO PER ELIMINARE UNA POSTAZIONE SPECIFICA
	public void eliminaPostazionePerId(long id) {
		ListIterator<Postazione> iterator = this.postazioni.listIterator(); // ITERATORE PER MODIFICARE UNA LISTA
		while (iterator.hasNext()) {
			Postazione postazioneCorrente = iterator.next();
			if (postazioneCorrente.getId() == id) {
				iterator.remove();
			}
		}

	}

	// METODO PER AGGIORNARE UNA POSTAZIONE SPECIFICA
	public Optional<Postazione> aggiornaPostazionePerId(long id, Postazione postazione) {
		Postazione postazioneCercata = null;
		for (Postazione postazioneCorrente : postazioni) {
			if (postazioneCorrente.getId() == id) {
				postazioneCercata = postazioneCorrente;
				postazioneCercata.setDescrizione(postazione.getDescrizione());
				postazioneCercata.setTipoPostazione(postazione.getTipoPostazione());
				postazioneCercata.setNumeroMassimoOccupanti(postazione.getNumeroMassimoOccupanti());
				postazioneCercata.setCitta(postazione.getCitta());
				postazioneCercata.setPrenotazioni(postazione.getPrenotazioni());

			}

		}
		return Optional.ofNullable(postazioneCercata);

	}

}
