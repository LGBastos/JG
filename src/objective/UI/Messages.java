package objective.UI;


import objective.Entidades.Caracteristicas;
import objective.Entidades.Entities;

import javax.swing.*;


public class Messages extends JOptionPane {
    public static int getConfirm(Entities check) {
        Object[] ob = {"Sim", "Nao"};
        return showOptionDialog(null, "O prato que voce pensou eh " + check + "?", "Confirm", DEFAULT_OPTION, QUESTION_MESSAGE, null, ob, ob[1]);
    }
    protected static void gotRight() {
        showMessageDialog(null, "Acertei de novo!", "Jogo Gourmet", INFORMATION_MESSAGE);
    }
    protected static String newPlate() {
        return showInputDialog(null, "Qual prato voce pensou?","Desisto", QUESTION_MESSAGE);
    }
    protected static String newCaracteristic(Caracteristicas current, String tempDish) {
        return showInputDialog(null, tempDish + " eh ________ mas " + current.getPlate() + " nao.", "Complete", QUESTION_MESSAGE);
    }
}
