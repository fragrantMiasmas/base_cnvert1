/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ElizabethReed PC
 */

import java.util.ArrayList;
import java.lang.StringBuilder;

public class BaseChange {
    
    TypeCast TC = new TypeCast();

    //try with array instead of arraylist
     public boolean checkBase(String user_number, int user_old_base) { //iterate through each character to ensure it doesn't exceed old_base ascii value

        char[] digitCharArray = user_number.toCharArray();
     
        for (int i = 0; i < digitCharArray.length; i++) {

//            System.out.println("Char is " + digitCharArray[i]);
            char old_base = TC.int2char(user_old_base);
            int digit = TC.digit2Ascii(digitCharArray[i]); 
            int old_base_ascii = TC.digit2Ascii(old_base); //char old_base can only be 0-9, A-Z
            
            if( digit >= old_base_ascii){ 
                System.out.println(digitCharArray[i] + " exceeds base " + old_base_ascii);
                return false;
            }
            // System.out.println("This character is indeed in base " + old_base_int);
        }
        return true;
    }

    public int toBase10(String user_number, int old_base){ //multiply add method
        
        //start with first digit
        int total = 0;
        
        for(int i = 0; i< user_number.length(); i++){
            total = total * old_base + TC.digit2Ascii(user_number.charAt(i));
//            System.out.println(TC.digit2Ascii(user_number.charAt(i)));
        }
        return(total); //total becomes new middleman
    }
     
     public StringBuilder fromBase10(int middleman, int new_base) { //base 10 number is our middleman
        
        StringBuilder sb = new StringBuilder();
        
        //divide method
        int remainder = middleman % new_base;
        char asciiRemainder = TC.int2char(remainder);
        sb.append(asciiRemainder); 

        int semi_quotient = (middleman - remainder) / new_base;

        while (semi_quotient != 0) {

            remainder = semi_quotient % new_base; // until your semi quotient reaches zero
            asciiRemainder = TC.int2char(remainder);
            sb.append(asciiRemainder); // add to stringbuilder
            
            semi_quotient = (semi_quotient - remainder) / new_base;

        }
        return(sb.reverse());

    }
}
