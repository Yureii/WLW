/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
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
    private JButton[] spellsOffense;
    private JButton[] spellsDefense;
    private JButton[] spellsBuff;
    private JButton[] spellsBinding;
    
    public SpellBook() {
        this.setBackground(Color.white);
        this.setForeground(Color.DARK_GRAY);
        this.setFocusable(false);
        this.spellsOffense = new JButton[20];
        this.spellsDefense = new JButton[20];
        this.spellsBuff = new JButton[20];
        this.spellsBinding = new JButton[20];
        // Onglets:
        offense = new JPanel();
            JPanel containerOffense = new JPanel();
            containerOffense.setLayout(new GridLayout(0, 5));
            for(int i = 0; i<spellsOffense.length; i++) {
                spellsOffense[i] = new JButton("Button "+i);
                spellsOffense[i].setSize(80, 80);
                spellsOffense[i].setFocusPainted(false);
                containerOffense.add(spellsOffense[i]);
            }
            offense.setBackground(Color.WHITE);
            JPanel labelPaneOf = new JPanel();
            JLabel label_offense = new JLabel("Offense Tree", JLabel.CENTER);
            labelPaneOf.add(label_offense);
            offense.setLayout(new BorderLayout());
            offense.add(labelPaneOf, BorderLayout.NORTH);
            offense.add(containerOffense, BorderLayout.CENTER);
        defense = new JPanel();
            JPanel containerDefense = new JPanel();
            containerDefense.setLayout(new GridLayout(0, 5));
            for(int i = 0; i<spellsDefense.length; i++) {
                spellsDefense[i] = new JButton("Button "+i);
                spellsDefense[i].setSize(80, 80);
                spellsDefense[i].setFocusPainted(false);
                containerDefense.add(spellsDefense[i]);
            }
            defense.setBackground(Color.WHITE);
            JPanel labelPaneDe = new JPanel();
            JLabel label_defense = new JLabel("Defense Tree", JLabel.CENTER);
            labelPaneDe.add(label_defense);
            defense.setLayout(new BorderLayout());
            defense.add(labelPaneDe, BorderLayout.NORTH);
            defense.add(containerDefense, BorderLayout.CENTER);
        buffs = new JPanel();
            JPanel containerBuff = new JPanel();
            containerBuff.setLayout(new GridLayout(0, 5));
            for(int i = 0; i<spellsBuff.length; i++) {
                spellsBuff[i] = new JButton("Button "+i);
                spellsBuff[i].setSize(80, 80);
                containerBuff.add(spellsBuff[i]);
            }
            buffs.setBackground(Color.WHITE);
            JPanel labelPaneBu = new JPanel();
            JLabel label_buffs = new JLabel("Buffs Tree", JLabel.CENTER);
            labelPaneBu.add(label_buffs);
            buffs.setLayout(new BorderLayout());
            buffs.add(containerBuff, BorderLayout.CENTER);
            buffs.add(labelPaneBu, BorderLayout.NORTH);
        binding = new JPanel();
            JPanel containerBinding = new JPanel();
            containerBinding.setLayout(new GridLayout(0, 5));
            for(int i = 0; i<spellsBinding.length; i++) {
                spellsBinding[i] = new JButton("Button "+i);
                spellsBinding[i].setSize(80, 80);
                containerBinding.add(spellsBinding[i]);
            }
            binding.setBackground(Color.WHITE);
            JPanel labelPaneBi = new JPanel();
            JLabel label_binding = new JLabel("Binding Words Tree", JLabel.CENTER);
            labelPaneBi.add(label_binding);
            binding.setLayout(new BorderLayout());
            binding.add(containerBinding, BorderLayout.CENTER);
            binding.add(labelPaneBi, BorderLayout.NORTH);
        this.addTab("Offense", offense);
        this.addTab("Defense", defense);
        this.addTab("Buffs", buffs);
        this.addTab("Binding Words", binding);
    }
}
