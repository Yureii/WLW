/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;
import warlordwizard.*;
import Core.Global;

/**
 *
 * @author Alexis
 */
public class GameManager {
    public static WarLordWizard w;
    public static Global g;
    
    public GameManager(WarLordWizard wlw) {
        this.w = wlw;
        this.g.GameState = Global.GameStates.PlayerTurn;
    }
    
    
    public static GameManager Instance = new GameManager(w);
    
    public void start() {
        if(this.g.GameState == Global.GameStates.PlayerTurn ) {
            // Do whatever the player want
            System.out.println("Player turn.");
        }
        else if(this.g.GameState == Global.GameStates.EnemyTurn) {
            // Let the enemy do what they want
        }
    }
}
