
public class Sundae extends IceCream{
    private String topping;
    private int price2;

    public Sundae(String name,int price,String topping,int price2){
        super(name,price);
        this.topping=topping;
        this.price2=price2;
    }

    public int getCost(){
        return cost+price2;
    }

    public String gettopping() {
        return topping;
    }
}
