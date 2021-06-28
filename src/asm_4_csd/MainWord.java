/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm_4_csd;

import java.util.Scanner;

/**
 *
 * @author Biv
 */
public class MainWord {
    public static void main(String[] args) {
        String filename = "Text.txt";
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.addMenu("Add the word");
        menu.addMenu("Load From File");
        menu.addMenu("Search word");
        menu.addMenu("Save to file");
        menu.addMenu("Quit");
        
        int userchoice;
        boolean changed = false;
        MapWord list = new MapWord();
        list.AddFromFile(filename);
        do {            
            System.out.println("\nMENU");
            userchoice = menu.getUserChoice();
            switch(userchoice){
                case 1: list.addWord();
                changed = true;
                break;
                case 2: list.showWord();
                break;
                case 3: list.seach();
                break;
                case 4: list.SaveToFile(filename);
                changed = false;
                break;
                default: if (userchoice == 5) {
                        System.out.println("BYE bye!");
                    }
                    if (userchoice > 5 || userchoice <1) {
                        System.out.println("Please input follow the format!");
                    }
                    
            }
        } while (userchoice != 5);
    }
}
