public class Club {
    private String name;
    private int id;
    private int points;

    public Club(){
        points = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void increase_Points(int a){
        points+=a;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints(){
        return points;
    }
}
