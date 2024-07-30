public class Mammal extends Animal{
    Mammal(String Name, int Age){
        super(Name, Age);
    }
    public void printBloodType(){
        System.out.printf(", Warm-Blooded!");
    }
}
