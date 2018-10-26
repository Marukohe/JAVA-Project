public class Cookie extends DessertItem{
    private int number;
    private double price;

    public Cookie(String name,int number,int price){
        super(name);
        this.number=number;
        this.price=price;
    }

    public int getnumber()
    {
        return number;
    }

    public int getprice(){
        return (int)price;
    }

    public int getCost(){
        return (int)Math.round(price*number/12);
    }
}
