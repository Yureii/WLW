/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

/**
 *
 * @author Alexis
 */
public interface InterfaceItem {
    public String getName();
    public void sell();
    public void buy();
    public void loot();
    public void destroy();
    public void setQuantity(int i);
    public int getQuantity();
    
    
}
