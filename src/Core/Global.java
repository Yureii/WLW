/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

/**
 *
 * @author Alexis
 */
public class Global {
    public enum GameStates {
        None,
        PlayerTurn,
        EnemyTurn;        
    }
    
    public static GameStates GameState;
}
