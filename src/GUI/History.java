/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

/**
 *
 * @author Alexis
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.Format;
import java.text.MessageFormat;
import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class History extends JPanel {
    private JPanel content;
    private JFormattedTextField formula;
    private JLabel label;
    private JTextArea textarea;
    
    public History() {
        // On set un BorderLayout sur ce JPanel:
            this.setLayout(new BorderLayout());
        // On customize le Panel:
            this.setBackground(Color.WHITE);
            this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        // On ajoute le JTextField en bas:
        JPanel labelPane = new JPanel();
            label = new JLabel("Battle Logs", JLabel.CENTER);
            labelPane.add(label);
        JPanel formulaPane = new JPanel();
            this.formula = new JFormattedTextField();
            this.formula.setPreferredSize(new Dimension(350, 20));
            this.formula.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent ke) {}
                @Override
                public void keyPressed(KeyEvent ke) {
                    if(ke.getKeyCode() == KeyEvent.VK_ENTER) {
                        if(formula.getText().equals("") || formula.getText().equals(" ")) {
                            System.out.println("Pas de texte !");
                        }
                        else if(formula.getText().equals("!help")) {
                            textarea.setText(textarea.getText() + "« " + formula.getText()+"\n");
                            formula.setText("");
                            textarea.setText(textarea.getText() + "» There is the list of all accepted commands and their effect:\n");
                            textarea.setText(textarea.getText() + "\t!help: What you are reading right now.\n");
                            textarea.setText(textarea.getText() + "\t!clear: Clears all the battlelog.\n");
                            textarea.setText(textarea.getText() + "\t!offense: Displays unlocked offense tree spells.\n");
                            textarea.setText(textarea.getText() + "\t!defense: Displays unlocked defense tree spells.\n");
                            textarea.setText(textarea.getText() + "\t!buff: DIsplays unlocked buff tree spells\n");
                            textarea.setText(textarea.getText() + "\t!binding: Displays unlocked binding words.\n");
                        }
                        else if(formula.getText().equals("!clear")) {
                            textarea.setText("» Battle Log cleared\n");
                            formula.setText("");
                        }
                        else {
                            textarea.setText(textarea.getText() + "« " + formula.getText()+"\n");
                            formula.setText("");
                        }
                    }
                }
                @Override
                public void keyReleased(KeyEvent ke) {}
            });
            formulaPane.add(formula);
        this.content = new JPanel();
            this.textarea = new JTextArea();
            this.textarea.setLineWrap(true);
            this.textarea.setMargin(new Insets(5,5,5,5));
            this.textarea.setWrapStyleWord(true);
            this.textarea.setEditable(false);
            JScrollPane scrollTeaxtarea = new JScrollPane(this.textarea);
            scrollTeaxtarea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollTeaxtarea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollTeaxtarea.setPreferredSize(new Dimension(390, 180));
            this.content.add(scrollTeaxtarea);
        this.content.setBackground(Color.WHITE);
        
            
        this.add(labelPane, BorderLayout.NORTH);
        this.add(content, BorderLayout.CENTER);
        this.add(formulaPane, BorderLayout.SOUTH);
    }
    
    public void print(String s) {
        this.textarea.setText(this.textarea.getText() + "» " + s + "\n");
    }
}
