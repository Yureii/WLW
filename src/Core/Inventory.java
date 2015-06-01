package Core;

import Interfaces.InterfaceItem;

public class Inventory {
    InterfaceItem bag[];

    public Inventory(){
        this.bag = new InterfaceItem[15];
    }
    
    public void removeItem(int slot){
        this.bag[slot].setQuantity(0);
        this.bag[slot] = null;
    }
    
    public void removeItem(int slot, int qty){
        this.bag[slot].setQuantity(this.bag[slot].getQuantity()-qty);
        if ( this.bag[slot].getQuantity() <= 0){
            removeItem(slot);
        }
        
    }
    public void removeOneItem(int slot){
        this.bag[slot].setQuantity(this.bag[slot].getQuantity()-1);
        if ( this.bag[slot].getQuantity() <= 0){
            removeItem(slot);
        }
        
    }
    
    public InterfaceItem[] getBag(){
        return bag;
    }

    public void updateCharInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
