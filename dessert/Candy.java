import java.util.*;

public class Candy extends DessertItem{

    public double price;
    public double weight;
    //String name;
    public Candy(String name,double weight,double price)
    {
        super(name);
        this.weight=weight;
        this.price=price;
    }

    public double getweight(){
        return weight;
    }

    public double getperprice(){
        return price;
    }
    //@Override
    public int getCost(){
        //double res=weight*price;
        return (int)Math.round(weight*price);
    }
}
