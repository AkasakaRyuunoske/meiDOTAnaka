package MeiDOTAnaka.Services.Dota2RestAPIs.Dota2MatchAPI_570;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class MatchDetailsParser {
    public Map<Integer, JsonElement> getPlayersFromJsonObject(JsonObject jsonObject){
        JsonObject response_json_result = jsonObject.getAsJsonObject("result");
        JsonArray response_json_players = response_json_result.getAsJsonArray("players");

        Map<Integer, JsonElement> players = new HashMap<>(10);

        for (int i = 0; i < response_json_players.size(); i++){
            players.put(i, response_json_players.get(i));
        }

        System.out.println(players);
        return players;
    }
}
