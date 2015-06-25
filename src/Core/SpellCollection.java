/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class SpellCollection {
    private ArrayList<Spell> Offense;
    private ArrayList<Spell> Defense;
    private ArrayList<Spell> Buff;
    private ArrayList<Spell> Binding;
    
    private SpellCollection() {
        // Lets start with the Offense tree
        // We want 20 spells ranging from level 1 to lvl 100
        this.Offense = new ArrayList<Spell>();
            this.Offense.add(new Spell("Hwajae", SpellType.Offense, 1, 5)); // Fire
            this.Offense.add(new Spell("Mul", SpellType.Offense, 1, 5)); // Water
            this.Offense.add(new Spell("Beongae", SpellType.Offense, 1, 5)); // Lightning
            this.Offense.add(new Spell("Yongam", SpellType.Offense, 5, 15)); // Lava
            this.Offense.add(new Spell("Hongsu", SpellType.Offense, 5, 15)); // Flood
            this.Offense.add(new Spell("Pogpung", SpellType.Offense, 5, 15)); // Storm
            this.Offense.add(new Spell("Empty", SpellType.Offense, 100, 0));
            this.Offense.add(new Spell("Empty", SpellType.Offense, 100, 0));
            this.Offense.add(new Spell("Empty", SpellType.Offense, 100, 0));
            this.Offense.add(new Spell("Empty", SpellType.Offense, 100, 0));
            this.Offense.add(new Spell("Empty", SpellType.Offense, 100, 0));
            this.Offense.add(new Spell("Empty", SpellType.Offense, 100, 0));
            this.Offense.add(new Spell("Empty", SpellType.Offense, 100, 0));
            this.Offense.add(new Spell("Empty", SpellType.Offense, 100, 0));
            this.Offense.add(new Spell("Empty", SpellType.Offense, 100, 0));
            this.Offense.add(new Spell("Empty", SpellType.Offense, 100, 0));
            this.Offense.add(new Spell("Empty", SpellType.Offense, 100, 0));
            this.Offense.add(new Spell("Empty", SpellType.Offense, 100, 0));
            this.Offense.add(new Spell("Empty", SpellType.Offense, 100, 0));
            this.Offense.add(new Spell("Empty", SpellType.Offense, 100, 0));
            
        // Setting the Defense tree now
        this.Defense = new ArrayList<Spell>();
            this.Defense.add(new Spell("Bangpae", SpellType.Defense, 1, 0)); // Shield
            this.Defense.add(new Spell("Cheugpan", SpellType.Defense, 1, 0)); // Shroud
            this.Defense.add(new Spell("Bohoja", SpellType.Defense, 1, 0)); // Guardian
            
        // Buffs
        this.Buff = new ArrayList<Spell>();
            this.Buff.add(new Spell("Him", SpellType.Buff, 1, 0)); // Strength
            this.Buff.add(new Spell("Jihye", SpellType.Buff, 1, 0)); // Wisdom
            this.Buff.add(new Spell("Sigan", SpellType.Buff, 1, 0)); // Time
            
        // Bindings
        this.Binding = new ArrayList<Spell>();
            this.Binding.add(new Spell("Gaib", SpellType.Binding, 1, 0)); // Become
            this.Binding.add(new Spell("Ida", SpellType.Binding, 1, 0)); // Be
    }

    public static SpellCollection INSTANCE = new SpellCollection();
    
    public ArrayList<Spell> GetOffenseTree() {
        return this.Offense;
    }
    
    public ArrayList<Spell> GetDefenseTree() {
        return this.Defense;
    }
    
    public ArrayList<Spell> GetBuffTree() {
        return this.Buff;
    }
    
    public ArrayList<Spell> GetBindingTree() {
        return this.Binding;
    }
}
