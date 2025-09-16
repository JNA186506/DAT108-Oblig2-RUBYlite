package no.hvl.dat108.O3;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		HamburgerBrett brett = new HamburgerBrett(5);
		
		ArrayList<Kokk> kokkListe = new ArrayList<>();
		String[] kokker = {"Mitch", "Mitchy", "Mitchey"};
		for(String k : kokker) kokkListe.add(new Kokk(brett, k));
		
		ArrayList<Servitor> servitorListe = new ArrayList<>();
		String[] servitorer = {"Michelle", "Michette", "Michelline"};
		for(String s : servitorer) servitorListe.add(new Servitor(brett, s));
		
		for(Kokk k : kokkListe) k.start();
		for(Servitor s : servitorListe) s.start();
		
	}
	
}
