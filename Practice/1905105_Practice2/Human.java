public class Human extends Mammal{
    Human(String Name, int Age){
        super(Name, Age);
    }
    @Override
    public String toString(){
        return (getName()+ " is a Human, aged "+ getAge());
    }
}
