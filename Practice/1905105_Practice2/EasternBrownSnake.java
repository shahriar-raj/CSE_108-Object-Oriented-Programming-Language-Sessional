public class EasternBrownSnake extends Reptile implements Venomous{
    EasternBrownSnake(String Name, int Age){
    super(Name, Age);
}
    @Override
    public String toString(){
        return (getName()+ " is a EasternBrownSnake, aged "+ getAge());
    }
    public boolean isLethalToAdultHumans(){
        return true;
    }
}
