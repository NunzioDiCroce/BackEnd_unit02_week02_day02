package com.example.MyFirstWebServer;

import java.util.Set;

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

public class Utente {

	private long id;
	protected String userName;
	protected String nome;
	protected String mail;

	protected Set<Prenotazione> prenotazioni;

}
