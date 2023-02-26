package no.hvl.dat102;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Datakontakt {

	private final TabellMengde<Medlem> medlemmer;

	public Datakontakt(int antall) {
		medlemmer = new TabellMengde<>(antall);
	}

	public Datakontakt() {
		medlemmer = new TabellMengde<>();
	}


	public void leggTilMedlem(Medlem person) {
		medlemmer.leggTil(person);
	}

	public int finnMedlemsIndeks(String medlemsnavn) {
		int i = 0;
		for (Medlem m : medlemmer) {
			if (m.getNavn().contains(medlemsnavn)) {
				return i;
			}
			i++;
		}
		return -1;
	}


//	public int finnPartnerFor(Medlem medlem) {
//
//	}
//
//	public int finnBestePartnerFor(Medlem m) {
//
//	}
//
//	public void tilbakestillStatusIndeks(String medlemsnavn) {
//
//	}
}