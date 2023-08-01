package com.example.MyFirstWebServer;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j

public class Prenotazione {

	private long id;

	protected Utente utente;

	protected LocalDate dataPrenotazione;

	protected Postazione postazione;

}
