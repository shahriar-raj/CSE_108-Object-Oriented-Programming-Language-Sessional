public class Dog extends Mammal{
    Dog(String Name, int Age){
        super(Name, Age);
    }
    @Override
    public String toString(){
        return (getName()+ " is a Dog, aged "+ getAge());
    }
}
