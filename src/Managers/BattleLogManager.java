/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static jdk.nashorn.internal.objects.NativeString.substring;
import java.util.List;
import java.util.ArrayList;
//import java.util.ListIterator;

import GUI.BattleLog;

/**
 *
 * @author Alexis
 */
public class BattleLogManager implements KeyListener {
    private boolean IsNewInput;
    public BattleLog BattleLog;
    private int count;
    private List history_list;
    
    public BattleLogManager(BattleLog battleLog) {
        this.IsNewInput = false;
        this.BattleLog = battleLog;
        this.history_list = new ArrayList();
        this.history_list.add("");
        this.count = 0;
    }
 
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            String s = this.BattleLog.GetFormulaText().trim(); // remove first and last whitespaces
            if(s.isEmpty());
            else {
                history_list.add(s);
                count = history_list.size();
                if(s.substring(0, 1).equals("!")) {
                    this.ResolveCommand(s);
                }
                else {
                    this.ResolveFormula(s);
                    this.IsNewInput = true;
                }
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP) {
            count--;
            if(count < 0) { count = 0; this.BattleLog.setFormula("", false); }
            else if(count >=this.history_list.size()) count = this.history_list.size() - 1;
            else {
                this.BattleLog.setFormula(this.history_list.get(count).toString(), false);
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            count++;
            if(count < 0) count = 0;
            else if(count >=this.history_list.size()) { count = this.history_list.size() - 1;  this.BattleLog.setFormula("", false);  }
            else {
                this.BattleLog.setFormula(this.history_list.get(count).toString(), false);
            }
        }
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
    
    public void print(String s) {
        this.BattleLog.print(s, true, true);
    }
    
    private void ResolveCommand(String s) {
        switch(s) {
            case "!help":
                this.print("« "+ this.BattleLog.GetFormulaText());
                this.print("» There is the list of all accepted commands and their effect:");
                this.print("    !help: What you are reading right now.");
                this.print("    !save: Save the game");
                this.print("    !load: Load at previous save state.");
                this.print("    !clear: Clears the battlelog.");
                this.print("    !offense: Displays unlocked offense tree spells.");
                this.print("    !defense: Displays unlocked defense tree spells.");
                this.print("    !buff: Displays unlocked buff tree spells.");
                this.print("    !binding: Displays unlocked binding words.");
                break;
            case "!clear":
                this.BattleLog.clear();
                this.print("» BattleLog Cleared");
                break;
            case "!save":
                this.print("« !save\n» Not supported yet.");
                break;
            case "!load":
                this.print("« !load\n» Not supported yet.");
                break;
            case "!offense":
                this.print("« !offense\n» Not supported yet.");
                break;
            case "!defense":
                this.print("« !defense\n» Not supported yet.");
                break;
            case "!buff":
                this.print("« !buff\n» Not supported yet.");
                break;
            case "!binding":
                this.print("« !binding\n» Not supported yet.");
                break;
            case "!c":
                this.count = 0;
                break;
            
            default:
                this.print("» Unknown command: " + s);
        }
        this.BattleLog.clearFormula();
    }
    
    private void ResolveFormula(String s) {
        // if it's a multiple words formula
        if(s.contains(" ")) {
            this.print("« Multiple Word Formula received: " + s);
            String[] parts = s.split(" ");
            // Because of the design of the multiple words formulas, every binding word
            // is going to be on an odd position 
            // ie: Offense(0) + BindingWord(1) + Offense(2) + BindingWord(3) + Buff(4)
            // So we check if the word is a binding word or not
            for(int i = 0; i < parts.length; i++) {
                if( (i & 1) == 0 ) {
                    // Even number; It's not a binding word
                    // Search for the words in the dictionnaries
                }
                else {
                    // Odd number; It's a binding word
                    
                }
            }
        }
        else {
            this.print("« Single Word Formula received: " + s);
        }
        this.BattleLog.clearFormula();
    }

    public boolean IsNewInput() { 
        return this.IsNewInput;
    }
    
    public void SetIsNewInput(boolean b) {
        this.IsNewInput = b;
    }
    
    public void EnemyAppears() {
        this.print("» A new monster appeared");
    }
    public void EnemyDies(long exp, long tolvlup, int gold) {
        this.print("» You have defeated the enemy. You gained " + exp + " exp ("+tolvlup+" to level up) and " + gold + " gold.");
    }
    public void EnteringLevel(int lvl) {
        this.print("» You are entering floor " + lvl);
    }
    
    public void EnemyHit(int dmg, int health) {
        this.print("» You hit the enemy for " + dmg + " damage. The enemy has " + health + " health remaining.");
    }
}