package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Plongeur extends Personne {

    public int niveau;

    private TreeSet<Licence> listeLicence = new TreeSet<>(Comparator.comparing(Licence::getDelivrance));

    public Plongeur (String numeroInsee, String nom, String prenom, String adresse, String telephone, LocalDate naissance, GroupeSanguin groupe, int niveau)
    {
        super(numeroInsee,nom,prenom,adresse,telephone,naissance,groupe);
        this.niveau = niveau;
    }

    public void ajouteLicence(String numero, LocalDate delivrance, Club club){
        Plongeur plongeur = new Plongeur(this.numeroINSEE, this.nom, this.prenom, this.adresse, this.telephone,this.naissance,this.groupe,this.niveau);
        Licence licence = new Licence(plongeur, numero, delivrance, club);
        listeLicence.add(licence);
    }

    public Licence derniereLicence(){
        Licence derniereLicence = listeLicence.last();
        return derniereLicence;
    }

    public ArrayList<Licence> listeLicence() {
        ArrayList<Licence> arrayLicence = new ArrayList<Licence>(listeLicence);
        return arrayLicence;
    }
}
