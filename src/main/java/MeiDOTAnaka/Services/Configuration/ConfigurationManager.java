package MeiDOTAnaka.Services.Configuration;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class ConfigurationManager {
    private File configurationFile;

    public File getConfigurationFile() {
        JFileChooser fileChooser = new JFileChooser(".");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Cringe files only", "cringe");

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(filter);

        fileChooser.showSaveDialog(null);

        File selectedFile = fileChooser.getSelectedFile();
        System.out.println(selectedFile.getName());

        configurationFile = selectedFile;

        return selectedFile;
    }

    public void readConfigurationFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(configurationFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
