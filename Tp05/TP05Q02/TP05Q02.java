import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

class Game {

    static SimpleDateFormat default_dateFormat = new SimpleDateFormat("MMM/yyyy", Locale.ENGLISH);

    private String name, owners, website, developers;
    private ArrayList<String> languages, genres;
    private Date release_date;
    private int app_id, age, dlcs, avg_playtime;
    private float price, upvotes;
    private boolean windows, mac, linux;

    public Game() {

        this.name = this.owners = this.website = this.developers = null;
        this.languages = new ArrayList<String>();
        this.genres = new ArrayList<String>();
        this.release_date = null;
        this.app_id = this.age = this.dlcs = this.avg_playtime = -1;
        this.price = this.upvotes = -1;
        this.windows = this.mac = this.linux = false;
    }

    public Game(String name, String owners, String website, String developers, ArrayList<String> languages,
            ArrayList<String> genres, Date release_date, int app_id, int age, int dlcs, int upvotes, int avg_playtime,
            float price, boolean windows, boolean mac, boolean linux) {

        this.name = name;
        this.owners = owners;
        this.website = website;
        this.developers = developers;
        this.languages = languages;
        this.genres = genres;
        this.release_date = release_date;
        this.app_id = app_id;
        this.age = age;
        this.dlcs = dlcs;
        this.upvotes = upvotes;
        this.avg_playtime = avg_playtime;
        this.price = price;
        this.windows = windows;
        this.mac = mac;
        this.linux = linux;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setDevelopers(String developers) {
        this.developers = developers;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public void setReleaseDate(Date release_date) {
        this.release_date = release_date;
    }

    public void setAppId(int app_id) {
        this.app_id = app_id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDlcs(int dlcs) {
        this.dlcs = dlcs;
    }

    public void setAvgPlaytime(int avg_playtime) {
        this.avg_playtime = avg_playtime;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setUpvotes(float upvotes) {
        this.upvotes = upvotes;
    }

    public void setWindows(boolean windows) {
        this.windows = windows;
    }

    public void setMac(boolean mac) {
        this.mac = mac;
    }

    public void setLinux(boolean linux) {
        this.linux = linux;
    }

    public String getName() {
        return this.name;
    }

    public String getOwners() {
        return this.owners;
    }

    public String getWebsite() {
        return this.website;
    }

    public String getDevelopers() {
        return this.developers;
    }

    public ArrayList<String> getLanguages() {
        return this.languages;
    }

    public ArrayList<String> getGenres() {
        return this.genres;
    }

    public Date getReleaseDate() {
        return this.release_date;
    }

    public int getAppId() {
        return this.app_id;
    }

    public int getAge() {
        return this.age;
    }

    public int getDlcs() {
        return this.dlcs;
    }

    public int getAvgPlaytime() {
        return this.avg_playtime;
    }

    public float getPrice() {
        return this.price;
    }

    public float getUpvotes() {
        return this.upvotes;
    }

    public boolean getWindows() {
        return this.windows;
    }

    public boolean getMac() {
        return this.mac;
    }

    public boolean getLinux() {
        return this.linux;
    }

    public Game clone() {

        Game cloned = new Game();

        cloned.name = this.name;
        cloned.owners = this.owners;
        cloned.website = this.website;
        cloned.developers = this.developers;
        cloned.languages = this.languages;
        cloned.genres = this.genres;
        cloned.release_date = this.release_date;
        cloned.app_id = this.app_id;
        cloned.age = this.age;
        cloned.dlcs = this.dlcs;
        cloned.avg_playtime = this.avg_playtime;
        cloned.price = this.price;
        cloned.upvotes = this.upvotes;
        cloned.windows = this.windows;
        cloned.mac = this.mac;
        cloned.linux = this.linux;

        return cloned;
    }

    public void read(String line) {

        char c_search;
        int index = 0, atr_index = 0;

        // ---------------------------------- //

        // Find "AppID"
        while (true) {

            index++;

            if (line.charAt(index) == ',') {

                this.app_id = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //

        // Find "Name"
        if (line.charAt(atr_index) != ',') {

            if (line.charAt(atr_index) == '\"') {

                atr_index++;
                c_search = '\"';
            } else
                c_search = ',';

            while (true) {

                index++;

                if (line.charAt(index) == c_search) {

                    this.name = line.substring(atr_index, index);

                    if (c_search == ',')
                        index++;
                    else if (c_search == '\"')
                        index += 2;

                    atr_index = index;
                    break;
                }
            }
        } else
            atr_index = ++index;

        // ---------------------------------- //

        // Find release date
        if (line.charAt(atr_index) != ',') {

            SimpleDateFormat df;

            if (line.charAt(atr_index) == '\"') {

                df = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);

                atr_index++;
                c_search = '\"';
            } else {

                df = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);

                c_search = ',';
            }

            while (true) {

                index++;

                if (line.charAt(index) == c_search) {

                    try {
                        this.release_date = df.parse(line.substring(atr_index, index));
                    } catch (java.text.ParseException e) {
                        e.printStackTrace();
                    }

                    if (c_search == ',')
                        index++;
                    else if (c_search == '\"')
                        index += 2;

                    atr_index = index;
                    break;
                }
            }
        } else
            atr_index = ++index;

        // ---------------------------------- //

        // Find "Owners"
        while (true) {

            index++;

            if (line.charAt(index) == ',') {

                this.owners = line.substring(atr_index, index);

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //

        // Find "Age"
        while (true) {

            index++;

            if (line.charAt(index) == ',') {

                this.age = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //

        // Find "Price"
        while (true) {

            index++;

            if (line.charAt(index) == ',') {

                this.price = Float.parseFloat(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //

        // Find "DLCs"
        while (true) {

            index++;

            if (line.charAt(index) == ',') {

                this.dlcs = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //

        // Find "Languages"
        while (true) {

            index++;

            if (line.charAt(index) == ']') {

                index++;

                if (line.charAt(index) == ',')
                    index++;
                else if (line.charAt(index) == '\"')
                    index += 2;

                atr_index = index;
                break;
            } else if (line.charAt(index) == '\'') {

                int wordStart = index + 1;

                while (true) {

                    index++;

                    if (line.charAt(index) == '\'') {

                        this.languages.add(line.substring(wordStart, index));
                        break;
                    }
                }
            }
        }

        // ---------------------------------- //

        // Find "Website"
        if (line.charAt(atr_index) != ',') {

            if (line.charAt(atr_index) == '\"') {

                atr_index++;
                c_search = '\"';
            } else
                c_search = ',';

            while (true) {

                index++;

                if (line.charAt(index) == c_search) {

                    this.website = line.substring(atr_index, index);

                    atr_index = ++index;
                    break;
                }
            }
        } else
            atr_index = ++index;

        // ---------------------------------- //

        // Find "Windows"
        while (true) {

            index++;

            if (line.charAt(index) == ',') {

                this.windows = Boolean.parseBoolean(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // Find "Mac"
        while (true) {

            index++;

            if (line.charAt(index) == ',') {

                this.mac = Boolean.parseBoolean(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // Find "Linux"
        while (true) {

            index++;

            if (line.charAt(index) == ',') {

                this.linux = Boolean.parseBoolean(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //

        // Find "Upvotes"
        int positives, negatives;

        while (true) {

            index++;

            if (line.charAt(index) == ',') {

                positives = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        while (true) {

            index++;

            if (line.charAt(index) == ',') {

                negatives = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        this.upvotes = (float) (positives * 100) / (float) (positives + negatives);

        // ---------------------------------- //

        // Find "AVG Playtime"
        while (true) {

            index++;

            if (line.charAt(index) == ',') {

                this.avg_playtime = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //

        // Find "Developers"
        if (line.charAt(atr_index) != ',') {

            if (line.charAt(atr_index) == '\"') {

                atr_index++;
                c_search = '\"';
            } else
                c_search = ',';

            while (true) {

                index++;

                if (line.charAt(index) == c_search) {

                    this.developers = line.substring(atr_index, index);

                    atr_index = ++index;
                    break;
                }
            }
        } else
            atr_index = ++index;

        // ---------------------------------- //

        // Find "Genres"
        if (index < line.length() - 1) {

            if (line.charAt(index) == ',')
                atr_index = ++index;
            if (line.charAt(atr_index) == '\"') {

                atr_index++;

                while (true) {

                    index++;

                    if (line.charAt(index) == ',') {

                        this.genres.add(line.substring(atr_index, index));

                        atr_index = ++index;
                    } else if (line.charAt(index) == '\"') {

                        this.genres.add(line.substring(atr_index, line.length() - 1));
                        break;
                    }
                }
            } else
                this.genres.add(line.substring(atr_index, line.length()));
        }

        // --------------------------------------------------------------------------------
        // //
    }

    public String print() {

        String avg_pt = null;

        if (this.avg_playtime == 0)
            avg_pt = "null ";
        else if (this.avg_playtime < 60)
            avg_pt = this.avg_playtime + "m ";
        else {

            if (this.avg_playtime % 60 == 0)
                avg_pt = this.avg_playtime / 60 + "h ";
            else
                avg_pt = (this.avg_playtime / 60) + "h " + (this.avg_playtime % 60) + "m ";
        }

        DecimalFormat df = new DecimalFormat("##");

        return (this.app_id + " " + this.name + " " + default_dateFormat.format(this.release_date) + " " + this.owners
                + " " + this.age + " " + String.format(Locale.ENGLISH, "%.2f", this.price) + " " + this.dlcs + " "
                + this.languages + " " + this.website + " " + this.windows + " " + this.mac + " " + this.linux + " "
                + (Float.isNaN(this.upvotes) ? "0% " : df.format(this.upvotes) + "% ") + avg_pt + this.developers + " "
                + this.genres);
    }

    // --------------------------------------------------------------------------------------
    // //

}

class No {
    public char elemento; // Conteudo do no.
    public No esq; // No da esquerda.
    public No dir; // No da direita.
    public No2 outro;

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     */
    No(char elemento) {
        this.elemento = elemento;
        this.esq = this.dir = null;
        this.outro = null;
    }

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     * @param esq      No da esquerda.
     * @param dir      No da direita.
     */
    No(char elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.outro = null;
    }
}

class No2 {
    public Game elemento; // Conteudo do no.
    public No2 esq; // No da esquerda.
    public No2 dir; // No da direita.

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     */
    No2(Game elemento) {
        this.elemento = elemento;
        this.esq = this.dir = null;
    }

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     * @param esq      No2 da esquerda.
     * @param dir      No2 da direita.
     */
    No2(Game elemento, No2 esq, No2 dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

class ArvoreArvore {
    private No raiz; // Raiz da arvore.

    /**
     * Construtor da classe.
     */
    public ArvoreArvore() throws Exception {
        raiz = null;
    }

    /**
     * Metodo publico iterativo para inserir elemento.
     * 
     * @param x Elemento a ser inserido.
     * @throws Exception Se o elemento existir.
     */
    public void inserir(char x) throws Exception {
        raiz = inserir(x, raiz);
    }

    /**
     * Metodo privado recursivo para inserir elemento.
     * 
     * @param x Elemento a ser inserido.
     * @param i No em analise.
     * @return No em analise, alterado ou nao.
     * @throws Exception Se o elemento existir.
     */
    private No inserir(char x, No i) throws Exception {
        if (i == null) {
            i = new No(x);

        } else if (x < i.elemento) {
            i.esq = inserir(x, i.esq);

        } else if (x > i.elemento) {
            i.dir = inserir(x, i.dir);

        } else {
            //throw new Exception("Erro ao inserir!");
        }
        return i;
    }

    public void inserir(Game s) throws Exception {
        inserir(s, raiz);
    }

    public void inserir(Game s, No i) throws Exception {
        if (i == null) {
            throw new Exception("Erro ao inserir: caractere invalido!");

        } else if (s.getName().charAt(0) < i.elemento) {
            inserir(s, i.esq);

        } else if (s.getName().charAt(0) > i.elemento) {
            inserir(s, i.dir);

        } else {
            i.outro = inserir(s, i.outro);
        }
    }

    private No2 inserir(Game s, No2 i) throws Exception {
        if (i == null) {
            i = new No2(s);

        } else if (s.getName().compareTo(i.elemento.getName()) < 0) {
            i.esq = inserir(s, i.esq);

        } else if (s.getName().compareTo(i.elemento.getName()) > 0) {
            i.dir = inserir(s, i.dir);

        } else {
            throw new Exception("Erro ao inserir: elemento existente!");
        }

        return i;
    }

    public void pesquisar(String elemento){
        boolean resp;

        System.out.print("raiz ");
        resp = pesquisar(elemento, raiz);

        if (resp == true){
            System.out.println("SIM ");
        }
        else{
            System.out.println("NAO ");
        }
    }
  
    public boolean pesquisar(String elemento, No i){
        boolean resp = false;

        if (i != null){
            resp = pesquisar(elemento,i.outro);

            if(resp == false){
                System.out.print("ESQ ");
                resp = pesquisar(elemento,i.esq);
            }

            if(resp == false){
                System.out.print("DIR ");
                resp = pesquisar(elemento,i.dir);
            }

        }

        return resp;
    }

    private boolean pesquisar(String x, No2 no) {
        boolean resp;
        if (no == null) { 
            resp = false;
        } 
        else if (x.compareTo(no.elemento.getName()) < 0) { 
            System.out.print("esq ");
            resp = pesquisar(x, no.esq); 
        } 
        else if (x.compareTo(no.elemento.getName()) > 0) { 
            System.out.print("dir ");
            resp = pesquisar(x, no.dir); 
        } else { 
            resp = true; 
        }

        return resp;
    }
}

class TP05Q02 {
    public static boolean isFim(String str) {
        return str.compareTo("FIM") == 0;
    }

    public static String nameGame(String str) {
        String resp = "";
        for (int i = 2; i < str.length(); i++) {
            resp += str.charAt(i);
        }
        return resp;
    }

    public static Game getGame(int aptID, ArrayList<Game> games) {
        boolean found = false;
        int n = 0;
        Game resp = new Game();
        while (!found && n < games.size()) {
            if (games.get(n).getAppId() == aptID) {
                resp = games.get(n);
                found = true;
                n = games.size();
            }
            n++;
        }
        return resp;
    }

    public static void main(String[] args) throws Exception {
        String baseFile = "/tmp/games.csv";
        FileInputStream fstream = new FileInputStream(baseFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        Scanner sc = new Scanner(System.in);

        ArrayList<Game> games = new ArrayList<Game>();
        String line;

        String[] entradaPt1 = new String[1000];
        int numEntradaPt1 = 0;

        ArvoreArvore arvore = new ArvoreArvore();

        while ((line = br.readLine()) != null) {
            Game game = new Game();
            game.read(line);
            games.add(game);
        }

        do {
            entradaPt1[numEntradaPt1] = sc.nextLine();
            numEntradaPt1++;
        } while (!isFim(entradaPt1[numEntradaPt1 - 1]));
        numEntradaPt1--;

        for (int i = 0; i < numEntradaPt1; i++) {
            boolean found = false;
            int n = 0;
            while (!found && n < games.size()) {
                if (games.get(n).getAppId() == Integer.parseInt(entradaPt1[i])) {
                    arvore.inserir(games.get(n).getName().charAt(0));
                    arvore.inserir(games.get(n));
                    found = true;
                    n = games.size();
                }
                n++;
            }
        }

        int numEntradaPt2 = Integer.parseInt(sc.nextLine());
        String[] entradaPt2 = new String[numEntradaPt2];
        for (int i = 0; i < numEntradaPt2; i++) {
            entradaPt2[i] = sc.nextLine();
            if (entradaPt2[i].charAt(0) == 'I') {
                String[] split = entradaPt2[i].split(" ");
                arvore.inserir(getGame(Integer.parseInt(split[1]), games).getName().charAt(0));
                arvore.inserir(getGame(Integer.parseInt(split[1]), games));
            } else if (entradaPt2[i].charAt(0) == 'R') {
                //arvore.remover(nameGame(entradaPt2[i]));
            }
        }

        String[] entradaPt3 = new String[100];
        int numEntradaPt3 = 0;

        do {
            entradaPt3[numEntradaPt3] = sc.nextLine();
            numEntradaPt3++;
        } while (!isFim(entradaPt3[numEntradaPt3 - 1]));
        numEntradaPt3--;

        for (int i = 0; i < numEntradaPt3; i++) {
            System.out.println(entradaPt3[i]);
            arvore.pesquisar(entradaPt3[i]);
        }

        sc.close();
        br.close();

    }
}