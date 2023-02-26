package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste();
		liste[bak] = null;
		bak--;
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = foerste();
		bak--;
		for (int i = 0; i < bak; i++) {
			liste[i] = liste[i + 1];
		}
		liste[bak] = null;
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[bak - 1];
		return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {

		if (liste.length == bak) {
			utvid();
		} 

		boolean funnet = false;
		for (int i = 0; i < bak && !funnet; i++) {
			if (element.compareTo(liste[i]) < 0) {
				for (int j = bak - 1; j >= i; j--) {
					liste[j + 1] = liste[j];
				}
				liste[i] = element;
				funnet = true;
			}
		}
		if (!funnet) {
			liste[bak] = element;
		}

		bak++;
	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {

		int i = finn(element);

		if (i != -1) {
			for (int j = i; j < bak - 1; j++) {
				liste[j] = liste[j + 1];
			}
			bak--;
			liste[bak] = null;
			return element;
		}
		return null;

	}

	private int finn(T el) {

		int i = 0, resultat = IKKE_FUNNET;
		boolean found = false;

		while (i < liste.length && !found) {
			if (liste[i] != null) {
				if (liste[i].equals(el)) {
					found = true;
					return i;
				} else
					i++;
			}
		}
		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class