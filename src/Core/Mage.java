package Core;

public class Mage extends Character {
    // Attributs
    // Caractéristiques:
        private int arcanepower;
        private int intel;
        private Stuff stuff;
        protected Inventory inventory;

    public Mage() {}
    public Mage(String n) {
        super(n);
        
        this.inventory = new Inventory();
        this.stuff = new Stuff();
        this.arcanepower = 50;
        this.intel = 10;
    }
    
    public int getArcanePower() {
        return this.arcanepower;
    }
    public void setArcanepower(int ap) {
        this.arcanepower = ap;
    }
    public int getIntel() {
        return this.intel;
    }
    public void setIntel(int i) {
        this.intel = i;
    }
    public Inventory getInventory(){
        return this.inventory;
    }
    public Stuff getStuff() {
        return this.stuff;
    }  
}
