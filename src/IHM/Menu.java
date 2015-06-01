/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IHM;
import IHM.ihm;
import IHM.Map;
import IHM.Options;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
/**
 *
 * @author Alexis
 */
public class Menu extends JMenuBar {
    // Attributs
    private ihm ihm;
    // Menu Fichier:
    private JMenu menu_File = new JMenu("File");
        private JMenuItem item_New_Game = new JMenuItem("New Game"),
                item_Load = new JMenuItem("Load"),
                item_Close = new JMenuItem("Close");
        
    // Menu Options:
    private JMenuItem item_Options = new JMenuItem("Options");
        
        
    // Menu Aide:
    private JMenu menu_Help = new JMenu("Help");
        private JMenuItem item_About = new JMenuItem("About"),
                item_Help = new JMenuItem("Help Content");
        
    public Menu(JFrame parent) {
        // On setup tous les boutons:
            // Bouton File > New Game:
            this.item_New_Game.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    JOptionPane jop = new JOptionPane();
                    String message = "Voulez-vous commencer une nouvelle partie ?";
                    jop.showMessageDialog(null, message, "?", JOptionPane.QUESTION_MESSAGE);
                }
            });        
            // Bouton File > Option:
            this.item_Options.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    Options opt = new Options(parent, "Options", false);
                }
            });
            // Bouton File > Close:
            this.item_Close.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    System.exit(0);
                }
            });
            // Bouton Help > Help Content:
            this.item_Help.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    JOptionPane jop = new JOptionPane();
                    String message = "Salut !\n Ceci est le menu d'Aide > Contenu !";
                    jop.showMessageDialog(null, message, "Help Content", JOptionPane.PLAIN_MESSAGE);
                }
            });
            // Bouton Help > About:
            this.item_About.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    JOptionPane jop = new JOptionPane();
                    String message = "Créé par Anthony Youssef & Alexis Despois";
                    jop.showMessageDialog(null, message, "About", JOptionPane.PLAIN_MESSAGE);
                }
            });
            
            
        // Menu Fichier:
            this.menu_File.add(item_New_Game);
            this.menu_File.add(item_Load);
            this.menu_File.addSeparator();
            this.menu_File.add(item_Options);
            this.menu_File.addSeparator();
            this.menu_File.add(item_Close);
        // Menu Options:
        // Menu Aide:
            this.menu_Help.add(item_Help);
            this.menu_Help.add(item_About);
        
            
        // On insère les JMenu dans le JMenuBar:
        this.add(menu_File);
        this.add(menu_Help);
    }
}