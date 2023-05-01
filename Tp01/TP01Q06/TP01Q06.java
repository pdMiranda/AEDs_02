import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class TP01Q06 {
        /*
         * Procura por nao-vogais na string. se achar, retorna false.
         */
        public static boolean isVogal(String entrada) {
                boolean isVogal = true;
                for (int i = 0; i < entrada.length(); i++) {
                        if (entrada.charAt(i) != 'a' && entrada.charAt(i) != 'e' && entrada.charAt(i) != 'i'
                                        && entrada.charAt(i) != 'o' && entrada.charAt(i) != 'u'
                                        && entrada.charAt(i) != 'A' && entrada.charAt(i) != 'E'
                                        && entrada.charAt(i) != 'I'
                                        && entrada.charAt(i) != 'O' && entrada.charAt(i) != 'U')
                        // Checa entre todas vogais se o char da iteracao pertence a um deles. Se nao
                        // pertencer, a string
                        // nao eh considerada contendo apenas vogais
                        {
                                isVogal = false;
                                break;
                        }
                }
                return isVogal;
        }

        public static boolean isConso(String entrada) {
                char[] consoantes = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't',
                                'v', 'w', 'x', 'y', 'z' };
                boolean isConso = true;
                int naoConsoante;
                for (int i = 0; i < entrada.length(); i++) {
                        naoConsoante = 0;
                        for (int j = 0; j < consoantes.length; j++) {
                                // Percore o entrada.charAt(i) por todo array de consoantes. A cada consoante
                                // diferente do char, a variavel
                                // naoConsoante aumenta em 1. Se seu valor for igual ao do tamanho do array de
                                // consoantes, sabemos que a
                                // letra nao eh consoante (pois foi diferente de todas).
                                if (entrada.charAt(i) != consoantes[j]) {
                                        naoConsoante++;
                                }
                        }

                        if (naoConsoante == consoantes.length) {
                                isConso = false;
                                break;
                        }
                }
                return isConso;
        }

        /*
         * Verifica se uma string eh composta apenas por numeros
         */

        public static boolean isInt(String entrada) {
                char[] numeros = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
                boolean isInt = true;
                int quantNaoInteiros;
                for (int i = 0; i < entrada.length(); i++) {
                        quantNaoInteiros = 0;
                        for (int j = 0; j < numeros.length; j++) {
                                // Verifica se a letra na posicao i eh um numero. Para isso, segue a mesma
                                // logica de validacao da funcao acima
                                if (entrada.charAt(i) != numeros[j]) {
                                        quantNaoInteiros++;
                                }
                        }

                        if (quantNaoInteiros == numeros.length) {
                                isInt = false;
                                break;
                        }
                }

                return isInt;
        }

        /*
         * Verifica se uma string eh validada como um numero float
         */
        public static boolean isFloat(String entrada) {
                char[] numeros = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', ',' };
                boolean isFloat = true;
                int quantNaoFloats;
                int quantPontos = 0;

                // Tambem segue a mesma logica de validacao da funcao isConso(), mas essa tambem
                // conta a
                // quantidade de pontos '.' ou ',' na string. Um numero real nao pode ter uma
                // quantidade de pontos diferente de 1,
                // Por isso existe a variavel quantPontos. Se ela for maior que 1, a funcao
                // retorna false, mesmo se todos outros caracteres
                // forem numeros
                for (int i = 0; i < entrada.length(); i++) {
                        quantNaoFloats = 0;
                        if (entrada.charAt(i) == '.' || entrada.charAt(i) == ',') {
                                quantPontos++; // Se cair aqui eh pq o char na posicao i eh um ponto, entao nao tem
                                               // porque testar com o array
                                continue;
                        }

                        for (int j = 0; j < numeros.length; j++) {

                                if (entrada.charAt(i) != numeros[j]) {
                                        quantNaoFloats++;
                                }
                        }

                        if (quantNaoFloats == numeros.length) {
                                isFloat = false;
                                break;
                        }
                }

                if (quantPontos > 1) {
                        isFloat = false;
                }

                return isFloat;
        }

        /*
         * Verifica se a palavra inserida pelo usuario eh igual a FIM. Se for diferente,
         * retorna True
         */
        public static boolean notFim(String string) {
                boolean notFim = false;

                if (string.charAt(0) != 'F' || string.charAt(1) != 'I' || string.charAt(2) != 'M') {
                        notFim = true;
                }

                return notFim;
        }

        public static void main(String[] args) {
                boolean notFim, isVogal, isConso, isInt, isFloat;
                String entrada = new String();
                do {
                        entrada = MyIO.readLine();
                        notFim = notFim(entrada); // Se string for diferente de FIM, a execucao continua
                        if (notFim) {
                                isVogal = isVogal(entrada); // Passando a string para os metodos
                                isConso = isConso(entrada);
                                isInt = isInt(entrada);
                                isFloat = isFloat(entrada);

                                if (isVogal) {
                                        MyIO.print("SIM ");
                                } else {
                                        MyIO.print("NAO ");
                                }

                                if (isConso) {
                                        MyIO.print("SIM ");
                                } else {
                                        MyIO.print("NAO ");
                                }

                                if (isInt) {
                                        MyIO.print("SIM ");
                                } else {
                                        MyIO.print("NAO ");
                                }

                                if (isFloat) {
                                        MyIO.println("SIM");
                                } else {
                                        MyIO.println("NAO");
                                }

                        }
                } while (notFim);
        }
}

class MyIO {

        private static BufferedReader in = new BufferedReader(
                        new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));
        private static String charset = "ISO-8859-1";

        public static void setCharset(String charset_) {
                charset = charset_;
                in = new BufferedReader(new InputStreamReader(System.in, Charset.forName(charset)));
        }

        public static void print() {
        }

        public static void print(int x) {
                try {
                        PrintStream out = new PrintStream(System.out, true, charset);
                        out.print(x);
                } catch (UnsupportedEncodingException e) {
                        System.out.println("Erro: charset invalido");
                }
        }

        public static void print(double x) {
                try {
                        PrintStream out = new PrintStream(System.out, true, charset);
                        out.print(x);
                } catch (UnsupportedEncodingException e) {
                        System.out.println("Erro: charset invalido");
                }
        }

        public static void print(String x) {
                try {
                        PrintStream out = new PrintStream(System.out, true, charset);
                        out.print(x);
                } catch (UnsupportedEncodingException e) {
                        System.out.println("Erro: charset invalido");
                }
        }

        public static void print(boolean x) {
                try {
                        PrintStream out = new PrintStream(System.out, true, charset);
                        out.print(x);
                } catch (UnsupportedEncodingException e) {
                        System.out.println("Erro: charset invalido");
                }
        }

        public static void print(char x) {
                try {
                        PrintStream out = new PrintStream(System.out, true, charset);
                        out.print(x);
                } catch (UnsupportedEncodingException e) {
                        System.out.println("Erro: charset invalido");
                }
        }

        public static void println() {
        }

        public static void println(int x) {
                try {
                        PrintStream out = new PrintStream(System.out, true, charset);
                        out.println(x);
                } catch (UnsupportedEncodingException e) {
                        System.out.println("Erro: charset invalido");
                }
        }

        public static void println(double x) {
                try {
                        PrintStream out = new PrintStream(System.out, true, charset);
                        out.println(x);
                } catch (UnsupportedEncodingException e) {
                        System.out.println("Erro: charset invalido");
                }
        }

        public static void println(String x) {
                try {
                        PrintStream out = new PrintStream(System.out, true, charset);
                        out.println(x);
                } catch (UnsupportedEncodingException e) {
                        System.out.println("Erro: charset invalido");
                }
        }

        public static void println(boolean x) {
                try {
                        PrintStream out = new PrintStream(System.out, true, charset);
                        out.println(x);
                } catch (UnsupportedEncodingException e) {
                        System.out.println("Erro: charset invalido");
                }
        }

        public static void println(char x) {
                try {
                        PrintStream out = new PrintStream(System.out, true, charset);
                        out.println(x);
                } catch (UnsupportedEncodingException e) {
                        System.out.println("Erro: charset invalido");
                }
        }

        public static void printf(String formato, double x) {
                try {
                        PrintStream out = new PrintStream(System.out, true, charset);
                        out.printf(formato, x);// "%.2f"
                } catch (UnsupportedEncodingException e) {
                        System.out.println("Erro: charset invalido");
                }
        }

        public static double readDouble() {
                double d = -1;
                try {
                        d = Double.parseDouble(readString().trim().replace(",", "."));
                } catch (Exception e) {
                }
                return d;
        }

        public static double readDouble(String str) {
                try {
                        PrintStream out = new PrintStream(System.out, true, charset);
                        out.print(str);
                } catch (UnsupportedEncodingException e) {
                        System.out.println("Erro: charset invalido");
                }
                return readDouble();
        }

        public static float readFloat() {
                return (float) readDouble();
        }

        public static float readFloat(String str) {
                return (float) readDouble(str);
        }

        public static int readInt() {
                int i = -1;
                try {
                        i = Integer.parseInt(readString().trim());
                } catch (Exception e) {
                }
                return i;
        }

        public static int readInt(String str) {
                try {
                        PrintStream out = new PrintStream(System.out, true, charset);
                        out.print(str);
                } catch (UnsupportedEncodingException e) {
                        System.out.println("Erro: charset invalido");
                }
                return readInt();
        }

        public static String readString() {
                String s = "";
                char tmp;
                try {
                        do {
                                tmp = (char) in.read();
                                if (tmp != '\n' && tmp != ' ' && tmp != 13) {
                                        s += tmp;
                                }
                        } while (tmp != '\n' && tmp != ' ');
                } catch (IOException ioe) {
                        System.out.println("lerPalavra: " + ioe.getMessage());
                }
                return s;
        }

        public static String readString(String str) {
                try {
                        PrintStream out = new PrintStream(System.out, true, charset);
                        out.print(str);
                } catch (UnsupportedEncodingException e) {
                        System.out.println("Erro: charset invalido");
                }
                return readString();
        }

        public static String readLine() {
                String s = "";
                char tmp;
                try {
                        do {
                                tmp = (char) in.read();
                                if (tmp != '\n' && tmp != 13) {
                                        s += tmp;
                                }
                        } while (tmp != '\n');
                } catch (IOException ioe) {
                        System.out.println("lerPalavra: " + ioe.getMessage());
                }
                return s;
        }

        public static String readLine(String str) {
                try {
                        PrintStream out = new PrintStream(System.out, true, charset);
                        out.print(str);
                } catch (UnsupportedEncodingException e) {
                        System.out.println("Erro: charset invalido");
                }
                return readLine();
        }

        public static char readChar() {
                char resp = ' ';
                try {
                        resp = (char) in.read();
                } catch (Exception e) {
                }
                return resp;
        }

        public static char readChar(String str) {
                try {
                        PrintStream out = new PrintStream(System.out, true, charset);
                        out.print(str);
                } catch (UnsupportedEncodingException e) {
                        System.out.println("Erro: charset invalido");
                }
                return readChar();
        }

        public static boolean readBoolean() {
                boolean resp = false;
                String str = "";

                try {
                        str = readString();
                } catch (Exception e) {
                }

                if (str.equals("true") || str.equals("TRUE") || str.equals("t") || str.equals("1") ||
                                str.equals("verdadeiro") || str.equals("VERDADEIRO") || str.equals("V")) {
                        resp = true;
                }

                return resp;
        }

        public static boolean readBoolean(String str) {
                try {
                        PrintStream out = new PrintStream(System.out, true, charset);
                        out.print(str);
                } catch (UnsupportedEncodingException e) {
                        System.out.println("Erro: charset invalido");
                }
                return readBoolean();
        }

        public static void pause() {
                try {
                        in.read();
                } catch (Exception e) {
                }
        }

        public static void pause(String str) {
                try {
                        PrintStream out = new PrintStream(System.out, true, charset);
                        out.print(str);
                } catch (UnsupportedEncodingException e) {
                        System.out.println("Erro: charset invalido");
                }
                pause();
        }
}
