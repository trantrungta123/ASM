/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm_4_csd;

import java.util.TreeSet;

/**
 *
 * @author BIV
 */
public class Word implements Comparable{
    public String word;
//default
    public Word() {
    }

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }
    
    public void print(){
        System.out.println(word);
    }

    @Override
    public int compareTo(Object t) {
        return this.getWord().compareTo(((Word)t).getWord());
    }
    
    
}
