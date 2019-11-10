package BurgerKing;

public class Client {
    private String name;
    private Double cash;
    private CreditCard card;
    private Order order;

    public Client(String name, Double cash) {
        this.name = name;
        this.cash = cash;
        this.card = null;
        this.order = new Order();
    }

    public Client(String name, Double cash, CreditCard card) {
        this.name = name;
        this.cash = cash;
        this.card = card;
        this.order = new Order();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public CreditCard getCard() {
        return card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void makeOrder(Food food, int action){
//        to be added...
    }

    public void discardOrder(Food food){
//        to be added...
    }

    public void payForOrder(){
//        to be added...
    }


    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", cash=" + cash +
                ", card=" + card +
                ", order=" + order +
                '}';
    }
}
