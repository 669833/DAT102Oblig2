package no.hvl.dat102;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

import java.util.Iterator;

public class Medlem {

    private String navn;
    private MengdeADT<Hobby> hobbyer;
    private int statusIndeks; 

    public Medlem (String navn, MengdeADT<Hobby> hobbyer) {
        this.navn = navn;
        this.hobbyer = hobbyer;
        statusIndeks = -1;
    }

    public Medlem (String navn) {
        this.navn = navn;
        hobbyer = null;
        statusIndeks = -1;
    }


    public boolean passerTil(Medlem medlem2) {

    	boolean passer = true;
    	
        if (hobbyer.antall() != medlem2.hobbyer.antall()) {
            passer = false;
        }

        Iterator<Hobby> m1 = hobbyer.iterator();
        Iterator<Hobby> m2 = medlem2.hobbyer.iterator();
        
        while (m1.hasNext() && passer) {
            while (m2.hasNext()) {
                if (!m1.next().equals(m2.next()) ) {
                    passer = false;
                }
            }
        }
        return passer;
    }

    public void leggTilHobby(Hobby h) {
        if (hobbyer == null) {
            hobbyer = new KjedetMengde<>();
        }
        hobbyer.leggTil(h);
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setStatusIndeks(int indeks) {
        statusIndeks = indeks;
    }

    public int getStatusIndeks() {
        return statusIndeks;
    }

    public void setHobbyer(MengdeADT<Hobby> hobbyer) {
        this.hobbyer = hobbyer;
    }

    public MengdeADT<Hobby> getHobbyer() {
        return hobbyer;
    }
}