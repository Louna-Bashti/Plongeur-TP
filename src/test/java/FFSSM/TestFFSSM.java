package FFSSM;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestFFSSM {

    Plongeur untel;

    Moniteur untelprof;

    Club bidule;

    Plongee plongee;

    Site site;

    Embauche embauch1;
    Licence licence, anciennelicence;

    @BeforeEach
    public void setUp()
    {
        untel = new Plongeur(1,"Dupont","Jean","81100 Castres","0567676767",LocalDate.of(2000,10,26),GroupeSanguin.APLUS,1);
        untelprof = new Moniteur(2,"Durand","JP","81100 Castres","0757575757",LocalDate.of(2000,10,26),GroupeSanguin.BMOINS,3);
        bidule = new Club(untelprof,"Les Pataugeurs","0562626262");
        plongee = new Plongee(site,untelprof,LocalDate.of(2022,03,25),50,60);
        site = new Site("Valras", "lorem ipsum");
        embauch1 = new Embauche(LocalDate.of(2020,10,18),untelprof,bidule);
        licence = new Licence(untel,"2",LocalDate.of(2020,10,1),bidule);
        anciennelicence = new Licence(untel,"3", LocalDate.of(2000,1,1),bidule);

    }

    @Test
    public void testLicenceAjoutee() {
        untel.ajouteLicence("2",LocalDate.of(2022,1,1),bidule);
        assertEquals(1, untel.listeLicence().size(),"Il devrait y avoir une licence dans la liste");
    }

    @Test
    public void testLicenceValide() {
        assertEquals(true,licence.estValide(LocalDate.of(2022,10,10)),"La licence devrait être valide");
        assertEquals(false,anciennelicence.estValide(LocalDate.of(2022,10,10)),"La licence ne devrait pas être valide");
    }

    @Test
    public void testPlongeeConforme()
    {
        untel.ajouteLicence("4",LocalDate.of(2000,1,1), bidule);
        plongee.ajouteParticipant(untel);
        assertEquals(false,plongee.estConforme(),"La plongée ne devrait pas être conforme");

        untel.ajouteLicence("4",LocalDate.of(2022,1,1), bidule);
        plongee.ajouteParticipant(untel);
        assertEquals(false,plongee.estConforme(),"La plongée devrait être conforme");
    }








}
