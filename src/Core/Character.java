package Core;

/**
 *
 * @author Alexis
 */
public class Character {
    // Lore:
        public String Name;
    // Attributs:
        protected int Level;
        protected long Exp;
        protected long ExpToLvlUp;
        protected int Health;
        protected Gold Gold;
        protected boolean IsAlive;
        
    public Character() {
        this.Level = 1;
        this.Exp = 0;
        this.ExpToLvlUp = ComputeExpToLvlUp();
        this.Health = 100;
        this.Gold = new Gold();
        this.Gold.setAmount(0);
        this.IsAlive = true;
    }
    public Character(String n) {
        this();
        this.Name = n;
    }
    
    public int getLevel() {
        return this.Level;
    }
    public long getExp() {
        return this.Exp;
    }
    public void setExp(long e) {
        this.Exp = e;
    }
    public int getLife() {
        return this.Health;
    }
    public void setLife(int l) {
        this.Health = l;
    }
    
    public void getHit(int dmg) {
        if(this.Health > dmg) {
            this.Health -= dmg;
        }
        else {
            this.die();
        }
    }
    
    public Gold getGold() {
        return this.Gold;
    }
    public void setGold(int value) {
        this.Gold.setAmount(value);
    }
    public void die() {
        this.IsAlive = false;
    }
    public void revive() {
        this.IsAlive = true;
    }
 
    public boolean isAlive() {
        return this.IsAlive;
    }
    /**
     * Will return true if the character leveled up
     * false if he does not.
     * @param e
     * @return 
     */
    public boolean receiveExp(long e) {
        if(this.getExp() + e < this.ExpToLvlUp) {
            this.setExp(this.getExp() + e);
            return false;
        }
        else {
            // We get the overflow amount of Exp after the Level up
            long s = this.getExp() + e - ComputeExpToLvlUp();
            // We actually Level up
            this.levelUp();
            // And get the overflow Exp back
            this.setExp(s);
            // Recompute the exp to level up
            this.ComputeExpToLvlUp();
            return true;
        }
    }
    public void levelUp() {
        this.Level++;
    }
    public long ComputeExpToLvlUp() {
        long exp = 0;
        for(int lvl = 1; lvl <= this.getLevel(); lvl++) {
            exp += lvl + 300*Math.pow(2, lvl/6.0 );
            exp = exp/4;
        }
        return exp;
    }
    
    public long getExpToLvlUp() {
        return this.ExpToLvlUp - this.Exp;
    }
}