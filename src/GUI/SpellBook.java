/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Alexis
 */
public class SpellBook extends JTabbedPane {
    private JTabbedPane book;
    private JPanel offense;
    private JPanel defense;
    private JPanel buffs;
    private JPanel binding;
    
    public SpellBook() {
        this.setBackground(Color.white);
        this.setForeground(Color.DARK_GRAY);
        this.setFocusable(false);
        // Onglets:
        offense = new JPanel();
            offense.setBackground(Color.WHITE);
            JPanel labelPaneOf = new JPanel();
            JLabel label_offense = new JLabel("Offense Tree", JLabel.CENTER);
            labelPaneOf.add(label_offense);
            offense.setLayout(new BorderLayout());
            offense.add(labelPaneOf, BorderLayout.NORTH);
        defense = new JPanel();
            defense.setBackground(Color.WHITE);
            JPanel labelPaneDe = new JPanel();
            JLabel label_defense = new JLabel("Defense Tree", JLabel.CENTER);
            labelPaneDe.add(label_defense);
            defense.setLayout(new BorderLayout());
            defense.add(labelPaneDe, BorderLayout.NORTH);
        buffs = new JPanel();
            buffs.setBackground(Color.WHITE);
            JPanel labelPaneBu = new JPanel();
            JLabel label_buffs = new JLabel("Buffs Tree", JLabel.CENTER);
            labelPaneBu.add(label_buffs);
            buffs.setLayout(new BorderLayout());
            buffs.add(labelPaneBu, BorderLayout.NORTH);
        binding = new JPanel();
            binding.setBackground(Color.WHITE);
            JPanel labelPaneBi = new JPanel();
            JLabel label_binding = new JLabel("Binding Words Tree", JLabel.CENTER);
            labelPaneBi.add(label_binding);
            binding.setLayout(new BorderLayout());
            binding.add(labelPaneBi, BorderLayout.NORTH);
        this.addTab("Offense", offense);
        this.addTab("Defense", defense);
        this.addTab("Buffs", buffs);
        this.addTab("Binding Words", binding);
    }
}
