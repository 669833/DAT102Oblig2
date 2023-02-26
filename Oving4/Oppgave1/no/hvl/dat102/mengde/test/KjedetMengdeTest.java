package no.hvl.dat102.mengde.test;

import no.hvl.dat102.mengde.test.MengdeADTTest;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

class KjedetMengdeTest extends MengdeADTTest{

	@Override
	protected MengdeADT<Integer> reset() {
		return new KjedetMengde<>();
	}

}
