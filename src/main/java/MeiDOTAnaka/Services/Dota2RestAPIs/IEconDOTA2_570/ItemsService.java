package MeiDOTAnaka.Services.Dota2RestAPIs.IEconDOTA2_570;

import MeiDOTAnaka.GUI_Components.Indicators.DownloadProgressBar;
import MeiDOTAnaka.MeiDOTAnakaApp;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ResponseCache;
import java.net.URL;
import java.util.Iterator;
import java.util.Random;

public class ItemsService {
    public static String tooltipText;
    public JsonObject getAllItems(){
        try {
            System.out.println(ResponseCache.getDefault() + " get default response cache");

//            ResponseCache responseCache = new ResponseCache() {
//                @Override
//                public CacheResponse get(URI uri, String requestMethod, Map<String, List<String>> requestHeaders) throws IOException {
//                    System.out.println("CacheResponse get  was invoked on: " + uri);
//                    return null;
//                }
//
//                @Override
//                public CacheRequest put(URI uri, URLConnection conn) throws IOException {
//                    System.out.println("CacheResponse put  was invoked on: " + uri);
//                    return null;
//                }
//            };
//
//            ResponseCache.setDefault(responseCache);
//
//            System.out.println(ResponseCache.getDefault() + " get default response cache");

            URL url = new URL("https://api.opendota.com/api/constants/items");
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
                    "Something went wrong during the connection. No items were received. Sorry :(",
                    "Couldn't connect",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public JsonObject getAllItemIds(){
        try {
            URL url = new URL("https://api.opendota.com/api/constants/item_ids");
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
                    "Something went wrong during the connection. No item ids were received. Sorry :(",
                    "Couldn't connect",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void downloadAndDisplayItemImages() {
        Thread thread = new Thread(() -> {
            JsonObject allItemsJSON = getAllItems();

            Iterator<String> iterator = allItemsJSON.keySet().iterator();

            try {
                Random random = new Random();
                int i = 0;
                Image image;
                URL url;

                DownloadProgressBar downloadProgressBar = new DownloadProgressBar(0, allItemsJSON.keySet().size());

                JsonObject item;
                String itemJson;

                while (iterator.hasNext() && i < 20) { //todo replace hardcoded 20
                    System.out.println(downloadProgressBar.getValue() + " downloadProgressBar.getValue()");
                    itemJson = iterator.next();
                    item = allItemsJSON.getAsJsonObject(itemJson);

                    tooltipText = itemJson;
                    downloadProgressBar.setValue(i);
                    downloadProgressBar.setString("Download progress... %" + i);
                    downloadProgressBar.logLabel.setText("https://api.opendota.com" + item.get("img").toString().replaceAll("\"", ""));
                    downloadProgressBar.setBackground(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                    downloadProgressBar.setForeground(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));

                    System.out.println("Download of item images in progress... %" + i);

                    i++;
                    url = new URL("https://api.opendota.com" + item.get("img").toString().replaceAll("\"", ""));
                    image = ImageIO.read(url);

                    itemJson = itemJson.replaceFirst(String.valueOf(itemJson.charAt(0)), String.valueOf(itemJson.charAt(0)).toUpperCase());

                    int count = itemJson.length() - itemJson.replace("_", "").length();

                    // this monstrosity simple replaces _ with space and then turn to upper case every first letter of every word
                    // I am very sorry for writing it this way, no better solution at least for now :(
                    for (int j = 0; j < count; j++) {
                        itemJson = itemJson.replace(
                                String.valueOf(itemJson.charAt(itemJson.indexOf("_"))) + String.valueOf(itemJson.charAt(itemJson.indexOf("_") + 1)),
                                " " + String.valueOf(itemJson.charAt(itemJson.indexOf("_") + 1)).toUpperCase()
                        );
                    }

                    MeiDOTAnakaApp.meiDOTAnakaFrrame_m.getState_panel().items_panel.defaultTableModel.addRow(new Object[]{
                            itemJson,
                            item.get("cost").toString(),
                            new ImageIcon(image)
                    });
                }

                downloadProgressBar.frame.setVisible(false);

            } catch (IOException ioException) {
                System.out.println("shit happends: " + ioException.getMessage());
            }
        });

        thread.start();
    }

    public ImageIcon getItemImageByUrl(String imageUrl){
        try {

            if (imageUrl.contains("\"")){
                imageUrl = imageUrl.replaceAll("\"", "");
            }

            URL url = new URL("https://api.opendota.com" + imageUrl);

            Image image = ImageIO.read(url);

            return new ImageIcon(image);
        } catch (IOException ioException) {
            System.out.println("shit happends: " + ioException.getMessage());
            return null;
        }
    }
}
