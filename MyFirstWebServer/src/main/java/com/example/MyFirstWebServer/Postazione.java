package com.example.MyFirstWebServer;

import java.util.Set;

public class Postazione {

	private long id;

	protected String descrizione;

	@Enumerated(EnumType.STRING)
	protected TipoPostazione tipoPostazione;

	protected int numeroMassimoOccupanti;

	private String citta;

	protected Set<Prenotazione> prenotazioni;
}
