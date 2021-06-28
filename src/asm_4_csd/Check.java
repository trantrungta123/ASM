/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm_4_csd;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author BIV
 */
public class Check {//ham check dung chung for all
    private static boolean checkValid;
    private static Scanner sc = new Scanner(System.in);

    

    public static String getString(String msg, String format, String warning, String errorMsg) {
        String result;
        while (true) {
            System.out.print(msg);
            result = sc.nextLine();
            if (result.trim().isEmpty()) {
                System.out.println(warning);
            } else if (result.matches(format) &&  result.length() < 60) {
                return result;
            } else {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static String getStringUpdate(String msg, String format, String errorMsg){
        String result;
        while (true) {            
            System.out.println(msg);
            result = sc.nextLine().trim();
            if (result.matches(format)&&result.length() < 60 || result.isEmpty()) {
                return result;
            }else{
                System.out.println(errorMsg);
            }
        }
    }

    public static String getCode(String msg, String format, String warning, String errorMsg) {
        String result;
        while (true) {
            System.out.print(msg);
            result = sc.nextLine();
            if (result.trim().isEmpty()) {
                System.out.println(warning);
            } else if (result.matches(format) && result.length() < 9) {
                return result;
            } else {
                System.out.println(errorMsg);
            }
        }
    }
public static int checkNumber(String msg, int min, int max, String warning, String error) {
        int n;

        while (true) {
            try {
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine());
                if (n <= min || n > max) {
                    System.out.println(warning);//
                } else {
                    return n;
                }
            } catch (Exception e) {
                System.out.println(error);//
            }
        }

    }
    public static double checkPrice(String msg, double min, double max, String warning, String error) {
        double n;

        while (true) {
            try {//
                System.out.print(msg);
                n = Double.parseDouble(sc.nextLine());
                if (n <= min || n > max) {
                    System.out.println(warning);
                } else {
                    return n;
                }
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    public static boolean isLeap(int y) {//
        boolean result = false;
        if ((y % 400 == 0) || (y % 4 == 0) && (y % 100 == 0)) {
            return true;
        }
        return false;
    }

    public static boolean valid(int y, int m, int d) {
        if (y < 0 || m < 0 || d < 0 || d > 31) {
            return false;
        }
        int maxD = 31;//
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            maxD = 30;
        } else if (m == 2) {
            if (isLeap(y)) {
                maxD = 29;
            } else {
                maxD = 28;
            }//
        }
        return d <= maxD;
    }

    public static long toDate(String ymd) {
        StringTokenizer stk = new StringTokenizer(ymd, "/-");
        int y = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int d = Integer.parseInt(stk.nextToken());
        if (!valid(y, m, d)) {
            return -1;
        }
        Calendar cal = Calendar.getInstance();
        cal.set(y, m - 1, d);
        long t = cal.getTime().getTime();
        return t;
    }
//
    public static String getDate(String msg, String format, String waring, String erorMsg) {
        String result;
        while (true) {
            System.out.println(msg);
            result = sc.nextLine().trim();
            if (result.trim().isEmpty()) {
                System.out.println(waring);
            } else if (result.matches(format) && result.length() < 20) {
                Date d = new Date(System.currentTimeMillis());

                long t = toDate(result);//
                if (t < 0) {
                    System.out.println(waring);
                } else {
                    return result;
                }

            } 
            else {
                System.out.println(erorMsg);
            }
        }

    }
    
     public static String getQuestion(String question, String warning, String error) {
        String result;
        while (true) {
            System.out.println(question);
            result = sc.nextLine().trim().toUpperCase();
            checkValid = result.matches("^[YNyn01]{1}");
            if (result.isEmpty()) {
                System.out.println(warning);//
            } else if (result.equalsIgnoreCase("0") || result.equalsIgnoreCase("1") || result.equalsIgnoreCase("n")|| result.equalsIgnoreCase("y")) {
                return result;
            } else {
                System.out.println(error);
            }
        }
    }
}
//