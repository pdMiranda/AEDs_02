public class TP01Q01PalindromeemJava{

    public static boolean isPalindrome(String s){
        int numPari = 0;
        boolean isPal;
        for(int i = 0; i < s.length() - 1; i++){
            if((s.charAt(i) == s.charAt(s.length() -1 - i)) == false){
                numPari+= 1;
            }
        }
        if(numPari != 0) isPal = false;
        else isPal = true;
        return isPal;
    }

    public static boolean isFim(String s){
        return ((s.length() == 3) && (s.charAt(0) == 'F') && (s.charAt(1) == 'I' )&& (s.charAt(2) == 'M'));
    }

    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int numEntrada = 0;

        do{
            entrada[numEntrada] = MyIO.readLine();
            numEntrada++;
        }while(isFim(entrada[numEntrada - 1]) == false);
        numEntrada--;

        for(int i = 0; i < numEntrada; i++){
            if(isPalindrome(entrada[i])){
                System.out.println("SIM");
            }
            else{
                System.out.println("NAO");
            }
        }
    }
}
