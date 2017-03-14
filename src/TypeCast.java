/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ElizabethReed PC
 */
public class TypeCast {
    
    public int digit2Ascii(char input){ //char to ascii
         
         int ascii = (int) input;
         if(ascii >= 48 && ascii <= 57)
            ascii = ascii - 48; //only accounts for digits 0-9
            
         else if(ascii >= 65 && ascii <= 90){
             ascii = ascii - 55; //capitol letters
         }
         else
             System.out.println("Out of range!");
         return ascii;
    }   
     
     public char int2char(int base10num){ //reverses above process
        if(base10num >=0 && base10num <= 9){
            return(char)(base10num + 48); //returns digits 0-9
        }
        else{
            return(char)(base10num + 55); //returns a letter
        }
     }
      
     public StringBuilder toCaps(String user_string){

        StringBuilder newString = new StringBuilder();
        //iterate through each char
        for(int i = 0; i <= user_string.length(); i++){
            char capString = Character.toUpperCase(user_string.charAt(i)); //debugg later
            newString.append(capString);
        }
        return newString;
     }
}
