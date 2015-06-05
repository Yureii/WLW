/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;
import Core.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Alexis
 */
public class Inventory extends JPanel {
    private Stuff stuff;
    private Mage chara;
    
    private JPanel content;
    private JTextArea textarea;
    private JLabel label;
    private JButton button;
    
    public Inventory() {
        super();
    }
    public Inventory(Mage c, Stuff s) {
        this();
        this.chara = c;
        this.stuff = s;
        // Customise le JPanel:
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        
        // On utilise un CardLayout pour switch entre Inventaire & Stats
        CardLayout card = new CardLayout();
        content = new JPanel();
        // On crée deux conteneurs:
        JPanel stats = new JPanel();
            stats.setBackground(Color.WHITE);
            this.textarea = new JTextArea();
            this.textarea.setEditable(false);
            this.updateCharInfo();
            stats.add(textarea);
        JPanel inv = new JPanel();
            inv.setBackground(Color.WHITE);
        content.setLayout(card);
        content.add(stats);
        content.add(inv);
            
        // Label et bouton pour switcher de conteneur:
        JPanel labelPane = new JPanel();
            label = new JLabel("Character", JLabel.CENTER);
            labelPane.add(label);
        JPanel buttonPane = new JPanel();
            button = new JButton("Switch to Inventory");
            button.setFocusPainted(false);
            button.setForeground(Color.DARK_GRAY);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    card.next(content);
                    if(button.getText().equals("Switch to Character")) {
                        updateCharInfo();
                        button.setText("Switch to Inventory");
                        label.setText("Character");
                    }
                    else {
                        button.setText("Switch to Character");
                        label.setText("Inventory");
                    }
                }
            });
            buttonPane.add(button);
        
        this.add(labelPane, BorderLayout.NORTH);
        this.add(content, BorderLayout.CENTER);
        this.add(buttonPane, BorderLayout.SOUTH);
    }
    
    public void updateCharInfo() {
        String text = "\n";
        text += this.chara.name;
        text += "\n";
        text += this.chara.getGold().getAmount() + " Golds";
        text += "\n";
        text += "\n";
        text += "Level: " + this.chara.getLevel();
        text += "\n";
        text += "Experience: " + this.chara.getExp();
        text += "\n";
        text += "To level up: " + this.chara.getExpToLvlUp();
        text += "\n";
        text += "\n";
        text += "Life: " + this.chara.getLife();
        text += "\n";
        text += "Arcane Power: " + this.chara.getArcanePower();
        text += "\n";
        text += "Intel: " + this.chara.getIntel();
        this.textarea.setText(text);
    }
}