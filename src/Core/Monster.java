/*
 * The MIT License
 *
 * Copyright 2014 Alexis.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package Core;
import Monsters.Affixes.*;

/**
 *
 * @author Alexis
 */
public class Monster {
    protected String Name;
    protected int Level;
    protected long ExpToGive;
    protected int Health;
    protected Gold GoldToGive;
    public boolean IsAlive;
    protected Affixe availableAffixes[];
    
    public Monster() {}
    public Monster(int lvl) {
        this.Level = lvl;
        this.GoldToGive = new Gold();
        this.ComputeHealth();
        this.ComputeExpToGive();
        this.ComputeGoldToGive();
        this.setAffixe();
    }
    
    public void setAffixe() {};
    
    public void getHit(int dmg) {
        if(this.Health > dmg) {
            this.Health -= dmg;
        }
        else {
            this.die();
        }
    }
    
    public void die() {
        this.IsAlive = false;
    }
    
    public void ComputeExpToGive() {
        this.ExpToGive = this.Level * 2;
    }
    
    public void ComputeHealth() {
        this.Health = this.Level;
    }
    
    public long GetExpToGive() {
        return this.ExpToGive;
    }
    
    public void ComputeGoldToGive() {
        this.GoldToGive.setAmount(this.Level * 3);
    }
    
    public int GetGoldToGive() {
        return this.GoldToGive.getAmount();
    }
    
}
