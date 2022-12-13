/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Plongee {
	public Site lieu;
	public Moniteur chefDePalanquee;
	public LocalDate date;
	public int profondeur;
	public int duree;
	public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
		this.lieu = lieu;
		this.chefDePalanquee = chefDePalanquee;
		this.date = date;
		this.profondeur = profondeur;
		this.duree = duree;
	}

	private HashSet<Plongeur> listeParticipants = new HashSet<>();

	public void ajouteParticipant(Plongeur participant) {
		listeParticipants.add(participant);
	}

	public LocalDate getDate() {
		return date;
	}

	/**
	 * Détermine si la plongée est conforme. 
	 * Une plongée est conforme si tous les plongeurs de la palanquée ont une
	 * licence valide à la date de la plongée
	 * @return vrai si la plongée est conforme
	 */
	public boolean estConforme() {
		ArrayList<Plongeur> listeParticipantsArray = new ArrayList<>(listeParticipants);
		boolean conforme = true;
		int i = 0;
		while (conforme == true && i<listeParticipantsArray.size())
		{
			if(listeParticipantsArray.get(i).derniereLicence().estValide(this.date) == false) {
				conforme = false;
			}
			else i++;
		}
		return conforme;
	}

}
