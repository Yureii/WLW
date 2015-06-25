/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Managers.SpellBookManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Alexis
 */
public class Spell extends JButton implements ActionListener {
    private String Name;
    private SpellType Type;
    private int LevelReq;
    private int Damage;
    private boolean Unlocked;
    private boolean Active;
    private SpellBookManager sbm;
    
    public Spell() {
        super();
        this.addActionListener(this);
        this.Unlocked = false;
        this.Active = false;
    }
    
    public Spell(String n, SpellType st, int lr, int d) {
        super("<html><center>"+n+"</center><center>"+d+" Damage</center><br></html>");
        this.Name = n;
        this.Type = st;
        this.LevelReq = lr;
        this.Damage = d;
        this.Unlocked = false;
        this.Active = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("SALUT");
    }
}
