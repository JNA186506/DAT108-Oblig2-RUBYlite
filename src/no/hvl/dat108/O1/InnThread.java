package no.hvl.dat108.oppg1;

import javax.swing.*;

public class InnThread extends Thread {

    private Melding melding;

       public InnThread(Melding melding) {
        this.melding = melding;
    }

    @Override
    public void run() {
        while (Main.fortsett) {
            String input = JOptionPane.showInputDialog(null, "Skriv inn ny melding",
                    JOptionPane.CANCEL_OPTION);
            melding.setTekst(input);


            if (input == null || input.equalsIgnoreCase("quit")) Main.fortsett = false;

        }
    }
}
