import MeiDOTAnaka.GUI_Components.MainFrame.MeiDOTAnakaFrrame_m;
import MeiDOTAnaka.Services.GSS.GSS;

/**
 * Remember to enable -gamestateintegration as launch option for dota.
 */
public class MeiDOTAnakaApp {
    public static void main(String[] args) {
        System.out.println("Application started");

        MeiDOTAnakaFrrame_m meiDOTAnakaFrrame_m = new MeiDOTAnakaFrrame_m();
        meiDOTAnakaFrrame_m.setButtonsContext(meiDOTAnakaFrrame_m);

//        GSS gss = new GSS();
//        gss.setGSSContext(meiDOTAnakaFrrame_m);
//        gss.startGSS(44444);
    }
}
