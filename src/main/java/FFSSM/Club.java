/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.*;

public class Club {
    public Moniteur president;
    public String nom;
    public String adresse;
    public String telephone;

    public Club(Moniteur président, String nom, String telephone) {
        this.president = président;
        this.nom = nom;
        this.telephone = telephone;
    }

    public ArrayList<Plongee> plongees = new ArrayList<>();
    public TreeSet<Plongee> plongeesNonConformes = new TreeSet<>(Comparator.comparing(Plongee::getDate));

    /**
     * Calcule l'ensemble des plongées non conformes organisées par ce club.
     * Une plongée est conforme si tous les plongeurs de la palanquée ont une licence
     * valide à la date de la plongée
     * @return l'ensemble des plongées non conformes
     */
    public Set<Plongee> plongeesNonConformes() {
        for(int i = 0; i<plongees.size(); i++){
            if (plongees.get(i).estConforme()==false){
                plongeesNonConformes.add(plongees.get(i));
            }
        }
        return plongeesNonConformes;
    }

    /**
     * Enregistre une nouvelle plongée organisée par ce club
     * @param p la nouvelle plongée
     */
    public void organisePlongee(Plongee p) {
        plongees.add(p);
    }
    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur président) {
        this.president = président;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

}
