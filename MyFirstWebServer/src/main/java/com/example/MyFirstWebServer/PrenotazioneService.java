package com.example.MyFirstWebServer;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {

	// DEFINIZIONE ARRAYLIST DI PRENOTAZIONI
	private List<Prenotazione> prenotazioni = new ArrayList<>();

	// METODO PER SALVARE UNA PRENOTAZIONE IN ARRAYLIST
	public Prenotazione salva(Prenotazione prenotazione) {
		this.prenotazioni.add(prenotazione);
		return prenotazione;

	}

	// METODO PER RECUPERARE LE PRENOTAZIONI
	public List<Prenotazione> recuperaPrenotazioni() {
		return this.prenotazioni;
	}

	// METODO PER RECUPERARE UNA PRENOTAZIONE SPECIFICA
	public Optional<Prenotazione> recuperaPrenotazionePerId(long id) {
		Prenotazione prenotazioneCercata = null;
		for (Prenotazione prenotazione : prenotazioni) {
			if (prenotazione.getId() == id) {
				prenotazioneCercata = prenotazione;
			}
		}
		return Optional.ofNullable(prenotazioneCercata);
	}

	// METODO PER ELIMINARE UNA PRENOTAZIONE SPECIFICA
	public void eliminaPrenotazionePerId(long id) {
		ListIterator<Prenotazione> iterator = this.prenotazioni.listIterator(); // ITERATORE PER MODIFICARE UNA LISTA
		while (iterator.hasNext()) {
			Prenotazione prenotazioneCorrente = iterator.next();
			if (prenotazioneCorrente.getId() == id) {
				iterator.remove();
			}
		}

	}

	// METODO PER AGGIORNARE UNA PRENOTAZIONE SPECIFICA
	public Optional<Prenotazione> aggiornaPrenotazionePerId(long id, Prenotazione prenotazione) {
		Prenotazione prenotazioneCercata = null;
		for (Prenotazione prenotazioneCorrente : prenotazioni) {
			if (prenotazioneCorrente.getId() == id) {
				prenotazioneCercata = prenotazioneCorrente;
				prenotazioneCercata.setUtente(prenotazione.getUtente());
				prenotazioneCercata.setDataPrenotazione(prenotazione.getDataPrenotazione());
				prenotazioneCercata.setPostazione(prenotazione.getPostazione());

			}

		}
		return Optional.ofNullable(prenotazioneCercata);

	}

}
