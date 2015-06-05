/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package warlordwizard;
import Core.Inventory;
import Core.Mage;
import Core.Stuff;
import Core.GameManager;
import GUI.ihm;


/**
 *
 * @author Alexis
 */
public class WarLordWizard {
    private Mage c;
    private Stuff s;
    private ihm ihm;
    public GameManager gameManager;
    
    public WarLordWizard() {
        this.c = new Mage("Zed");
        this.s = new Stuff();
        this.ihm = new ihm(c, s);
        this.c.setArcanepower(50);
        this.c.getGold().setAmount(0);
        this.gameManager = new GameManager(this);
    }
    
    public void print(String s) {
        this.ihm.history.print(s);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        WarLordWizard wlw = new WarLordWizard();
        wlw.gameManager.start();
    }
    
}
