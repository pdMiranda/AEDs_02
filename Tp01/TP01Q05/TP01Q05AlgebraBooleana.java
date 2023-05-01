package TP01Q05;

public class TP01Q05AlgebraBooleana {
    public static String String01(String s){
        String str  = "";
        int numBool = s.charAt(0);
        char varBool = s.charAt(2);
        for(int i = 0; i < numBool; i++){
            for(int j = 1; j < s.length(); i++){
                if(s.charAt(j) == 'A'){
                    str+= varBool;
                }
                else str += s.charAt(i);
            }
            varBool = s.charAt(4);
            for(int k = 1; k < s.length(); k++){
                if(s.charAt(k) == 'B'){
                    str += varBool;
                }
                else str += s.charAt(k);
            }
            if(numBool == 3){
                varBool = s.charAt(6);
                for(int l = 1; l < s.length(); l++){
                    if(s.charAt(l) == 'C'){
                        str += varBool;
                    }
                }
            }

        }

        return str;
    }
}
