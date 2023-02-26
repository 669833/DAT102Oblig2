package no.hvl.dat102.parentes;


import no.hvl.dat102.adt.Parentessjekker;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class ParentessjekkerClass implements Parentessjekker {

	@Override
	public boolean erVenstreparentes(char x) {
		
		return (x == '(') || x == '[' || x == '{';
	}

	@Override
	public boolean erHogreparentes(char x) {

		return (x == ')') || x == ']' || x == '}';
	}

	@Override
	public boolean erPar(char venstre, char hoyre) {

		if ('{' == venstre && '}' == hoyre) {
			return true;
		} else if ('(' == venstre && ')' == hoyre) {
			return true;
		} else if ('[' == venstre && ']' == hoyre) {
			return true;
		} else
			return false;
	}
	
	@Override
	private boolean erParantes(char x, char[] liste) {

		return erHogreparentes(liste[x]) || erVenstreparentes(liste[x]);
	}	

	@Override
	public boolean erBalansert(String s) {
		char c;
		char venstre, hoyre, forste;
		int teller = 0;
		for (int i = s.length()-1; i >= 0; i--) {
			c = s.charAt(i);
			if (erParentes(c)) {
				stack.push((Character) c);
				teller++;
			}
		}//Legt til alle parantesene
		if(teller%2 == 1) { //En av paratesene har ingen partner
			return false;
		}

		while(!stack.erTom()) {
			venstre = stack.pop();
			while(erVenstreparentes(venstre) && erVenstreparentes(stack.peek())) {
				tmpStack.push(venstre);
				venstre = stack.pop();
			}
			if(!erPar(venstre, stack.peek())) {
				return false;
			}
			stack.pop();
			if(!tmpStack.erTom()) {
				stack.push(tmpStack.pop());
			}
		}
		return true;
	}
	

}
