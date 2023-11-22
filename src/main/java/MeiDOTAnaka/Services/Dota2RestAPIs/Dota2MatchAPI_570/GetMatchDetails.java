package MeiDOTAnaka.Services.Dota2RestAPIs.Dota2MatchAPI_570;

import MeiDOTAnaka.Services.Configuration.ConfigurationManager;
import com.google.gson.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class GetMatchDetails {
    private String DOTA_ACCOUNT_ID;

    public GetMatchDetails(){
        ConfigurationManager configurationManager = new ConfigurationManager();
        configurationManager.readConfigurationFile(true);

        DOTA_ACCOUNT_ID = configurationManager
                .getValueFromConfigurationFile("labels", 2,"text")
                .replaceAll("\"",""); //replace because toString on JsonObject returns string with "
        System.out.println("DOTA_ACCOUNT_ID: " + DOTA_ACCOUNT_ID);
    }

    /**
     *  Returns id of last played match by DOTA_ACCOUNT_ID calling at /api.opendota.com/.../recentMatches endpoint
     *
     * */
    public String getLastMatchId(){
        try {
            URL url = new URL("https://api.opendota.com/api/players/" + DOTA_ACCOUNT_ID + "/recentMatches");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            httpURLConnection.disconnect();

            JsonArray response_json = new JsonParser().parse(content.toString()).getAsJsonArray();
            String lastMatchId = response_json.get(0).getAsJsonObject().get("match_id").getAsString();
            System.out.println("lastMatchId: " + lastMatchId);
            return lastMatchId;

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JsonObject getFullMatchDetailsById() throws IOException {
        URL url = new URL("https://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/v1?key=1C18B8FF615D591B6BF312501188DD33&match_id=" + getLastMatchId());
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(httpURLConnection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        httpURLConnection.disconnect();

        System.out.println(content.toString());

        JsonObject response_json = new JsonParser().parse(content.toString()).getAsJsonObject();

        System.out.println("response_json: "         + response_json);

        return response_json;
    }
}
