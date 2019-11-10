package BurgerKing;

public class Food implements Cookable {
    private String name;
    private FoodType type;
    private Double price;
    private String size;

    public Food(String name, FoodType type, Double price, String size) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", size='" + size + '\'' +
                '}';
    }

    @Override
    public void cooking() {
        int mealtype = this.type.ordinal();
        switch (mealtype){
            case 0:{
                System.out.println(this.name + " is cooking...Done!");
                break;
            }
            case 1:{
                System.out.println("Pouring "+ this.name + "...Done!");
                break;
            }
            case 2:{
                System.out.println(this.name + "is brewing...Done!");
                break;
            }
            case 3:{
                System.out.println(this.name + "is frying...Done!");
                break;
            }
            default:
                System.out.println("Unknown meal is cooking...");
        }

    }
}
