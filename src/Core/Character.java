package Core;

/**
 *
 * @author Alexis
 */
public class Character {
    // Lore:
        public String name;
    // Attributs:
        protected int level;
        protected long exp;
        protected long expToLvlUp;
        protected int life;
        protected Gold gold;
        protected boolean alive;
        
    public Character() {
        this.level = 1;
        this.exp = 0;
        this.expToLvlUp = computeExpToLvlUp();
        this.life = 100;
        this.gold = new Gold();
        this.gold.setAmount(0);
        this.alive = true;
    }
    public Character(String n) {
        this();
        this.name = n;
    }
    
    public int getLevel() {
        return this.level;
    }
    public long getExp() {
        return this.exp;
    }
    public void setExp(long e) {
        this.exp = e;
    }
    public int getLife() {
        return this.life;
    }
    public void setLife(int l) {
        this.life = l;
    }
    
    public void getHit(int dmg) {
        if(this.life > dmg) {
            this.life -= dmg;
        }
        else {
            this.die();
        }
    }
    
    public Gold getGold() {
        return this.gold;
    }
    public void die() {
        this.alive = false;
    }
    public void revive() {
        this.alive = true;
    }
 
    public boolean isAlive() {
        return this.alive;
    }
    public void receiveExp(int e) {
        if(this.getExp() + e < this.expToLvlUp) {
            this.setExp(this.getExp() + e);
        }
        else {
            // We get the overflow amount of exp after the level up
            long s = this.getExp() + e - computeExpToLvlUp();
            // We actually level up
            this.levelUp();
            // And get the overflow exp back
            this.setExp(s);
        }
    }
    public void levelUp() {
        this.level++;
    }
    public long computeExpToLvlUp() {
        long exp = 0;
        for(int lvl = 1; lvl <= this.getLevel(); lvl++) {
            exp += lvl + 300*Math.pow(2, lvl/6.0 );
            exp = exp/4;
        }
        return exp;
    }
    
    public long getExpToLvlUp() {
        return this.expToLvlUp;
    }
}