package MeiDOTAnaka;

import MeiDOTAnaka.Services.Dota2RestAPIs.Dota2MatchAPI_570.GetMatchDetails;
import MeiDOTAnaka.Services.Dota2RestAPIs.Dota2MatchAPI_570.MatchDetailsParser;
import com.google.gson.JsonObject;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.io.InputStream;
import java.io.InputStreamReader;

//public class MeiDOTAnakaApp_v2 {
//    public static void main(String[] args) {
////        GetMatchDetails getMatchDetails = new GetMatchDetails();
////        try {
////            MatchDetailsParser matchDetailsParser = new MatchDetailsParser();
////            JsonObject match = getMatchDetails.getFullMatchDetailsById("7340504781");
////            matchDetailsParser.getPlayersFromJsonObject(match);
////            System.out.println("hero id: " + matchDetailsParser.getPlayersFromJsonObject(match).get(1).getAsJsonObject().get("hero_id"));
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        }
////        new MeiDOTAnakaFrrame_m();
//
//
//    }
//}

public class MeiDOTAnakaApp_v2 extends JFrame {
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new MeiDOTAnakaApp_v2();
            ex.setVisible(true);
        });
    }
}