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

    public Game(String name, String owners, String website, String developers, ArrayList<String> languages, ArrayList<String> genres, Date release_date, int app_id, int age, int dlcs, int upvotes, int avg_playtime, float price, boolean windows, boolean mac, boolean linux) {

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

    public void setName(String name) { this.name = name; }
    public void setOwners(String owners) { this.owners = owners; }
    public void setWebsite(String website) { this.website = website; }
    public void setDevelopers(String developers) { this.developers = developers; }
    public void setLanguages(ArrayList<String> languages) { this.languages = languages; }
    public void setGenres(ArrayList<String> genres) { this.genres = genres; }
    public void setReleaseDate(Date release_date) { this.release_date = release_date; }
    public void setAppId(int app_id) { this.app_id = app_id; }
    public void setAge(int age) { this.age = age; }
    public void setDlcs(int dlcs) { this.dlcs = dlcs; }
    public void setAvgPlaytime(int avg_playtime) { this.avg_playtime = avg_playtime; }
    public void setPrice(float price) { this.price = price; }
    public void setUpvotes(float upvotes) { this.upvotes = upvotes; }
    public void setWindows(boolean windows) { this.windows = windows; }
    public void setMac(boolean mac) { this.mac = mac; }
    public void setLinux(boolean linux) { this.linux = linux; }

    public String getName() { return this.name; }
    public String getOwners() { return this.owners; }
    public String getWebsite() { return this.website; }
    public String getDevelopers() { return this.developers; }
    public ArrayList<String> getLanguages() { return this.languages; }
    public ArrayList<String> getGenres() { return this.genres; }
    public Date getReleaseDate() { return this.release_date; }
    public int getAppId() { return this.app_id; }
    public int getAge() { return this.age; }
    public int getDlcs() { return this.dlcs; }
    public int getAvgPlaytime() { return this.avg_playtime; }
    public float getPrice() { return this.price; }
    public float getUpvotes() { return this.upvotes; }
    public boolean getWindows() { return this.windows; }
    public boolean getMac() { return this.mac; }
    public boolean getLinux() { return this.linux; }
    
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
        while(true) {

            index++;

            if(line.charAt(index) == ',') {
                
                this.app_id = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "Name"
        if(line.charAt(atr_index) != ',') {

            if(line.charAt(atr_index) == '\"') {
                
                atr_index++;
                c_search = '\"';
            }
            else c_search = ',';
            
            while(true) {

                index++;

                if(line.charAt(index) == c_search) {
                    
                    this.name = line.substring(atr_index, index);

                    if(c_search == ',') index++;
                    else if(c_search == '\"') index += 2;
                    
                    atr_index = index;
                    break;
                }
            }
        }
        else atr_index = ++index;

        // ---------------------------------- //
        
        // Find release date
        if(line.charAt(atr_index) != ',') {

            SimpleDateFormat df;
            
            if(line.charAt(atr_index) == '\"') {
                
                df = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);

                atr_index++;
                c_search = '\"';
            }
            else {
                
                df = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);

                c_search = ',';
            }

            while(true) {

                index++;

                if(line.charAt(index) == c_search) {
                    
                    try { this.release_date = df.parse(line.substring(atr_index, index)); } 
                    catch (java.text.ParseException e) { e.printStackTrace(); }

                    if(c_search == ',') index++;
                    else if(c_search == '\"') index += 2;
                    
                    atr_index = index;
                    break;
                }
            }
        }
        else atr_index = ++index;

        // ---------------------------------- //
        
        // Find "Owners"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {
                
                this.owners = line.substring(atr_index, index);

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "Age"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                this.age = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "Price"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {
                
                this.price = Float.parseFloat(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "DLCs"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {
                
                this.dlcs = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "Languages"
        while(true) {

            index++;

            if(line.charAt(index) == ']') {

                index++;
                
                if(line.charAt(index) == ',') index++;
                else if(line.charAt(index) == '\"') index += 2;

                atr_index = index;
                break;
            }
            else if(line.charAt(index) == '\'') {

                int wordStart = index + 1;

                while(true) {

                    index++;

                    if(line.charAt(index) == '\'') {
                        
                        this.languages.add(line.substring(wordStart, index));
                        break;
                    }
                }
            }
        }

        // ---------------------------------- //
        
        // Find "Website"
        if(line.charAt(atr_index) != ',') {

            if(line.charAt(atr_index) == '\"') {
                
                atr_index++;
                c_search = '\"';
            }
            else c_search = ',';
            
            while(true) {

                index++;

                if(line.charAt(index) == c_search) {
                    
                    this.website = line.substring(atr_index, index);

                    atr_index = ++index;
                    break;
                }
            }
        }
        else atr_index = ++index;

        // ---------------------------------- //
        
        // Find "Windows"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                this.windows = Boolean.parseBoolean(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // Find "Mac"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                this.mac = Boolean.parseBoolean(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // Find "Linux"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                this.linux = Boolean.parseBoolean(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "Upvotes"
        int positives, negatives;

        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                positives = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                negatives = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        this.upvotes = (float)(positives * 100) / (float)(positives + negatives);

        // ---------------------------------- //
        
        // Find "AVG Playtime"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                this.avg_playtime = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "Developers"
        if(line.charAt(atr_index) != ',') {

            if(line.charAt(atr_index) == '\"') {
                
                atr_index++;
                c_search = '\"';
            }
            else c_search = ',';
            
            while(true) {

                index++;

                if(line.charAt(index) == c_search) {
                    
                    this.developers = line.substring(atr_index, index);

                    atr_index = ++index;
                    break;
                }
            }
        }
        else atr_index = ++index;
       
        // ---------------------------------- //
        
        // Find "Genres"
        if(index < line.length() - 1) {

            if(line.charAt(index) == ',') atr_index = ++index;                    
            if(line.charAt(atr_index) == '\"') {

                atr_index++;
                
                while(true) {

                    index++;

                    if(line.charAt(index) == ',') {
                        
                        this.genres.add(line.substring(atr_index, index));

                        atr_index = ++index;
                    }
                    else if(line.charAt(index) == '\"') {

                        this.genres.add(line.substring(atr_index, line.length() - 1));
                        break;
                    }
                }
            }
            else this.genres.add(line.substring(atr_index, line.length()));
        }

        // -------------------------------------------------------------------------------- //
    }

    public void print() {

        String avg_pt = null;

        if(this.avg_playtime == 0) avg_pt = "null ";
        else if(this.avg_playtime < 60) avg_pt = this.avg_playtime + "m ";
        else {

            if(this.avg_playtime % 60 == 0) avg_pt = this.avg_playtime / 60 + "h ";
            else avg_pt = (this.avg_playtime / 60) + "h " + (this.avg_playtime % 60) + "m ";
        }

        DecimalFormat df = new DecimalFormat("##");

        System.out.println(this.app_id + " " + this.name + " " + default_dateFormat.format(this.release_date) + " " + this.owners + " " + this.age + " " + String.format(Locale.ENGLISH, "%.2f", this.price) + " " + this.dlcs + " " + this.languages + " " + this.website + " " + this.windows + " " + this.mac + " " + this.linux + " " + (Float.isNaN(this.upvotes) ? "0% " : df.format(this.upvotes) + "% ") + avg_pt + this.developers + " " + this.genres);
    }

    // -------------------------------------------------------------------------------------- //
    
}    


public class TP03Q05 {

    public static int count1 = 0;
    public static int count2 = 0;

    public static boolean isFim(String str){
        return str.compareTo("FIM") == 0;
    }


    public static void swap( Game[] array,int i, int j) {
        Game temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void construir(Game[] array, int tamHeap){
        for(int i = tamHeap; i > 1 && array[i].getReleaseDate().before(array[i/2].getReleaseDate()); i /= 2){
            swap(array, i, i/2);
        }
    }

    public static void reconstruir(Game[] array, int tamHeap){
        int i = 1;
        while(i <= (tamHeap/2)){
            int filho = getMaiorFilho(array, i , tamHeap);
            if(array[i].getReleaseDate().before(array[filho].getReleaseDate())){
                swap(array, i, filho);
                i = filho;
            }
            else{
                i = tamHeap;
            }
        }
    }

    public static int getMaiorFilho(Game[] array, int i, int tamHeap){
        int filho;
        if(2*i == tamHeap || array[2*i].getReleaseDate().before(array[2*i+1].getReleaseDate())){
            filho = 2*i;
        }
        else{
            filho = 2*i + 1;
        }
        return filho;
    }
  


    public static void main(String[] args) throws Exception {

        String baseFile = "/tmp/games.csv";
        FileInputStream fstream = new FileInputStream(baseFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String line;

        Scanner sc = new Scanner(System.in);


        ArrayList<Game> games = new ArrayList<Game>();
        ArrayList<Game> gamesLista = new ArrayList<Game>();

        
        String[] entrada = new String[1000];

        int numEntrada = 0;

        while((line = br.readLine()) != null){
            Game game = new Game();

            game.read(line);
            games.add(game);
        }

        do{
            entrada[numEntrada] = sc.nextLine();
            numEntrada++;
        }while(!isFim(entrada[numEntrada - 1]));
        numEntrada--;

        int[] entrada_int = new int[numEntrada];
        Game[] array = new Game[numEntrada];

        for(int i = 0; i < numEntrada; i++){
            entrada_int[i] = Integer.parseInt(entrada[i]);
        }

        for(int i = 0; i < numEntrada; i++){
            int n = 0;
            boolean has = false;
            while(!has && n < games.size()){
                if(games.get(n).getAppId() == entrada_int[i]){
                    gamesLista.add(games.get(n));
                    array[i] = games.get(n);
                    has = true;
                }
                n++;
            }
        }

        ///
        Game[] tmp = new Game[gamesLista.size() + 1];
        for(int i = 0; i < gamesLista.size(); i++){
            tmp[i+ 1]= gamesLista.get(i);
        }
        array = tmp;

        for(int tamHeap = 2; tamHeap <= numEntrada; tamHeap++){
            contruir(array, tamHeap);
        }

        int tamHeap = numEntrada;
        while(tamHeap > 1){
            swap(array, 1, tamHeap--);
            reconstruir(array, tamHeap);
        }

        tmp = array;
        array = new Game[numEntrada];
        for(int i = 0; i < numEntrada; i++){
            array[i] = tmp[i + 1];
        }

        /////
        for(int i = 0; i < gamesLista.size(); i++){
            array[i].print();
        }

        sc.close();
        br.close();
        fstream.close();
    }


    private static void contruir(Game[] array, int tamHeap) {
    }
}
