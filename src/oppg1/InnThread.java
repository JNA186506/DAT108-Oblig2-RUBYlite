package oppg1;

import javax.swing.*;

public class InnThread extends Thread {

    @Override
    public void run() {
        while (Main.fortsett) {
            String input = JOptionPane.showInputDialog(null, "Skriv inn din melding",
                    JOptionPane.CANCEL_OPTION);
            System.out.println(input);

            if (input == null || input.equalsIgnoreCase("quit")) Main.fortsett = false;
        }
    }
}
