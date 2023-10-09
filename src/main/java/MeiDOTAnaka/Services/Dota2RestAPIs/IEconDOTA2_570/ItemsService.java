package MeiDOTAnaka.Services.Dota2RestAPIs.IEconDOTA2_570;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class ItemsService {
    public JsonObject getAllItems(){
        try {
            System.out.println(ResponseCache.getDefault() + " get default response cache");

            ResponseCache responseCache = new ResponseCache() {
                @Override
                public CacheResponse get(URI uri, String requestMethod, Map<String, List<String>> requestHeaders) throws IOException {
                    return null;
                }

                @Override
                public CacheRequest put(URI uri, URLConnection conn) throws IOException {
                    return null;
                }
            };

            ResponseCache.setDefault(responseCache);

            System.out.println(ResponseCache.getDefault() + " get default response cache");

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

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
}
