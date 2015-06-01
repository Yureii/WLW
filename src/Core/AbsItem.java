package Core;

import Interfaces.InterfaceItem;

public abstract class AbsItem implements InterfaceItem {
    protected int quantity;
    protected String description,name;
    protected int price;

    public void sell(Mage seller)
    {
        seller.gold.setAmount(seller.gold.getAmount()+this.price);
        
    };
    @Override
    public void buy(){};
    @Override
    public void loot(){};
    @Override
    public void destroy(){};
    
    public int getSlot(Mage m, InterfaceItem it){
        boolean find = false;
        int slotFind = -1 ;
        for(int i = 0; find || i < m.getInventory().getBag().length; i++ ){
            if (m.getInventory().bag[i].getName().equals(it.getName())){
                slotFind = i;
            }
        }return slotFind;
    }
   @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sell() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setQuantity(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getQuantity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
