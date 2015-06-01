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
        protected int exp;
        protected int expToLvlUp;
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
    public int getExp() {
        return this.exp;
    }
    public void setExp(int e) {
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
            this.levelUp();
        }
    }
    public void levelUp() {
        this.level++;
    }
    public int computeExpToLvlUp() {
        return 5*this.level;
    }
    
    public int getExpToLvlUp() {
        return this.expToLvlUp;
    }
}