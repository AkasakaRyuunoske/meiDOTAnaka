package MeiDOTAnaka.Services.Configuration;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;

public class ConfigurationManager {
    private File configurationFile;
    private String fileContents = "";

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
        fileContents = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(configurationFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                fileContents += line;
            }
            System.out.println("File contents: " + fileContents);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        parseConfigurationFile();
    }

    public void parseConfigurationFile(){

    }

    public void applyConfiguration(JButton jButton){
        JsonObject jsonObject = new JsonObject();
        jsonObject = JsonParser.parseString(fileContents).getAsJsonObject();
        jsonObject = jsonObject.getAsJsonObject("config");

        JsonArray buttonsArray = jsonObject.getAsJsonArray("buttons");

        System.out.println(buttonsArray.get(0));
        System.out.println(buttonsArray.get(1));

        for (JsonElement jsonElement: buttonsArray){

            System.out.println("jButton.getName(): " + jButton.getName());
            System.out.println("jsonElement.toString(): " + jsonElement.getAsJsonObject().get("name").toString());

            if (jsonElement.getAsJsonObject().get("name").toString().replace("\"", "").equals(jButton.getName())) {

                int background_color_R = Integer.parseInt(jsonElement.getAsJsonObject().get("background_color").getAsJsonArray().get(0).getAsJsonObject().get("r").toString());
                int background_color_G = Integer.parseInt(jsonElement.getAsJsonObject().get("background_color").getAsJsonArray().get(1).getAsJsonObject().get("g").toString());
                int background_color_B = Integer.parseInt(jsonElement.getAsJsonObject().get("background_color").getAsJsonArray().get(2).getAsJsonObject().get("b").toString());

                int foreground_color_R = Integer.parseInt(jsonElement.getAsJsonObject().get("foreground_color").getAsJsonArray().get(0).getAsJsonObject().get("r").toString());
                int foreground_color_G = Integer.parseInt(jsonElement.getAsJsonObject().get("foreground_color").getAsJsonArray().get(1).getAsJsonObject().get("g").toString());
                int foreground_color_B = Integer.parseInt(jsonElement.getAsJsonObject().get("foreground_color").getAsJsonArray().get(2).getAsJsonObject().get("b").toString());

                jButton.setBackground(new Color(background_color_R, background_color_G, background_color_B));
                jButton.setForeground(new Color(foreground_color_R, foreground_color_G, foreground_color_B));

                jButton.setText(jsonElement.getAsJsonObject().get("text").toString().replace("\"", ""));

                jButton.revalidate();
                jButton.repaint();
            }

        }
    }
}
