/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;
import GUI.Inventory;
import Core.Mage;
/**
 *
 * @author Alexis
 */

public class CharacterManager {
    private Inventory Inventory;
    private Mage Mage;
    
    public CharacterManager(Inventory i, Mage m) {
        this.Inventory = i;
        this.Mage = m;
    }
    
    public void UpdateCharacter() {
        String text = "<br>";
        text += "<b>" + this.Mage.getName() + "</b>";
        text += "<br>";
        text += this.Mage.getGold().getAmount() + " " + this.getPlural(this.Mage.getGold().getAmount(), "Gold");
        text += "<br>";
        text += "<br>";
        text += "<b>Level</b>: " + this.Mage.getLevel();
        text += "<br>";
        text += "<b>Experience</b>: " + this.Mage.getExp();
        text += "<br>";
        text += "<b>To level up</b>: " + this.Mage.getExpToLvlUp();
        text += "<br>";
        text += "<br>";
        text += "<b>Life</b>: " + this.Mage.getLife();
        text += "<br>";
        text += "<b>Arcane Power</b>: " + this.Mage.getArcanePower();
        text += "<br>";
        text += "<b>Intel</b>: " + this.Mage.getIntel();
        this.Inventory.SetTextarea(text);
    }
    
    public String getPlural(int i, String s) {
        if(i > 1)
            return s+"s";
        else
            return s;
    }
}
