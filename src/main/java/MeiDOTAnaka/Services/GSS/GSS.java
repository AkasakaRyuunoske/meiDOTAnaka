package MeiDOTAnaka.Services.GSS;

import MeiDOTAnaka.GUI_Components.MainFrame.MeiDOTAnakaFrrame_m;
import com.github.mrbean355.dota2.gamestate.PlayingGameState;
import com.github.mrbean355.dota2.server.GameStateServer;
import net.dv8tion.jda.api.JDA;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class GSS {
    MeiDOTAnakaFrrame_m meiDOTAnakaFrrame_m;
    static JDA chloyena;

//        chloyena = JDABuilder.createDefault("MTE0NTc4MjQ0MjM0NzczMzAzMw.GWS3za.liacSnqHC6p-fZX9R6zjtFwWZjOK59AaFkoAAA")
//                .setActivity(Activity.competing("With life"))
//                .addEventListeners(new MeiDOTAnaka.Services.Discord.ChloyenaBOT())
//                .build();
        public void startGSS(int port){
        System.out.println("Me too");
        // Create a server and add various listeners for game state updates.
        // All listeners are optional; you only need to add the ones you want.
        // Remember to call start() or startAsync() so that the server actually runs!
        // Check the documentation of GameStateServer for more info.
        GameStateServer.create(port)
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

                if (newState.getPlayer().getGoldFromCreepKills() > previousState.getPlayer().getGoldFromCreepKills()) {
                    System.out.println("You got " + newState.getPlayer().getGoldFromCreepKills() + " from killing creeps");
                }

                if (newState.getHero() != null) {
                    if (newState.getHero().getLevel() > 1) {
                        if (newState.getHero().getLevel() > previousState.getHero().getLevel()) {
                            System.out.println("Yay you got new lvl");
                            meiDOTAnakaFrrame_m.getState_panel().currentGame_panel.getHeroInfo_panel().getHeroLvl_label().setText(String.valueOf(newState.getHero().getLevel()));
                            meiDOTAnakaFrrame_m.getState_panel().currentGame_panel.getHeroInfo_panel().getHeroName_label().setText(newState.getHero().getName());

                            meiDOTAnakaFrrame_m.getState_panel().currentGame_panel.getPlayers_panel().getGpm_label().setText(String.valueOf(newState.getPlayer().getGpm()));
                            meiDOTAnakaFrrame_m.getState_panel().currentGame_panel.getPlayers_panel().getXpm_label().setText(String.valueOf(newState.getPlayer().getXpm()));
//                            meiDOTAnakaFrame.updateHeroMaxHP(newState.getHero().getMaxHealth());
//                            meiDOTAnakaFrame.updateHeroMaxMP(newState.getHero().getMaxMana());
//                            meiDOTAnakaFrame.updateHeroLvl(newState.getHero().getLevel());
//
//                            MeiDOTAnaka.Services.Discord.ChloyenaBOT.sendMessage("Yay you got new lvl! Now you are " + newState.getHero().getLevel());
                        }
                    }

                    if (newState.getHero().isAlive()) {
//                        meiDOTAnakaFrame.updateHeroCurrentHP(newState.getHero().getHealth());
//                        meiDOTAnakaFrame.updateHeroCurrentMP(newState.getHero().getMana());
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
                System.out.println(newState.getPlayer());
                System.out.println(newState.getMap());
                System.out.println(newState.getPlayer().getGold());

            }
        }

        // Previous state becomes the current state, for the next time the game state updates:
        previousState = newState;
    }

    private void writeErrorLog(String json) {
        try {
            FileWriter writer = new FileWriter("error_" + LocalDate.now() + ".json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing data: " + e + ".");
        }
    }

    public void setGSSContext(MeiDOTAnakaFrrame_m context_frame){
        meiDOTAnakaFrrame_m = context_frame;
    }
}
