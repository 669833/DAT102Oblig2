package no.hvl.dat102.mengde.test;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

class TabellMengdeTest extends MengdeADTTest{

	@Override
	protected MengdeADT<Integer> reset() {
		return new TabellMengde<>();
	}

}