package TP01Q03;

public class TP01Q03CiframentoemJava {

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String Criptografia(String s){
        String str = "";
        for(int i = 0; i < s.length(); i++){
            str += (char)(s.charAt(i) + 3);
        }
        return str;
    }

    public static void main(String args[]){
        String[] entrada = new String[1000];
        int numEntrada = 0;
        do{
            entrada[numEntrada] = MyIO.readLine();
            numEntrada++;
        }while(isFim(entrada[numEntrada - 1]) == false);
        numEntrada--;
        for(int i = 0; i < numEntrada; i++){
            System.out.println(Criptografia(entrada[i]));
        }
    }
}
