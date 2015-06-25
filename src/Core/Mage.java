package Core;

public class Mage extends Character {
    // Attributs
    // Caractéristiques:
        private String name;
        private int arcanepower;
        private int intel;
        private Stuff stuff;
        protected Inventory inventory;

    public Mage() {
        this.inventory = new Inventory();
        this.stuff = new Stuff();
    }
    public Mage(String n) {
        super(n);
        this.name = "Zed";
        this.arcanepower = 50;
        this.intel = 10;
    }
    
    public String getName() {
        return this.name;
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
