public class Club {
    private int id;
    private String name;
    private Player[] players;
    private int playerCount = 0;
    // add your code here

	// you are not allowed to write any other constructor
    public Club() {
        this.players = new Player[11];
    }

	public double getSalary() {
        double total = 0;
        for (int i = 0; i < playerCount; i++) {
            total += players[i].getSalary();
        }
        return total;
    }
	
	// add your code here
    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addPlayer(Player P){
        players[playerCount] = P;
        playerCount++;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public Player getMaxSalaryPlayer(){
        int i=0,max=0;
        for(i=0;i<playerCount-1;i++){
            if(players[i].getSalary()<players[i+1].getSalary())
                max = i+1;
        }
        return players[max];
    }
}