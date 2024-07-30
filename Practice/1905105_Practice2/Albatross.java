public class Albatross extends Bird{
    Albatross (String Name, int Age){
        super(Name, Age);
    }
    @Override
    public String toString(){
        return (getName()+ " is a Albatross, aged "+ getAge());
    }
}
