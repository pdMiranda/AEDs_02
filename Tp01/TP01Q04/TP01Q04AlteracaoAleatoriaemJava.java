import java.util.Random;

public class TP01Q04AlteracaoAleatoriaemJava {

    public static boolean isFim(String s){
        return ((s.length() == 3) && (s.charAt(0) == 'F') && (s.charAt(1) == 'I') && (s.charAt(2) == 'M'));
    }

    public static String Aleatorio(String s, char char1, char char2){
        String str = "";

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == char1){
                str += char2;
            }
            else{
                str += s.charAt(i);
            }
        }

        return str;
    }

    public static void main(String args[]){
        String[] entrada = new String[1000];
        int numEntrada = 0;

        Random genarator = new Random();
        genarator.setSeed(4);



        do{
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; 
        
        for(int i = 0; i < numEntrada; i++){
            char char1 = (char)('a' + Math.abs(genarator.nextInt())%26);
            char char2 = (char)('a' + Math.abs(genarator.nextInt())%26);
            System.out.println(Aleatorio(entrada[i], char1, char2));
        }
         
    }


}
