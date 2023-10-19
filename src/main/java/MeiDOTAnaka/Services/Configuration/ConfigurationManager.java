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

    private String PATH_TO_CONFIG = "D:\\meiDO_TAnaka\\meiDO_TAnaka\\test.cringe";

    public File getConfigurationFile() {
        JFileChooser fileChooser = new JFileChooser(".");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Cringe files only", "cringe");

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(filter);

        fileChooser.showSaveDialog(null);

        File selectedFile = fileChooser.getSelectedFile();
        System.out.println(selectedFile.getName());
        try {
            System.out.println(selectedFile.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        configurationFile = selectedFile;

        return selectedFile;
    }

    public void readConfigurationFile(){
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

    public void readConfigurationFile(boolean useDefaultPath){
        fileContents = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_CONFIG))) {
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

    public JsonObject parseConfigurationFile(){

        JsonObject jsonObject = JsonParser.parseString(fileContents).getAsJsonObject();
        jsonObject = jsonObject.getAsJsonObject("config");

        return jsonObject;
    }

    public String getValueFromConfigurationFile(String type, int index, String key){
        // if file wasn't read yet then we read it using default path
        if (configurationFile == null) {
            System.out.println("Configuration file is indeed null");
            readConfigurationFile(true);
        }

        return parseConfigurationFile().getAsJsonArray(type).get(index).getAsJsonObject().get(key).toString().replaceAll("\"", "");
    }

    public void applyConfiguration(JButton jButton){
        JsonObject configJson = parseConfigurationFile();

        JsonArray buttonsArray = configJson.getAsJsonArray("buttons");

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
