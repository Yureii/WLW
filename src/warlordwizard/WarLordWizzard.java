/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package warlordwizard;
import Core.Inventory;
import Core.Mage;
import Core.Stuff;
import IHM.ihm;


/**
 *
 * @author Alexis
 */
public class WarLordWizzard {
    private Mage c;
    private Stuff s;
    private ihm ihm;
    
    public WarLordWizzard() {
        this.c = new Mage("Zed");
        this.s = new Stuff();
        this.ihm = new ihm(c, s);
    }
    
    public void print(String s) {
        this.ihm.history.print(s);
    }
    public void update() {
        this.c.setArcanepower(50);
        this.c.getGold().setAmount(0);
        this.ihm.getInventory().updateCharInfo();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        WarLordWizzard wlw = new WarLordWizzard();
        wlw.print("Hello Fellow Mage !");
        wlw.print("Type !help to display the list of commands you can use in the battlelog window");
        wlw.update();
        
        System.out.println(wlw.c.getInventory());
        
    }
    
}
