package MeiDOTAnaka;

import MeiDOTAnaka.Services.Dota2RestAPIs.Dota2MatchAPI_570.GetMatchDetails;
import MeiDOTAnaka.Services.Dota2RestAPIs.Dota2MatchAPI_570.MatchDetailsParser;
import com.google.gson.JsonObject;

import java.io.IOException;

public class MeiDOTAnakaApp_v2 {
    public static void main(String[] args) {
        GetMatchDetails getMatchDetails = new GetMatchDetails();
        try {
            MatchDetailsParser matchDetailsParser = new MatchDetailsParser();
            JsonObject match = getMatchDetails.getFullMatchDetailsById("7340504781");
            matchDetailsParser.getPlayersFromJsonObject(match);
            System.out.println("hero id: " + matchDetailsParser.getPlayersFromJsonObject(match).get(1).getAsJsonObject().get("hero_id"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        new MeiDOTAnakaFrrame_m();


    }
}
