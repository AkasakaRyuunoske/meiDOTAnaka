package MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component;

import MeiDOTAnaka.GUI_Components.MainFrame.MainPanel.State_Panel;
import MeiDOTAnaka.GUI_Components.MainFrame.MeiDOTAnakaFrrame_m;
import MeiDOTAnaka.GUI_Components.MainFrame.Selected_Component.Selected_Panel;
import org.jetbrains.annotations.NotNull;

public interface MeiDOTAnaka_Button {
    /**
     * Is used to set button's context, so switching panels or overriding label's content works fine.
     * It's kinda like android GUI works.
     * @param context_frame frame which contains panel to switch
     * @param context_panel the panel that tells what is currently selected
     * @param state_panel the actual panel to be switched
     * */
    void setContext(@NotNull MeiDOTAnakaFrrame_m context_frame, @NotNull Selected_Panel context_panel, @NotNull State_Panel state_panel);

    /**
     * Changes currently visible panel to a one selected by a button.
     * Works by looking current_panel, removing it, adding selected panel and then overriding current_panel with selected panel.
     * setContext() must be executed first to the context.
     * */
    void switchPanel();
}
