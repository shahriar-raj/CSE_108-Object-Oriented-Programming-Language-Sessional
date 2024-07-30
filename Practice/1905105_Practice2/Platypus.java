public class Platypus extends Mammal implements Venomous{
    Platypus(String Name, int Age){
        super(Name, Age);
    }
    @Override
    public String toString(){
        return (getName()+ " is a Platypus, aged "+ getAge());
    }
    public boolean isLethalToAdultHumans(){
        return false;
    }
}
