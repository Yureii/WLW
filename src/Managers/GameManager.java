/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;
import warlordwizard.*;
import Core.GameStates;
import Core.Monster;
import Managers.*;

/**
 *
 * @author Alexis
 */
public class GameManager {
    public static WarLordWizard w;
    public GameStates GameState;
    public boolean IsFightingEnemy;
    public int FloorLevel;
    public int SubLevel;
    public Monster CurrentMonster;
    public CharacterManager CharacterManager;
        
    public GameManager(WarLordWizard wlw) {
        this.w = wlw;
        this.IsFightingEnemy = false;
        this.FloorLevel = 1;
        this.SubLevel = 1;
        this.GameState = GameStates.PlayerTurn;
        this.CharacterManager = new CharacterManager(this.w.ihm.getInventory(), this.w.getMage());
    }
    
    
    public void Update() {
        this.CharacterManager.UpdateCharacter();
        // if an enemy is not being fought
        if(!IsFightingEnemy) {
            this.CurrentMonster = new Monster(this.FloorLevel); // An enemy appears
            this.IsFightingEnemy = true; // FIGHT HIM § :<
            this.w.ihm.getBattleLog().BattleLogManager.EnemyAppears();
        }
        if(this.GameState == GameStates.PlayerTurn ) {
            // Do whatever the player want
            System.out.println(this.GameState);
            while(!this.w.ihm.getBattleLog().BattleLogManager.IsNewInput()) {
                System.out.flush();
            }
            // We'll implement a bigger method here to hit the enemy via spells
            // but for now we make it as simple as possible
            if(IsFightingEnemy) {// We hit the enemy
                this.CurrentMonster.getHit(10);
                this.w.ihm.getBattleLog().BattleLogManager.EnemyHit(10, this.CurrentMonster.GetHealth());
            }
            this.w.ihm.getBattleLog().BattleLogManager.SetIsNewInput(false);
            this.GameState = GameState.EnemyTurn; // turn for the monster to play
            
            if(!this.CurrentMonster.IsAlive) { // if we killed the monster
                this.IsFightingEnemy = false;
                if(this.w.getMage().receiveExp(this.CurrentMonster.GetExpToGive())) {// Get the exp
                    this.w.ihm.getBattleLog().BattleLogManager.EnemyDies(this.CurrentMonster.GetExpToGive(), this.w.getMage().getExpToLvlUp(), this.CurrentMonster.GetGoldToGive());
                    this.print("» Level up ! You have reached the level " + this.w.getMage().getLevel());
                }
                else 
                    this.w.ihm.getBattleLog().BattleLogManager.EnemyDies(this.CurrentMonster.GetExpToGive(), this.w.getMage().getExpToLvlUp(), this.CurrentMonster.GetGoldToGive());
                this.w.getMage().setGold(this.CurrentMonster.GetGoldToGive()); // Get the gold
                // Increase the level we are in
                this.SubLevel++;
                if(this.SubLevel > 10) { // When we do 10 sublevels in a row
                    this.FloorLevel++; // We go into a higher level
                    this.SubLevel = 1; // And restart from 1
                    this.w.ihm.getBattleLog().BattleLogManager.EnteringLevel(this.FloorLevel);
                }
                this.GameState = GameStates.PlayerTurn; // No more monster so not enemy's turn anymore
            }
        }
        else if(this.GameState == GameStates.EnemyTurn) {
            // Let the enemy do what they want
            System.out.println(this.GameState);
            this.print("» EnemyTurn ..");
            while(!this.w.ihm.getBattleLog().BattleLogManager.IsNewInput()) {
                System.out.flush();
            }
            this.w.ihm.getBattleLog().BattleLogManager.SetIsNewInput(false);
            this.GameState = GameState.PlayerTurn;
        }
    }
    
    public void print(String s) {
        this.w.ihm.getBattleLog().BattleLogManager.print(s);
    }
}
