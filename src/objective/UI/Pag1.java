package objective.UI;

import objective.Logica.GameLogic;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
/*Inicializa a primeira janela e espera o Botão "ok" ser apertado para começarem as perguntas*/
public class Pag1 extends JFrame{
    private JPanel panel;
    private JTextPane tp;
    private JButton b;

    public Pag1(){
        super("Jogo Gourmet");


        setButton();
        setTextPane();
        setPanel();
        setContainer();


        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setVisible(false);
        setSize(287, 131);
        setLocationRelativeTo(null);

    }

    private void setTextPane() {
        tp = new JTextPane();
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        Document doc = tp.getStyledDocument();

        Font fonte = new Font("Tahoma", Font.BOLD, 12);
        StyleConstants.setBold(attributeSet, true);
        StyleConstants.setFontSize(attributeSet, fonte.getSize());
        StyleConstants.setForeground(attributeSet, Color.darkGray);


        try {
            doc.insertString(doc.getLength(),"\n       Pense em um prato que gosta      ", attributeSet);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }



        tp.setEditable(false);
        tp.setSize(287,10);
        tp.setVisible(true);
    }

    private void setContainer() {
        Container container = getContentPane();
        container.add( panel );
    }

    private void setPanel() {
        panel = new JPanel();
        panel.add( tp );
        tp.setBackground(panel.getBackground());
        panel.add(b);
    }

    private void setButton() {
        b = new JButton();
        b.setText("OK");
        b.setSize(20,15);
        b.setBounds(143, 35, 20, 15);

        b.addActionListener(e -> {if(e.getSource()==b) GameLogic.startGame(); });
    }

}
