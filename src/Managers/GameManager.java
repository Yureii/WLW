/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;
import warlordwizard.*;
import Core.GameStates;
import Core.Monster;
import Managers.BattleLogManager;

/**
 *
 * @author Alexis
 */
public class GameManager {
    public static WarLordWizard w;
    public GameStates GameState;
    public boolean IsFightingEnemy;
    public int MapLevel;
    public int SubLevel;
    public Monster CurrentMonster;
    
    public GameManager(WarLordWizard wlw) {
        this.w = wlw;
        this.IsFightingEnemy = false;
        this.MapLevel = 1;
        this.SubLevel = 1;
        this.GameState = GameStates.PlayerTurn;
    }
    
    public static GameManager Instance = new GameManager(w);
    
    public void Update() {
        // if an enemy is not being fought
        if(!IsFightingEnemy) {
            this.CurrentMonster = new Monster(this.MapLevel); // An enemy appears
            this.IsFightingEnemy = true; // FIGHT HIM § :<
            this.w.ihm.getBattleLog().BattleLogManager.EnemyAppears();
        }
        if(this.GameState == GameStates.PlayerTurn ) {
            // Do whatever the player want
            System.out.println(this.GameState);
            while(!this.w.ihm.getBattleLog().BattleLogManager.IsNewInput()) {
                System.out.flush();
            }
            if(IsFightingEnemy)
                this.CurrentMonster.getHit(10);
            this.w.ihm.getBattleLog().BattleLogManager.SetIsNewInput(false);
            this.GameState = GameState.EnemyTurn; // turn for the monster to play
            if(!this.CurrentMonster.IsAlive) { // if we killed the monster
                this.IsFightingEnemy = false;
                this.w.getMage().receiveExp(this.CurrentMonster.GetExpToGive()); // Get the exp
                this.w.getMage().setGold(this.CurrentMonster.GetGoldToGive()); // Get the gold
                this.w.ihm.getBattleLog().BattleLogManager.EnemyDies(this.CurrentMonster.GetExpToGive(), this.CurrentMonster.GetGoldToGive());
                // Increase the level we are in
                this.SubLevel++;
                if(this.SubLevel > 10) { // When we do 10 sublevels in a row
                    this.MapLevel++; // We go into a higher level
                    this.SubLevel = 1; // Starting from 0
                    this.w.ihm.getBattleLog().BattleLogManager.EnteringLevel(this.MapLevel);
                }
                this.GameState = GameStates.PlayerTurn; // No more monster so not enemy's turn anymore
            }
        }
        else if(this.GameState == GameStates.EnemyTurn) {
            // Let the enemy do what they want
            System.out.println(this.GameState);
            while(!this.w.ihm.getBattleLog().BattleLogManager.IsNewInput()) {
                System.out.flush();
            }
            this.w.ihm.getBattleLog().BattleLogManager.SetIsNewInput(false);
            this.GameState = GameState.PlayerTurn;
        }
    }
}
