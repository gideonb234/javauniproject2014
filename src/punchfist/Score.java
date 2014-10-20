/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punchfist;

import city.cs.engine.*;

/**
 *
 * @author llama
 */
public class Score {
    // make a count var
    private static int count = 0;
    // constructor to set new score to 0 every time
    public Score() {
        count = 0;
    }
    
    // global increment count 
    public static void addCount(int c) {
        count = count + c;
    }
    
    // global get count (returns as int)
    public static int getCount() {
        return count;
    }
}
