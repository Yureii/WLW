/*
 * The MIT License
 *
 * Copyright 2014 Alexis.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package Core;

/**
 *
 * @author Alexis
 */
public class Param {
    public enum itemBonuses {  
        LIFE,
        PERCENT_LIFE, 
        ARCANE_POWER, 
        INTEL, 
        PERCENT_INTEL, 
        EXP_BONUS, 
        REDUCE_DMG, 
        MAGIC_SHIELD, 
        ELEM_DMG_FIRE, 
        ELEM_DMG_WATER, 
        ELEM_DMG_THUNDER, 
        ACCURACY, 
        GOLD_PER_DROP
    };
    
    public enum quality {
        BROKEN,
        NORMAL,
        UNCOMMON,
        RARE,
        PRECIOUS,
        LEGENDARY
    };
    
    public enum affixes {
        RED,
        BLUE,
        GREY,
        LITTLE,
        BIG,
        MAD,
        SICK,
        ALPHA
    };
    public enum affixeEffect {
        RES_FIRE("RES_FIRE"),
        RES_WATER("RES_WATER"),
        RES_THUNDER("RES_THUNDER"),
        UNKNOWN_1(""),
        UNKNOWN_2(""),
        UNKNOWN_3(""),
        UNKNOWN_4(""),
        UNKNOWN_5("");
        
        private String name;

        private affixeEffect(String n) {
            this.name = n;
        }
        
    }
}
