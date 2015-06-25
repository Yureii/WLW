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
import javax.swing.JEditorPane;

/**
 *
 * @author Alexis
 */
public class Inventory extends JPanel {
    private JPanel content;
    private JEditorPane textarea;
    private JLabel label;
    private JButton button;
    
    public Inventory() {
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
            this.textarea = new JEditorPane("text/html", "");
            this.textarea.setEditable(false);
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
    
    
    public void SetTextarea(String s) {
        this.textarea.setText(s);
    }
}