package com.example.MyFirstWebServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rules")

public class MyFirstController {

	@GetMapping("/italian")
	public String italianRules() {
		return "Una prenotazione vale per un solo giorno e può essere effettuata solo se per quel giorno la postazione risulta libera.\n"
				+ "Un utente può ricercare le postazioni indicando il tipo di postazione desiderato e la città di interesse.\n"
				+ "Un utente può avere più prenotazioni in corso, ma non può prenotare più di una postazione per una particolare data.\n"
				+ "Una richiesta di prenotazione postazione può essere effettuata fino a due giorni prima della data scelta.";

	}

	@GetMapping("/english")
	public String englishRules() {
		return "A reservation is valid for one day only and can be made only if the seat is free for that day.\n"
				+ "A user can search for seats by indicating the type of seat desired and the city of interest.\n"
				+ "A user can have multiple reservations in progress, but cannot reserve more than one seat for a particular date.\n"
				+ "A seat reservation request can be made up to two days before the chosen date.";
	}

	@GetMapping("/")
	public String othersRules() {
		return "oops! Le lingue disponibili sono italiano ed inglese.\n"
				+ "oops! The available languages are Italian and English.";
	}
}
