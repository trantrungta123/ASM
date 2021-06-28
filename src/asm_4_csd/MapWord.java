/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm_4_csd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BIV
 * 
 * 
 * 
 * System
 * 11
 * 
 * 
 * 
 * 32
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class MapWord extends LinkedList<Word> {

    public static final char SPACE = ' ';
    public static final char TAB = '\t';
    public static final char BREAK_LINE = '\n';

    public static Scanner sc = new Scanner(System.in);
    public static boolean checkValid;
    public static int pos;
    public static String question;

    public MapWord() {
        super();
    }

    public void AddFromFile(String fname) {
        try {
            File f = new File(fname);
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, "");
                String word = stk.nextToken();
                Word w = new Word(word);
                this.add(w);
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void SaveToFile(String fname) {
        try {
            File f = new File(fname);
            FileWriter fw = new FileWriter(f);// ghi vao file
            PrintWriter pw = new PrintWriter(fw);// ghi tung dong
            for (Word w : this) {
                String a = null;
                a = w.getWord();
                pw.println(a);
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public int find(String aWord) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getWord().equals(aWord)) {
                return i;
            }
        }
        return -1;
    }

    public void addWord() {
        if (this.size() == 0) {
            System.out.println("Empty List!");
        }
        
        String word;
        do {
            do {
                System.out.print("Add Word:");
                word = sc.nextLine();
                checkValid = word.matches("^[a-zA-Z\\s_-]{1,}$");
            } while (!checkValid);
            this.add(new Word(word));
            System.out.println("Do you want to countinue add?");
            question = sc.nextLine();
            checkValid = question.matches("^[YNyn01]{1}$");
            if (question.equalsIgnoreCase("n") || question.equals(0)) {
                break;
            }
        } while (question.equalsIgnoreCase("y") || question.equalsIgnoreCase("1"));
    }

    public void showWord() {
        if (this.size() == 0) {
            System.out.println("Empty List!");
            return;
        }
        int line = 1;
        String s = "do";
        System.out.println("Word List");
        System.out.println("--------------------");
        for (Word w : this) {
            Map<String, Integer> wordMap = countWords(w.toString());
          
            for (String key : wordMap.keySet()) {
                int count = 1;
                
                System.out.print(key + " " );

                count += count;

            }System.out.println("");
            line++;

        }

    }

    public void seach() {
        if (this.size() < 0) {
            System.out.println("File is Empty!");
        }
        int line=1;
        String word;
        do {
            System.out.print("Input the word search: ");
            word = sc.nextLine().trim();
            checkValid = word.matches("^[a-zA-Z\\s_-]{1,}$");
        } while (!checkValid);
        for (Word w : this) {
            Map<String, Integer> wordMap = countWords(w.toString());
            for (String key : wordMap.keySet()) {

                //System.out.print(key + " " + wordMap.get(key) + "\n");
                if (key.equals(word)) {
                    System.out.println("Line: "+line+" Total: "+ wordMap.get(key));
                }
            }line++;
        }
    }

    public void searchWord() {
        if (this.size() < 0) {
            System.out.println("File is Empty!");
        }
        String word;
        do {
            System.out.print("Input the word search: ");
            word = sc.nextLine().trim();
            checkValid = word.matches("^[a-zA-Z\\s_-]{1,}$");
        } while (!checkValid);
        pos = find(word);
        if (pos < 0) {
            System.out.println("The word didn't exsited!");
        } else {
            System.out.println("The word " + word + " was found!");
            String FindWord = this.get(pos).getWord();
            System.out.println(FindWord);
            while (true) {
                System.out.println("Do you want to count the word?");
                question = sc.nextLine();
                checkValid = question.matches("^[YNyn01]{1}$");
                if (question.equalsIgnoreCase("y") || question.equalsIgnoreCase("1")) {
                    StringTokenizer stk1 = new StringTokenizer(word);
                    System.out.print("Total of the word String: " + stk1.countTokens());
                    System.out.println();
                    int count = 1;
                    while (stk1.hasMoreTokens()) {
                        System.out.println(stk1.nextToken());
                        System.out.println(" " + count);
                        if (stk1.nextToken().equalsIgnoreCase(word)) {
                            count++;
                            System.out.println(count);
                        }
                    }

                }
                if (question.equalsIgnoreCase("n") || question.equalsIgnoreCase("0")) {
                    break;
                }
            }
        }
    }

    public static Map<String, Integer> countWords(String input) {
        // khởi tạo wordMap
        Map<String, Integer> wordMap = new TreeMap<String, Integer>();
        if (input == null) {
            return wordMap;
        }
        int size = input.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (input.charAt(i) != SPACE && input.charAt(i) != TAB
                    && input.charAt(i) != BREAK_LINE) {
                // build một từ
                sb.append(input.charAt(i));
            } else {
                // thêm từ vào wordMap
                addWord(wordMap, sb);
                sb = new StringBuilder();
            }
        }
        // thêm từ cuối cùng tìm được vào wordMap
        addWord(wordMap, sb);
        return wordMap;
    }

    public static void addWord(Map<String, Integer> wordMap, StringBuilder sb) {
        String word = sb.toString();
        if (word.length() == 0) {
            return;
        }
        if (wordMap.containsKey(word)) {
            int count = wordMap.get(word) + 1;
            wordMap.put(word, count);
        } else {
            wordMap.put(word, 1);
        }
    }
}


