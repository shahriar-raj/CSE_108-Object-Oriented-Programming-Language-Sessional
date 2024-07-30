public class FruitBat extends Mammal {
    FruitBat(String Name, int Age){
        super(Name, Age);
    }
    @Override
    public String toString(){
        return (getName()+ " is a FruitBat, aged "+ getAge());
    }
}
