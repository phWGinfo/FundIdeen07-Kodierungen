package phwginfo;

import javax.swing.*;
import java.io.*;

public class KonvertiereKodierung {


    public static void main(String[] args) throws Throwable {
        // wähle Datei zu öffnen
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Datei zu lesen?");
        chooser.showOpenDialog(null);
        File fileIn = chooser.getSelectedFile();
        // Frage Kodierung
        String charsetIn = JOptionPane.showInputDialog("Welche Kodierung zu lesen? (utf-8, iso-8859-1, macroman, ...)");

        // wähle Datei zu schreiben
        chooser.setDialogTitle("Datei zu schreiben?");
        chooser.showSaveDialog(null);
        File fileOut = chooser.getSelectedFile();
        // Frage Kodierung
        String charsetOut = JOptionPane.showInputDialog("Welche Kodierung zu schreiben? (utf-8, iso-8859-1, macroman, ...)");;

        // jetzt transportieren
        InputStream bytesIn = new FileInputStream(fileIn);
        Reader charactersIn = new InputStreamReader(bytesIn, charsetIn);

        OutputStream bytesOut = new FileOutputStream(fileOut);
        Writer charactersOut = new OutputStreamWriter(bytesOut, charsetOut);

        int characterRead;

        while((characterRead=charactersIn.read()) != -1) {
            char c = (char) characterRead;
            charactersOut.write(c);
        }
        charactersOut.flush(); charactersOut.close();

    }
}
