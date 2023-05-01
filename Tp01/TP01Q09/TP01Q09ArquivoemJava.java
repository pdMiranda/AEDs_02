package TP01Q09;

public class TP01Q09ArquivoemJava {
    public static void CriaArquivo(){
        int n = MyIO.readInt();
        double valor;
        Arq.openWrite("ArquivoEmJava.txt");
        for(int i = 0; i < n; i++){
            valor = MyIO.readDouble();
            Arq.println(valor);
        }
        Arq.close();
    }

    public static void main(String[] args) {
        CriaArquivo();
    }

}
