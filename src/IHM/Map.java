/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IHM;

/**
 *
 * @author Alexis
 */
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Alexis
 */
public class Map extends JPanel {    
    private JPanel content;
    private JTextArea textarea;
    private JLabel label;
    private JButton button;
    
    
    public Map() {        // Customise le JPanel:
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        
        // On utilise un CardLayout pour switch entre Inventaire & Stats
        CardLayout card = new CardLayout();
        content = new JPanel();
        // On crée deux conteneurs:
        JPanel mappemonde = new JPanel();
            mappemonde.setBackground(Color.WHITE);
        JPanel levelmap = new JPanel();
            levelmap.setBackground(Color.WHITE);
        content.setLayout(card);
        content.add(levelmap);
        content.add(mappemonde);
            
        // Label et bouton pour switcher de conteneur:
        JPanel labelPane = new JPanel();
            label = new JLabel("Level Map", JLabel.CENTER);
            labelPane.add(label);
        JPanel buttonPane = new JPanel();
            button = new JButton("Switch to Mappemonde");
            button.setFocusPainted(false);
            button.setForeground(Color.DARK_GRAY);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    card.next(content);
                    if(button.getText().equals("Switch to Mappemonde")) {
                        button.setText("Switch to Level Map");
                        label.setText("Mappemonde");
                    }
                    else {
                        button.setText("Switch to Mappemonde");
                        label.setText("Level Map");
                    }
                }
            });
            buttonPane.add(button);
        
        this.add(labelPane, BorderLayout.NORTH);
        this.add(content, BorderLayout.CENTER);
        this.add(buttonPane, BorderLayout.SOUTH);
    }
}
