public class Player {
    private String name, country, position, club;
    private int age, number;
    private double salary, height;

    public Player(){

    }

    public Player(String n, String co, int a, double h, String c, String p, int nu, double s){
        setName(n);
        setCountry(co);
        setAge(a);
        setHeight(h);
        setClub(c);
        setPosition(p);
        setNumber(nu);
        setSalary(s);
    }

    public void getPlayerInfo(){
        System.out.println(getName()+","+getCountry()+","+getAge()+","+getHeight()+","+getClub()+","+getPosition()+","+getNumber()+","+getSalary());
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry(){
        return country;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getClub(){
        return club;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}
