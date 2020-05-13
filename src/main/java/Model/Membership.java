/**
 @author Mohammed Hadra (cph-mh879@cphbusiness.dk)
 @author Andreas Bergmann (cph-ab435@cphbusiness.dk)
 **/
package Model;

public class Membership {
    private int id;
    private String name;
    private double price;

    public Membership(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
