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

import Managers.BattleLogManager;
import java.awt.Font;
import javax.swing.text.DefaultCaret;

public class BattleLog extends JPanel {
    private JPanel content;
    private JFormattedTextField formula;
    private JLabel label;
    private JTextArea textarea;
    public BattleLogManager BattleLogManager;
        
    public BattleLog() {
        // Set a BattleLogManager
            this.BattleLogManager = new BattleLogManager(this);
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
            this.formula.addKeyListener(this.BattleLogManager);
            formulaPane.add(formula);
        this.content = new JPanel();
            this.textarea = new JTextArea();
            this.textarea.setLineWrap(true);
            this.textarea.setMargin(new Insets(5,5,5,5));
            this.textarea.setWrapStyleWord(true);
            this.textarea.setEditable(false);
            this.textarea.setFont(new Font("Arial", Font.PLAIN, 12));
            
            DefaultCaret caret = (DefaultCaret)textarea.getCaret();
            caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
            
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
        this.textarea.setText(s + "\n");
    }
    
    public void clear() {
        this.textarea.setText("");
    }
    
    public String getText() {
        return this.textarea.getText();
    }
    public String getFormula() {
        return this.formula.getText();
    }
    
    public void clearFormula() {
        this.formula.setText("");
    }
    
}
