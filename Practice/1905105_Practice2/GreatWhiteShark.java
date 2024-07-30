public class GreatWhiteShark extends Fish{
    GreatWhiteShark(String Name, int Age){
        super(Name, Age);
    }
    @Override
    public String toString(){
        return (getName()+ " is a GreatWhiteShark, aged "+ getAge());
    }
}
