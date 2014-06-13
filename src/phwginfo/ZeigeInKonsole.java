package phwginfo;

import javax.swing.*;
import java.io.*;

public class ZeigeInKonsole {

    public static void main(String[] args) throws Exception {

        // wähle Datei zu öffnen
        JFileChooser chooser = new JFileChooser();
        File file = null;
        if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
            file = chooser.getSelectedFile();
        else
            return;

        // Frage Kodierung

        String charset = JOptionPane.showInputDialog("Welche Kodierung? (utf-8, iso-8859-1, macroman, ...)");

        // jetzt transportieren
        InputStream bytesIn = new FileInputStream(file);
        Reader charactersIn = new InputStreamReader(bytesIn, charset);

        int characterRead;

        while((characterRead=charactersIn.read()) != -1) {
            char c = (char) characterRead;
            System.out.println(c);
        }






    }
}
