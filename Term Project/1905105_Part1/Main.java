import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static final String INPUT = "players.txt";
    public static final String OUTPUT = "players.txt";

    public static List <Player> readFile() throws Exception{
        List<Player> PlayerList = new ArrayList();
        BufferedReader br = new BufferedReader(new FileReader(INPUT));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] s = line.split(",");
            PlayerList.add(new Player(s[0],s[1],Integer.parseInt(s[2]),Double.parseDouble(s[3]),s[4],s[5],Integer.parseInt(s[6]),Double.parseDouble(s[7])));
        }
        br.close();
       /* for (Player p : PlayerList){
            p.getPlayerInfo();
        }*/
        return  PlayerList;
    }

    public static void writeToFile(List<Player> PlayerList) throws Exception{
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT));
        for(Player p: PlayerList){
            bw.write(p.getName()+","+p.getCountry()+","+p.getAge()+","+p.getHeight()+","+p.getClub()+","+p.getPosition()+","+p.getNumber()+","+p.getSalary());
            bw.write("\n");
        }
        bw.close();
    }

    public static void main(String[] args) throws Exception {
       // List <Player> PlayerList = readFile();
        int c = 0;
        boolean e=true;
        while(e) {
            List <Player> PlayerList = readFile();
            switch (c){
                case 0: //Main Menu (c=0)
                    System.out.println("Main Menu:");
                    System.out.println("(1) Search Players");
                    System.out.println("(2) Search Clubs");
                    System.out.println("(3) Add Player");
                    System.out.println("(4) Exit System");
                    System.out.printf("Enter Option: ");
                    Scanner scn = new Scanner(System.in);
                    c = scn.nextInt();
                    if(c==0)
                        System.out.println("Invalid input!! Choose option from 1-4");
                    break;
                case 1: //Search Player Menu (c=1)
                    int c1;
                    System.out.println("Player Searching Options:");
                    System.out.println("(1) By Player Name");
                    System.out.println("(2) By Club and Country");
                    System.out.println("(3) By Position");
                    System.out.println("(4) By Salary Range");
                    System.out.println("(5) Country-wise Player Count");
                    System.out.println("(6) Back to Main Menu");
                    System.out.printf("Enter Option: ");
                    Scanner scn1 = new Scanner(System.in);
                    c1 = scn1.nextInt();
                    switch (c1){
                        case 1: // Search Players by name (c=1 & c1=1)
                            int pf = -1;
                            System.out.printf("Enter Player Name: ");
                            Scanner scn2 = new Scanner(System.in);
                            String searchName = scn2.nextLine();
                            searchName = searchName.trim();
                            //System.out.println(searchName);
                            for(Player p: PlayerList){
                                if(p.getName().equalsIgnoreCase(searchName)){
                                    p.getPlayerInfo();
                                    pf = 1;
                                    break;
                                }
                            }
                            if(pf==-1){
                                System.out.println("No such player with this name");
                            }
                            break;
                        case 2: // Search Players by Country & Club (c=1 & c1=2)
                            int cf = -1;
                            System.out.printf("Enter Country Name: ");
                            Scanner scn3 = new Scanner(System.in);
                            String searchCountry = scn3.nextLine();
                            System.out.printf("Enter Club Name: ");
                            Scanner scn4 = new Scanner(System.in);
                            String searchClub = scn4.nextLine();
                            searchClub = searchClub.trim();
                            searchCountry = searchCountry.trim();
                            //System.out.println(searchName);
                            String any = "Any";
                            if(searchClub.equalsIgnoreCase(any)){
                                for (Player p : PlayerList) {
                                    if (p.getCountry().equalsIgnoreCase(searchCountry)) {
                                        p.getPlayerInfo();
                                        cf = 1;
                                    }
                                }
                            }
                            else{
                                for (Player p : PlayerList) {
                                    if (p.getCountry().equalsIgnoreCase(searchCountry)&&p.getClub().equalsIgnoreCase(searchClub)) {
                                        p.getPlayerInfo();
                                        cf = 1;
                                    }
                                }
                            }
                            if(cf==-1){
                                System.out.println("No such player with this country and club");
                            }
                            break;
                        case 3: // Search Players by Position (c=1 & c1=3)
                            int pos_f = -1;
                            System.out.printf("Enter Position Name: ");
                            Scanner scn5 = new Scanner(System.in);
                            String searchPosition = scn5.nextLine();
                            searchPosition = searchPosition.trim();
                            //System.out.println(searchName);
                            for(Player p: PlayerList){
                                if(p.getPosition().equalsIgnoreCase(searchPosition)){
                                    p.getPlayerInfo();
                                    pos_f = 1;
                                }
                            }
                            if(pos_f==-1){
                                System.out.println("No such player with this position");
                            }
                            break;
                        case 4: // Search Players by Salary range (c=1 & c1=4)
                            int s_f = -1;
                            System.out.printf("Enter lower limit of salary range: ");
                            Scanner scn6 = new Scanner(System.in);
                            double low_range = scn6.nextDouble();
                            System.out.printf("Enter higher limit of salary range: ");
                            Scanner scn7 = new Scanner(System.in);
                            double high_range = scn7.nextDouble();
                            //System.out.println(searchName);
                            for(Player p: PlayerList){
                                if( p.getSalary()>=low_range && p.getSalary()<=high_range){
                                    p.getPlayerInfo();
                                    s_f = 1;
                                }
                            }
                            if(s_f==-1){
                                System.out.println("No such player with this weekly salary range");
                            }
                            break;
                        case 5: // Country-wise player count ,option of search players (c=1 & c1=5)
                            List<String> countries = new ArrayList();
                            //String[] countries = new String[40];
                            int countries_count = 0;
                            System.out.println("Country-wise Count of Players: ");
                            countries.add(PlayerList.get(0).getCountry());
                            //countries[0] = PlayerList.get(0).getCountry();
                            //System.out.println(countries[countries_count]);
                            countries_count++;
                            for(Player p: PlayerList){
                                int match = -1;
                               // System.out.println(p.getCountry());
                                for(int i=0; i<countries_count; i++){
                                   // System.out.println("Match Found");
                                   // System.out.println(countries[countries_count]+"  "+p.getCountry()+" "+countries_count);
                                    if(countries.get(i).equalsIgnoreCase(p.getCountry())){
                                        match = 1;
                                        //System.out.println("Match Found");
                                    }
                                }
                                if(match == -1){
                                    countries.add(p.getCountry());
                                    countries_count++;
                                }
                            }
                            //System.out.println(countries_count);
                            for(int i=0; i<countries_count; i++){
                                int player_count = 0;
                                for(Player p: PlayerList){
                                    if(p.getCountry().equalsIgnoreCase(countries.get(i)))
                                        player_count++;
                                }
                                System.out.println(countries.get(i)+": "+player_count);
                            }
                            break;
                        case 6: // Back to main menu ,option of search players (c=1 & c1=6)
                            c=0;
                            break;
                        default:
                            System.out.println("Invalid input!! Choose option from 1-6");
                            break;
                    }
                    break;
                case 2:
                    int c2;
                    System.out.println("Club Searching Options: ");
                    System.out.println("(1) Player(s) with the maximum salary of a club");
                    System.out.println("(2) Player(s) with the maximum age of a club");
                    System.out.println("(3) Player(s) with the maximum height of a club");
                    System.out.println("(4) Total yearly salary of a club");
                    System.out.println("(5) Back to Main Menu");
                    System.out.printf("Enter Option: ");
                    Scanner scn8 = new Scanner(System.in);
                    c2 = scn8.nextInt();
                    switch (c2){
                        case 1:
                            int cl_f=-1;
                            double[] p_sal = new double[10];
                            int p_count=0, max_sal=0;
                            System.out.printf("Enter Club Name: ");
                            Scanner scn9 = new Scanner(System.in);
                            String searchClub = scn9.nextLine();
                            searchClub = searchClub.trim();
                            for(Player p: PlayerList){
                                if(p.getClub().equalsIgnoreCase(searchClub)) {
                                    cl_f = 1;
                                    p_sal[p_count] = p.getSalary();
                                    p_count++;
                                }
                            }
                            if(cl_f==-1)
                                System.out.println("No such club with this name");
                            else {
                                for (int i = 0; i < p_count; i++) {
                                    if (p_sal[i] > p_sal[max_sal])
                                        max_sal = i;
                                }
                                for (Player p : PlayerList) {
                                    if ((p.getSalary() == p_sal[max_sal]) && p.getClub().equalsIgnoreCase(searchClub))
                                        p.getPlayerInfo();
                                }
                            }
                            break;
                        case 2:
                            int cl_a_f=-1;
                            int[] p_age= new int[10];
                            int p_age_count=0, max_age=0;
                            System.out.printf("Enter Club Name: ");
                            Scanner scn10 = new Scanner(System.in);
                            searchClub = scn10.nextLine();
                            searchClub = searchClub.trim();
                            for(Player p: PlayerList){
                                if(p.getClub().equalsIgnoreCase(searchClub)) {
                                    cl_a_f = 1;
                                    p_age[p_age_count] = p.getAge();
                                    p_age_count++;
                                }
                            }
                            if(cl_a_f==-1)
                                System.out.println("No such club with this name");
                            else {
                                for (int i = 0; i < p_age_count; i++) {
                                    if (p_age[i] > p_age[max_age])
                                        max_age = i;
                                }
                                for (Player p : PlayerList) {
                                    if ((p.getAge() == p_age[max_age]) && p.getClub().equalsIgnoreCase(searchClub))
                                        p.getPlayerInfo();
                                }
                            }
                            break;
                        case 3:
                            int cl_h_f=-1;
                            double[] p_height= new double[10];
                            int p_h_count=0, max_height=0;
                            System.out.printf("Enter Club Name: ");
                            Scanner scn11 = new Scanner(System.in);
                            searchClub = scn11.nextLine();
                            searchClub = searchClub.trim();
                            for(Player p: PlayerList){
                                if(p.getClub().equalsIgnoreCase(searchClub)) {
                                    cl_h_f = 1;
                                    p_height[p_h_count] = p.getHeight();
                                    p_h_count++;
                                }
                            }
                            if(cl_h_f==-1)
                                System.out.println("No such club with this name");
                            else {
                                for (int i = 0; i < p_h_count; i++) {
                                    if (p_height[i] > p_height[max_height])
                                        max_height = i;
                                }
                                for (Player p : PlayerList) {
                                    if ((p.getHeight() == p_height[max_height]) && p.getClub().equalsIgnoreCase(searchClub))
                                        p.getPlayerInfo();
                                }
                            }
                            break;
                        case  4:
                            int cl_y_s = -1;
                            double weekly_sal=0;
                            System.out.printf("Enter Club Name: ");
                            Scanner scn12 = new Scanner(System.in);
                            searchClub = scn12.nextLine();
                            searchClub = searchClub.trim();
                            for(Player p: PlayerList) {
                                if (p.getClub().equalsIgnoreCase(searchClub))
                                    cl_y_s = 1;
                            }
                            if(cl_y_s == -1)
                                System.out.println("No such club with this name");
                            else{
                                for (Player p: PlayerList) {
                                    if (p.getClub().equalsIgnoreCase(searchClub))
                                        weekly_sal += p.getSalary();
                                }
                                System.out.printf("Total yearly salary of "+searchClub+": ");
                                System.out.printf("%10.2f\n",(weekly_sal*52));
                            }
                            break;
                        case 5:
                            c=0;
                            break;
                        default:
                            System.out.println("Invalid input!! Choose option from 1-5");
                            break;
                    }
                    break;
                case 3:
                    String new_name = new String();
                    boolean v_p= true;
                    while(v_p) {
                        System.out.printf("Enter the name of the Player: ");
                        Scanner scn12 = new Scanner(System.in);
                        new_name = scn12.nextLine();
                        int p_f=-1;
                        for (Player p : PlayerList) {
                            if (new_name.equalsIgnoreCase(p.getName())) {
                                p_f = 1;
                                break;
                            }
                        }
                        if (p_f == 1) {
                            System.out.println("Player with this name already exists");
                            System.out.println("Do you want to enter another Player name?");
                            System.out.println("(1) Yes (2) No (will take you to the main menu)");
                            System.out.printf("Enter Option: ");
                            Scanner scn13 = new Scanner(System.in);
                            int check = scn13.nextInt();
                            if (check == 2) {
                                c = 0;
                                break;
                            }
                            else if (check != 1) {
                                System.out.println("Invalid Input!! Choose between 1 & 2");
                            }
                        }
                        else
                            v_p = false;
                    }
                    if(v_p)
                        break;

                    /*System.out.printf("Enter the name of the Player: ");
                    Scanner scn12 = new Scanner(System.in);
                    String new_name = scn12.nextLine();
                    int p_f=-1;
                    for(Player p:PlayerList){
                        if(p.getName().equalsIgnoreCase(new_name)){
                            p_f = 1;
                            break;
                        }
                    }
                    if(p_f==1){
                        System.out.println("Player with this name already exists");
                        c=0;
                        break;
                    }*/

                    System.out.printf("Enter the name of the Country: ");
                    Scanner scn16 = new Scanner(System.in);
                    String new_country = scn16.nextLine();
                    System.out.printf("Enter the age of the Player: ");
                    Scanner scn17 = new Scanner(System.in);
                    int new_age = scn17.nextInt();
                    System.out.printf("Enter the height of the Player: ");
                    Scanner scn20 = new Scanner(System.in);
                    double new_height = scn20.nextDouble();
                    String new_club = new String();
                    boolean v_c = true;
                    while(v_c) {
                        System.out.printf("Enter the name of the Club: ");
                        Scanner scn14 = new Scanner(System.in);
                        new_club = scn14.nextLine();
                        int new_count = 0;
                        for (Player p : PlayerList) {
                            if (new_club.equalsIgnoreCase(p.getClub()))
                                new_count++;
                        }
                        if (new_count == 7) {
                            System.out.println("Maximum Capacity of " + new_club + " reached!!");
                            System.out.println("Do you want to enter another Club name?");
                            System.out.println("(1) Yes (2) No (will take you to the main menu)");
                            System.out.printf("Enter Option: ");
                            Scanner scn13 = new Scanner(System.in);
                            int check = scn13.nextInt();
                            if (check == 2) {
                                c = 0;
                                break;
                            }
                            else if (check != 1) {
                                System.out.println("Invalid Input!! Choose between 1 & 2");
                            }
                        }
                        else
                            v_c = false;
                    }
                    if(v_c)
                        break;
                    System.out.printf("Enter the position of the Player: ");
                    Scanner scn15 = new Scanner(System.in);
                    String new_position = scn15.nextLine();
                    boolean v_n = true;
                    int new_number = 0;
                    while(v_n) {
                        System.out.printf("Enter the number of the Player: ");
                        Scanner scn18 = new Scanner(System.in);
                        new_number = scn18.nextInt();
                        int n_f = -1;
                        for (Player p : PlayerList) {
                            if ((new_number==p.getNumber())&&(new_club.equalsIgnoreCase(p.getClub())))
                                n_f = 1;
                        }
                        if (n_f == 1) {
                            System.out.println("Number " + new_number + " of " + new_club + " exists");
                            System.out.println("Do you want to enter another Player number?");
                            System.out.println("(1) Yes (2) No (will take you to the main menu)");
                            System.out.printf("Enter Option: ");
                            Scanner scn13 = new Scanner(System.in);
                            int check = scn13.nextInt();
                            if (check == 2) {
                                c = 0;
                                break;
                            }
                            else if (check != 1) {
                                System.out.println("Invalid Input!! Choose between 1 & 2");
                            }
                        }
                        else
                            v_n = false;
                    }
                    if(v_n)
                        break;

                    /*System.out.printf("Enter the number of the Player: ");
                    Scanner scn18 = new Scanner(System.in);
                    int new_number = scn18.nextInt();*/
                    System.out.printf("Enter the salary of the Player: ");
                    Scanner scn19 = new Scanner(System.in);
                    double new_salary = scn19.nextDouble();
                    Player p = new Player();
                    p.setName(new_name);
                    p.setCountry(new_country);
                    p.setAge(new_age);
                    p.setHeight(new_height);
                    p.setClub(new_club);
                    p.setPosition(new_position);
                    p.setNumber(new_number);
                    p.setSalary(new_salary);
                    PlayerList.add(p);
                    System.out.println("Player added!");
                    c=0;
                    break;
                case 4:
                    e = false;
                    break;
                default:
                    System.out.println("Invalid input!! Choose option from 1-4");
                    c=0;
                    break;
            }
            writeToFile(PlayerList);
        }
    }
}
