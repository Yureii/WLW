/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package warlordwizard;
import Core.Inventory;
import Core.Mage;
import Core.Stuff;
import Managers.GameManager;
import GUI.ihm;


/**
 *
 * @author Alexis
 */
public class WarLordWizard {
    private Mage Mage;
    public ihm ihm;
    public GameManager gameManager;
    
    public WarLordWizard() {
        this.Mage = new Mage("Zed");
        this.ihm = new ihm();
        this.gameManager = new GameManager(this);
    }
    
    public Mage getMage() {
        return this.Mage;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        WarLordWizard wlw = new WarLordWizard();
        while(true) {
            wlw.gameManager.Update();
        }
    }
    
}
