package Core;

public abstract class EquipableItem extends AbsItem {
   private int levelmin;
   private int itemBonus[];
   private String quality; 
   
   
   public void equip(){};
   public void unequip(){};
   
   
   EquipableItem( int[] bonusVal, int qual )
    {
        itemBonus = bonusVal;
        switch (qual)
        {
            case 0 : quality = "normal";break;
            case 1 : quality = "uncommun";break;
            case 2 : quality = "rare";break;
            case 3 : quality = "precious";break;
            case 4 : quality = "legendary";break;
            default : quality = "broken";break;
        }
    }
}

