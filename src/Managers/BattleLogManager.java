/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static jdk.nashorn.internal.objects.NativeString.substring;

import GUI.BattleLog;

/**
 *
 * @author Alexis
 */
public class BattleLogManager implements KeyListener {
    private boolean IsNewInput;
    public BattleLog BattleLog;
    
    public BattleLogManager(BattleLog battleLog) {
        this.IsNewInput = false;
        this.BattleLog = battleLog;
    }
 
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            this.IsNewInput = true;
            String s = this.BattleLog.getFormula().trim(); // remove first and last whitespaces
            if(s.isEmpty());
            else if(s.substring(0, 1).equals("!")) {
                this.ResolveCommand(s);
            }
            else {
                this.ResolveFormula(s);
            }
        }
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
    
    public void print(String s) {
        this.BattleLog.print(this.BattleLog.getText() + s);
    }
    
    private void ResolveCommand(String s) {
        switch(s) {
            case "!help":
                this.print("« "+ this.BattleLog.getFormula());
                this.print("» There is the list of all accepted commands and their effect:");
                this.print("\t!help: What you are reading right now.");
                this.print("\t!save: Save the game");
                this.print("\t!load: Load at previous save state.");
                this.print("\t!clear: Clears the battlelog.");
                this.print("\t!offense: Displays unlocked offense tree spells.");
                this.print("\t!defense: Displays unlocked defense tree spells.");
                this.print("\t!buff: Displays unlocked buff tree spells.");
                this.print("\t!binding: Displays unlocked binding words.");
                break;
            case "!clear":
                this.BattleLog.clear();
                this.print("» BattleLog Cleared");
                break;
            case "!save":
                this.print("Not supported yet.");
                break;
            case "!load":
                this.print("Not supported yet.");
                break;
            case "!offense":
                this.print("Not supported yet.");
                break;
            case "!defense":
                this.print("Not supported yet.");
                break;
            case "!buff":
                this.print("Not supported yet.");
                break;
            case "!binding":
                this.print("Not supported yet.");
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
        this.print("» You are entering level " + lvl);
    }
    
    public void EnemyHit(int dmg, int health) {
        this.print("» You hit the enemy for " + dmg + " damage. The enemy has " + health + " health remaining.");
    }
}