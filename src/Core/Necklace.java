package Core;

public class Necklace extends EquipableItem{

    public Necklace(int[] bonusVal, int qual) {
        super(bonusVal, qual);
    }
    
   public void equip(Mage m){
      m.getStuff().setNecklace(this);
      m.getInventory().removeOneItem(this.getSlot(m,this));
   };

    
   
   


    

    
}
