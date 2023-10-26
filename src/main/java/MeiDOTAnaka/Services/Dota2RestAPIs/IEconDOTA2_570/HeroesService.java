package MeiDOTAnaka.Services.Dota2RestAPIs.IEconDOTA2_570;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HeroesService {
    public JsonObject getAllHeroes(){
        try {
            URL url = new URL("https://api.opendota.com/api/constants/heroes");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            String inputLine;
            StringBuffer content = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            httpURLConnection.disconnect();

            System.out.println(content.toString());

            JsonObject response_json = new JsonParser().parse(content.toString()).getAsJsonObject();

            System.out.println("response_json: " + response_json);

            return response_json;

        } catch (IOException ioException){
            JOptionPane.showConfirmDialog(
                    null,
                    "Something went wrong during the connection. No heroes contents were received. Sorry :(",
                    "Couldn't connect",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public ImageIcon getHeroIconByUrl(String iconUrl) {
        Image image = null;

        try {
            if (iconUrl.contains("\"")){
                iconUrl = iconUrl.replaceAll("\"", "");
            }

            URL url = new URL("https://api.opendota.com" + iconUrl);
            image = ImageIO.read(url);

        } catch (IOException ioException){
            System.out.println("shit happends: " + ioException.getMessage());
        }
        return new ImageIcon(image);
    }
}
