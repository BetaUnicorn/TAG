/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag.items;

import tag.Human;

/**
 *
 * @author Martin
 */
public class Gold implements Item{
    private String name = "Gold";
    private int value;
    
    public Gold(int value){
        this.value = value;
    }

    @Override
    public void effect(Human p) {
        p.addCoins(this.value);
    }

    @Override
    public String getName() {
        return this.name + "(" + this.value + ")";
    }
    
}
