public class League {
    private Match[] matches;
    private int matchCount;
    private int clubCount;
    private String name;
    private Club[] clubs;
    private  int i;
    // add your variables here, if required

    public League() {
        // assume a league can have at most 5 clubs, add code for initialization accordingly
        clubs = new Club[5];
        for(int i=0; i<5; i++){
            clubs[i] = new Club();
        }
        clubCount = 0;
        matchCount = 0;
    }

    public void printLeagueInfo(){
        System.out.println("League : " + name);
        printClubs();
    }

    public void printClubs(){
        System.out.println("Clubs:");
        // print the name of the clubs of this league, each one on a line
        for(int i=0; i<clubCount; i++){
            System.out.println(clubs[i].getName());
        }
    }

    public void scheduleMatches(){
        matchCount = (clubCount*(clubCount-1));
        matches = new Match[matchCount];
        int matchNo = 0;
        for (int i=0; i<clubCount; i++){
            for (int j=0; j<clubCount; j++){
                // check the constructor of the Match class and add your code here
                if(i!=j) {
                    matches[matchNo] = new Match(matchNo, clubs[i], clubs[j]);
                    matchNo ++;
                }
                // note that there will be two matches between club A and club B
                // in the first match, club A will play as the home team and in the second match, as the away team
            }
        }
    }

    public void simulateMatches(){
        for (int i=0; i<matchCount; i++){
            matches[i].play();
        }
    }

    public void showStandings(){
        // sort the clubs in descending order of points
        // note that, the sequence in which clubs were added to the league, should be unchanged
        // check the given sample output for clarification
        // (carefully observe the output of showStandings() followed by printLeagueInfo() method calls
        // you can use additional arrays if needed
        System.out.println("Sl. - Club - Points");
        // print the clubs in descending order of points
        Club[] r_clubs;
        r_clubs = new Club[clubCount];
        Club temp;
        for(i=0; i<clubCount; i++)
            r_clubs[i] = clubs[i];
        for(i=0; i<clubCount; i++){
            int max = i;
            for(int j=i+1; j<clubCount; j++){
                if(r_clubs[j].getPoints()>r_clubs[max].getPoints())
                    max=j;
            }
            temp = r_clubs[i];
            r_clubs[i] = r_clubs[max];
            r_clubs[max] = temp;
        }
        for(i=0; i<clubCount; i++){
            System.out.println((i+1)+". "+r_clubs[i].getName()+" "+r_clubs[i].getPoints());
        }
    }

    // add your methods here, if required

    public void setName(String name) {
        this.name = name;
    }

    public void addClub(Club a){
        clubs[clubCount] = a;
        clubCount++;
    }

    public void printMatches(){
        System.out.println("Matches:");
        for(i=0; i<matchCount; i++)
            matches[i].showResult();
    }

    public void removeClub(Club a){
        for(i=0; i<clubCount; i++){
            //System.out.println("***********"+a.getId()+"   "+clubs[i].getId());
            //System.out.println("***********"+a.getName()+"   "+clubs[i].getName());
            if(a.getId()==clubs[i].getId()){
                for(int j=i; j<clubCount-1; j++)
                    clubs[j] = clubs[j+1];
                clubCount--;
                break;
            }
        }
        for(i=0; i<clubCount; i++){
            clubs[i].setPoints(0);
        }
    }
}

