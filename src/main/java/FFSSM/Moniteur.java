/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.*;

public class Moniteur extends Plongeur {

    public int numeroDiplome;

    private TreeSet<Embauche> listeEmbauche = new TreeSet<>(Comparator.comparing(Embauche::getDebut));

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int numeroDiplome, GroupeSanguin groupe, int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, groupe, niveau);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     *
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        Embauche derniereEmbauche = listeEmbauche.last();
        if (derniereEmbauche.getFin() == null) return null;
        else {
            Club club = derniereEmbauche.getEmployeur();
            return Optional.of(club);
        }
    }

        /**
         * Enregistrer une nouvelle embauche pour cet employeur
         * @param employeur le club employeur
         * @param debutNouvelle la date de début de l'embauche
         */
        public void nouvelleEmbauche (Club employeur, LocalDate debutNouvelle){
            Moniteur moniteur = new Moniteur(this.numeroINSEE, this.nom, this.prenom, this.adresse, this.telephone, this.naissance, this.numeroDiplome, this.groupe, this.niveau);
            Embauche e = new Embauche(debutNouvelle, moniteur, employeur);
            listeEmbauche.add(e);
        }

        public List<Embauche> emplois () {
            return new ArrayList<Embauche>(listeEmbauche);
        }

    }

