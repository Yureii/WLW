/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;
import Core.*;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Alexis
 */
public class ihm extends JFrame {
    private Options opt;
    private Inventory inv;
    private Map map;
    private SpellBook book;
    public BattleLog battleLog;
    private Menu menu;
        
    public ihm() {
        super();
        // Setting up the system Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (UnsupportedLookAndFeelException e) {
           // handle exception
        }
        catch (ClassNotFoundException e) {
           // handle exception
        }
        catch (InstantiationException e) {
           // handle exception
        }
        catch (IllegalAccessException e) {
           // handle exception
        }
        
        // Instanciation et paramétrage de la fenêtre:
        this.setTitle("War Lord Wizard");
        this.setSize(1000, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.WHITE);

        // On choisi le Layout null pour placer les ContentPane:
        this.setLayout(null);
        // On instancie et positionne les JPanels nécessaires:
        this.inv = new Inventory();
        this.map = new Map();
        this.battleLog = new BattleLog();
        this.book = new SpellBook(this.battleLog);
        
        // On instancie le menu:
        this.menu = new Menu(this);
                
        // On set le JPanel et on ouvre la fenêtre:
        this.getContentPane().add(this.book);
        this.getContentPane().add(this.inv);
        this.getContentPane().add(this.map);
        this.getContentPane().add(this.battleLog);
        
        this.book.setBounds(0, 0, 600, 550);
        this.inv.setBounds(600, 0, 200, 300);
        this.map.setBounds(800, 0, 194, 300);
        this.battleLog.setBounds(600, 300, 394, 250);
        
        this.setJMenuBar(this.menu);
        this.setVisible(true);
        
    }
    
    public Inventory getInventory() {
        return this.inv;
    }
    
    public BattleLog getBattleLog() {
        return this.battleLog;
    }
    
}
