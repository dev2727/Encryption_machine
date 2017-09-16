package sample;




 public class TextOriginal {
 static String textOrg;
 static char tabChar[] = new char[26];
 String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";






         public void remplirTab(String s){
         for(int i=0;i<s.length();i++){
         tabChar[i] = s.charAt(i);
         }

         }
        public boolean mod(int n){
           if (26%n == 0)
            return true;
             return false;
        }

         }
