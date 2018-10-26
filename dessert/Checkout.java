/*
 *用vector没能成功，不会调用类中的函数；
 *一开始if Icecream写在了Sundae前面
 * 发现在遇到Sundae时会之间进入Icecream的if语句
 */

import java.util.*;

public class Checkout {

    public int numOfItems;
    public DessertItem[] dessert;
    public int res=0;
    public int WIDTH = 32;

    public Checkout(){
        dessert=new DessertItem[1000];
        numOfItems=0;
    }

    public void enterItem(DessertItem item) {
        this.dessert[numOfItems]=item;
        numOfItems++;
        res+=item.getCost();
    }

    public int numberOfItems(){
        return numOfItems;
    }

    public int totalCost() {
        return res;
    }

    public int totalTax(){
        return (int)Math.round(res* (DessertShoppe.TAX_RATE/100));
    }

    public void clear(){
        for(int i = 0; i < numOfItems; i++)
            this.dessert[i] = null;
        numOfItems = 0;
    }

    @Override
    public String toString() {
        String s="";
        s="      "+DessertShoppe.STORE_NAME+"\n"
                +"      --------------------"+"\n"
                +"\n";

        for(int i=0;i<numOfItems;i++) {
            String l = dessert[i].getName();
            String p=DessertShoppe.cents2dollarsAndCents(dessert[i].getCost());
            if(p.length()>DessertShoppe.COST_WIDTH) {
                p=p.substring(0,DessertShoppe.COST_WIDTH-1);
            }

            if(dessert[i] instanceof Sundae){
                s=s+((Sundae)dessert[i]).gettopping()+" Sundae with"+"\n";
                while(l.length()<WIDTH-p.length())
                    l+=" ";
                s=s+l+p+"\n";
            }
            else if(dessert[i] instanceof IceCream){
                while(l.length()<WIDTH-p.length())
                    l+=" ";
                s=s+l+p+"\n";
            }
            else if(dessert[i] instanceof Candy){
                s+=((Candy) dessert[i]).getweight() + " lbs @ " + DessertShoppe.cents2dollarsAndCents((int)((Candy) dessert[i]).getperprice()) + " /lb.\n";
                while(l.length()<WIDTH-p.length())
                    l+=" ";
                s=s+l+p+"\n";
            }
            else{
                s+=((Cookie)dessert[i]).getnumber()+" @ "+DessertShoppe.cents2dollarsAndCents(((Cookie) dessert[i]).getprice())+" /dz.\n";
                while(l.length()<WIDTH-p.length())
                    l+=" ";
                s=s+l+p+"\n";
            }
        }

        s+="\n";
        String p = DessertShoppe.cents2dollarsAndCents(totalTax());
        String l="Tax";
        while(l.length()<WIDTH-p.length())
            l+=" ";
        s=s+l+p;

        s+="\n";
        p = DessertShoppe.cents2dollarsAndCents(totalCost()+totalTax());
        l="Total Cost";
        while(l.length()<WIDTH-p.length())
            l+=" ";
        s=s+l+p;
        s+="\n";
        return s;
    }
}
