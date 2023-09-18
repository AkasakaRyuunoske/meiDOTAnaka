package MeiDOTAnaka.GUI_Components.MainFrame.Buttons_Component;

import MeiDOTAnaka.GUI_Components.MainFrame.MainPanel.State_Panel;
import MeiDOTAnaka.GUI_Components.MainFrame.MeiDOTAnakaFrrame_m;
import MeiDOTAnaka.GUI_Components.MainFrame.Selected_Component.Selected_Panel;

public interface MeiDOTAnaka_Button {
    void setContext(MeiDOTAnakaFrrame_m context_frame, Selected_Panel context_panel, State_Panel state_panel);
    void switchPanel();
}
