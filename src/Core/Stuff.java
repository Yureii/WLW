package Core;

public class Stuff {
    private Rune equiped_Runes[];
    private Necklace equiped_Necklace[];
    
 
    public Stuff() {
        this.equiped_Runes = new Rune[6];
        this.equiped_Necklace = new Necklace [1] ;
    }
    
    public void setNecklace(Necklace n) {
       if (equiped_Necklace[0] == null) {
           equiped_Necklace[0] = n;
       }
       else { 
           equiped_Necklace[0].unequip();
           equiped_Necklace[0] = n;
       }
    }
    public void setRune(Rune r, int slot) {
       if (equiped_Runes[slot] == null) {
           equiped_Runes[slot] = r;
       }
       else { 
           equiped_Runes[slot].unequip();
           equiped_Runes[slot] = r;
       }
    }
    
}