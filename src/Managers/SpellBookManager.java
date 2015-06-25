/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import GUI.BattleLog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Alexis
 */
public class SpellBookManager implements ActionListener {
    private BattleLog BattleLog;
    public SpellBookManager(BattleLog battleLog) {
        this.BattleLog = battleLog;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.BattleLog.setFormula(((JButton)e.getSource()).getText() + " ", true);
    }
    
}
