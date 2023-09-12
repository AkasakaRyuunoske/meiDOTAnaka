import com.github.mrbean355.dota2.draft.Draft;
import com.github.mrbean355.dota2.draft.TeamDraft;
import com.github.mrbean355.dota2.hero.Hero;
import com.github.mrbean355.dota2.server.GameStateServer;
import com.github.mrbean355.dota2.gamestate.PlayingGameState;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

/**
 * Remember to enable -gamestateintegration as launch option for dota.
 * */
public class MeiDOTAnakaApp {
    static JDA chloyena;

    JFrame frame;
    JLabel GPM_label;
    JLabel XPM_label;
    JLabel hero_name_label;
    JLabel gold_from_creeps_label;
    JLabel gold_from_kills_label;
    JLabel actions_label;
    public static void main(String[] args) {
        System.out.println("Application started");
        new MeiDOTAnakaApp().run();
    }

    /**
     * Start up a server that listens on the given port for data from Dota 2.
     * When Dota sends us a new game state, we can check various properties.
     */
    private void run() {
        frame = new JFrame("Yay mokson is not that bad )0)");
        GPM_label = new JLabel();
        XPM_label = new JLabel();
        hero_name_label = new JLabel();
        gold_from_creeps_label = new JLabel();
        gold_from_kills_label = new JLabel();
        actions_label = new JLabel();

        GPM_label.setText("Not yet started");
        XPM_label.setText("Not yet started");
        hero_name_label.setText("Not yet started");
        gold_from_creeps_label.setText("Not yet started");
        gold_from_kills_label.setText("Not yet started");
        actions_label.setText("Not yet started");

        frame.setBounds(0,0,500,500);
        frame.setLayout(new GridLayout(3,3));

        frame.add(hero_name_label);

        frame.add(GPM_label);
        frame.add(gold_from_creeps_label);
        frame.add(gold_from_kills_label);

        frame.add(XPM_label);

        frame.add(actions_label);

        frame.setVisible(true);

        chloyena = JDABuilder.createDefault("")
                .setActivity(Activity.competing("With life"))
                .addEventListeners(new ChloyenaBOT())
                .build();

        System.out.println("Me too");
        // Create a server and add various listeners for game state updates.
        // All listeners are optional; you only need to add the ones you want.
        // Remember to call start() or startAsync() so that the server actually runs!
        // Check the documentation of GameStateServer for more info.
        GameStateServer.create(44444)
                .setPlayingListener((state) -> {
                    System.out.println("Playing match " + state.getMap().getMatchId() + ".");
                    onNewGameState(state);
                })
                .setSpectatingListener(state -> System.out.println("Spectating match " + state.getMap().getMatchId() + "."))
                .setIdleListener(state -> System.out.println("Not in a match."))
                .setGenericListener(state -> System.out.println("State update: " + state.getClass().getSimpleName() + "."))
                .setErrorHandler((t, json) -> {
                    System.out.println("Error processing data: " + t + ".");
                    // Store the problematic data in a file for a bug report:
                    writeErrorLog(json);
                })
                .startAsync();
    }

    // Store the previous game state, so we can compare values when a new state comes in:
    private PlayingGameState previousState = null;

    private void onNewGameState(PlayingGameState newState) {
        if (newState.getMap() != null) {
            // Current game time (number of seconds since first creeps spawned):
            int clockTime = newState.getMap().getClockTime();

            // If the current time is a multiple of 3 minutes, the bounty runes have just spawned:
            if (clockTime % 180 == 0) {
                System.out.println("Bounty runes just spawned!");
            }
        }

        // If we have stored the previous state, we can compare some values to see how they are
        // different in the new state:
        if (previousState != null) {
            if (newState.getPlayer() != null && previousState.getPlayer() != null) {

                // The player's current kills are higher than the previous kills:
                if (newState.getPlayer().getKills() > previousState.getPlayer().getKills()) {
                    System.out.println("You got a kill, congrats!");
                }

                // The player's current deaths are higher than the previous deaths:
                if (newState.getPlayer().getDeaths() > previousState.getPlayer().getDeaths()) {
                    System.out.println("You died, too bad :(");
                }

                if (newState.getPlayer().getGoldFromCreepKills() > previousState.getPlayer().getGoldFromCreepKills()){
                    System.out.println("You got " + newState.getPlayer().getGoldFromCreepKills() + " from killing creeps");
                }

                if (newState.getHero() != null) {
                    if (newState.getHero().getLevel() > previousState.getHero().getLevel()) {
                        System.out.println("Yay you got new lvl");
                        ChloyenaBOT.sendMessage("Yay you got new lvl! Now you are " + newState.getHero().getLevel());
                    }
                }
                System.out.println("Kill list: " + newState.getPlayer().getKillList());
                System.out.println("Kill list: " + newState.getPlayer().getKillList().get(1));
                System.out.println(newState.getPlayer().getName());
                System.out.println(newState.getPlayer().getAccountId());
                System.out.println(newState.getPlayer().getCommandsIssued());
                System.out.println(newState.getPlayer().getGpm());

                System.out.println(newState.getAbilities());
//                System.out.println("Events: " + newState.getEvents().get(0).getEventType());

                System.out.println(newState.getItems().getInventory());
                System.out.println(newState.getItems().getNeutral());
                System.out.println(newState.getItems().getTeleport());
                System.out.println(newState.getItems().getStash());

                System.out.println(newState.getMap().getGameTime());
                System.out.println(newState.getMap().getName());
                System.out.println(newState.getMap().getMatchState());
                System.out.println("getDireScore(): " + newState.getMap().getDireScore());
                System.out.println("getRadiantScore(): " + newState.getMap().getRadiantScore());

                System.out.println(newState.getHero().getAttributesLevel());
                System.out.println(newState.getHero());

                System.out.println(newState.getPlayer());
                System.out.println(newState.getMap());
//
//                System.out.println();
                hero_name_label.setText("Hero is: " + newState.getHero().getName());
                GPM_label.setText("Your GPM is: " + newState.getPlayer().getGpm());
                gold_from_creeps_label.setText("Gold from creeps is: " + newState.getPlayer().getGoldFromCreepKills());
                gold_from_kills_label.setText("Gold from kills is: " + newState.getPlayer().getGoldFromHeroKills());
                XPM_label.setText("Your GPM is: " + newState.getPlayer().getXpm());
                actions_label.setText("Your GPM is: " + newState.getPlayer().getCommandsIssued());

            }
        }

        // Previous state becomes the current state, for the next time the game state updates:
        previousState = newState;
    }

    private void writeErrorLog(String json) {
        try {
            FileWriter writer = new FileWriter("error.json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing data: " + e + ".");
        }
    }
}
