import java.io.*;
import java.nio.charset.*;

class MyIO {

   private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));
   private static String charset = "ISO-8859-1";

   public static void setCharset(String charset_){
      charset = charset_;
      in = new BufferedReader(new InputStreamReader(System.in, Charset.forName(charset)));
   }

   public static void print(){
   }

   public static void print(int x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void print(double x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void print(String x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void print(boolean x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void print(char x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(){
   }

   public static void println(int x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(double x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(String x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(boolean x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void println(char x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static void printf(String formato, double x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.printf(formato, x);// "%.2f"
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }

   public static double readDouble(){
      double d = -1;
      try{
         d = Double.parseDouble(readString().trim().replace(",","."));
      }catch(Exception e){}
      return d;
   }

   public static double readDouble(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readDouble();
   }

   public static float readFloat(){
      return (float) readDouble();
   }

   public static float readFloat(String str){
      return (float) readDouble(str);
   }

   public static int readInt(){
      int i = -1;
      try{
         i = Integer.parseInt(readString().trim());
      }catch(Exception e){}
      return i;
   }

   public static int readInt(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readInt();
   }

   public static String readString(){
      String s = "";
      char tmp;
      try{
         do{
            tmp = (char)in.read();
            if(tmp != '\n' && tmp != ' ' && tmp != 13){
               s += tmp;
            }
         }while(tmp != '\n' && tmp != ' ');
      }catch(IOException ioe){
         System.out.println("lerPalavra: " + ioe.getMessage());
      }
      return s;
   }

   public static String readString(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readString();
   }

   public static String readLine(){
      String s = "";
      char tmp;
      try{
         do{
            tmp = (char)in.read();
            if(tmp != '\n' && tmp != 13){
               s += tmp;
            }
         }while(tmp != '\n');
      }catch(IOException ioe){
         System.out.println("lerPalavra: " + ioe.getMessage());
      }
      return s;
   }

   public static String readLine(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readLine();
   }

   public static char readChar(){
      char resp = ' ';
      try{
         resp  = (char)in.read();
      }catch(Exception e){}
      return resp;
   }

   public static char readChar(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readChar();
   }

   public static boolean readBoolean(){
      boolean resp = false;
      String str = "";

      try{
         str = readString();
      }catch(Exception e){}

      if(str.equals("true") || str.equals("TRUE") || str.equals("t") || str.equals("1") || 
            str.equals("verdadeiro") || str.equals("VERDADEIRO") || str.equals("V")){
         resp = true;
            }

      return resp;
   }

   public static boolean readBoolean(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readBoolean();
   }

   public static void pause(){
      try{
         in.read();
      }catch(Exception e){}
   }

   public static void pause(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      pause();
   }
}

class Celula{
	//atributos
	Celula sup;
	Celula dir;
	Celula inf;
	Celula esq;
	int elemento;
	
	/*
	*Construtor com elemento
	*@param int elemento
	*/
	public Celula(int x){
		sup=dir=inf=esq=null;
		elemento = x;
	}

	/*
	*Construtor padrao
	*/
	public Celula(){
		this(0);
	}
}

/*
*Classe Matrix
*/
class Matrix{
	//atributos
	Celula inicio;
	
	/*
	*Construtor padrao
	*/
	public Matrix(){
		inicio=null;
	}

	/*
	*Construtor matriz
	*@param int linhas, int colunas
	*/
	public Matrix(int linhas, int colunas){
		inicio = novaLinha(colunas);
		for(int i=1; i<linhas; i++){
			conectarLinha(novaLinha(colunas));
		}
	}
	
	/*
	*novaLinha - cria uma nova linha 
	*@param numero de colunas
	*@return inicio da nova linha
	*/
	private Celula novaLinha(int colunas){
		Celula comeco = new Celula();
		Celula i = comeco;
		for(int j=1; j<colunas;j++){
			i.dir=new Celula();
			i.dir.esq = i;
			i=i.dir;
		}
		i=null;
		return comeco;			
	}

	/*
	*conectarLinha
	*@param Celula inicio da nova linha
	*/
	private void conectarLinha (Celula comeco){
		Celula i;
		for(i=inicio; i.inf!=null; i=i.inf);

		while (i!=null && comeco!=null){
			i.inf=comeco;
			comeco.sup=i;

			i=i.dir;
			comeco=comeco.dir;
		}
		i=null;
	}	
	
	/*
	*mostrar - mostra a matriz
	*/
	public void mostrar(){
		Celula i = inicio;
		
		while(i!=null){
			for (Celula j=i; j!=null; j=j.dir){
				MyIO.print(j.elemento+" ");
			}
			MyIO.println("");	
			i=i.inf;
		}
		i=null;
	}

	/*
	*mostrarPrincipal - mostra a diagonal Principal
	*/
	public void mostrarPrincipal() throws Exception{
		Celula i = inicio;
		
		if(nLinhas()!=nColunas())
			throw new Exception("Matriz nao Quadrada");

		while(i!=null){
			MyIO.print(i.elemento+" ");
			i=i.dir;
			if(i!=null)
				i=i.inf;
		}
		MyIO.println("");
		i=null;
	}	

	/*
	*mostrarSecundaria - Mostra a diagonal secundaria
	*/
	public void mostrarSecundaria() throws Exception{
		Celula i = inicio;
		
		if(nLinhas()!=nColunas())
			throw new Exception("Matriz nao Quadrada");

		for(; i.dir!=null; i=i.dir);
	
		while(i!=null){
			MyIO.print(i.elemento+" ");
			i=i.esq;
			if(i!=null)
				i=i.inf;
		}
		MyIO.println("");
		i=null;
	}

	/*
	*nLinhas - conta o numero de linhas da matriz
	*@return int numero de linhas
	*/
	private int nLinhas(){
		int n=0;
		for(Celula i=inicio; i!=null; i=i.dir, n++);
		return n;
	}

	/*
	*nColunas - conta o numero de colunas da matriz
	*@return int numero de colunas
	*/
	private int nColunas(){
		int n=0;
		for(Celula i=inicio; i!=null; i=i.inf, n++);
		return n;
	}
	
	/*
	*inserir - inserer um elemento na matriz
	*@param int elemento, int linha, int coluna
	*/
	public void inserir(int x, int l, int c) throws Exception{
		if(l>nLinhas() || c>nColunas())
			throw new Exception("Posicao Inexistente");
		Celula tmp=inicio;
		for(int i=0; i<l; i++, tmp=tmp.inf);
		for(int i=0; i<c; i++, tmp=tmp.dir);

		tmp.elemento=x;
		tmp=null;
	}

	/*somar - soma duas matrizes
	*@param matriz a ser somada com objeto
	*@return Matriz resultante
	*/
	public Matrix somar(Matrix b) throws Exception{
		if(this.nLinhas() != b.nLinhas() || this.nColunas() !=b.nColunas())
			throw new Exception("Matrizes de tamanhos diferentes");

		Matrix resp = new Matrix(this.nLinhas(), this.nColunas());

		Celula a_linha, a_cel, b_linha, b_cel, resp_linha, resp_cel;

		a_linha = a_cel = this.inicio;	
		b_linha =  b_cel = b.inicio;
		resp_linha = resp_cel = resp.inicio;
	
		while(a_linha!=null || b_linha!=null || resp_linha!=null){
			while(a_cel!=null || b_cel!=null || resp_cel!=null){
				resp_cel.elemento = a_cel.elemento + b_cel.elemento;
				
				a_cel=a_cel.dir;
				b_cel=b_cel.dir;
				resp_cel=resp_cel.dir;
			}				
			a_linha = a_cel = a_linha.inf;
			b_linha = b_cel = b_linha.inf;
			resp_linha = resp_cel = resp_linha.inf;
		}
		return resp;
	}

	private static int mult(Celula a, Celula b){
		int resp = 0;
		while (a!=null && b!=null){
			resp = resp + a.elemento * b.elemento;
	
			a=a.dir;
			b=b.inf;
		}
		return resp;
	}

	/*multiplicar - multiplica duas matrizes
	*@param matriz a ser multiplicada com objeto
	*@return Matriz resultante
	*/
	public Matrix multiplicar(Matrix b) throws Exception{
		if (this.nLinhas()!=b.nColunas()||this.nColunas()==0||b.nLinhas()==0||b.nColunas()==0)
			throw new Exception("Matriz vazia");
		Matrix resp = new Matrix (this.nLinhas(), b.nColunas());

		Celula a_linha, b_coluna, resp_linha, resp_cel;

		a_linha  = this.inicio;	
		b_coluna  = b.inicio;
		resp_linha = resp_cel = resp.inicio;
			
		while(resp_linha!=null){
			while(resp_cel!=null){
				resp_cel.elemento = mult(a_linha, b_coluna);
				
				resp_cel=resp_cel.dir;
				b_coluna=b_coluna.dir;
			}
			
			resp_linha=resp_cel=resp_linha.inf;
			b_coluna=b.inicio;
			a_linha=a_linha.inf;
		}
		return resp;
	}
}

public class TP04Q07{
	public static void main (String[] args) throws Exception{
		int testes = MyIO.readInt();
		
		for (int i=0; i<testes; i++){
			int linhas = MyIO.readInt();
			int colunas = MyIO.readInt();
			
			Matrix matriz1 = new Matrix(linhas, colunas);
			
			for (int l=0; l<linhas; l++){
				for(int c=0; c<colunas; c++){
					matriz1.inserir(MyIO.readInt(), l, c);
				}
			}	
			linhas = MyIO.readInt();
			colunas = MyIO.readInt();
			
			Matrix matriz2 = new Matrix(linhas, colunas);
			
			for (int l=0; l<linhas; l++){
				for(int c=0; c<colunas; c++){
					matriz2.inserir(MyIO.readInt(), l, c);
				}
			}
			
			matriz1.mostrarPrincipal();
			matriz1.mostrarSecundaria();
			Matrix matriz3 = matriz1.somar(matriz2);
			matriz3.mostrar();
			matriz3 = matriz1.multiplicar(matriz2);
			matriz3.mostrar();
  		}		
	}
}