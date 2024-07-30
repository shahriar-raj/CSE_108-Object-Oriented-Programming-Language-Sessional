public class RedBackSpider extends Arachnid implements Venomous{
    RedBackSpider(String Name, int Age){
        super(Name, Age);
    }
    @Override
    public String toString(){
        return (getName()+ " is a RedBackSpider, aged "+ getAge());
    }
    public boolean isLethalToAdultHumans(){
        return false;
    }
}
