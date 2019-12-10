package desingpatterns.facadeandbuilder;


import java.time.LocalDate;


public class ClientInfo {

    private String name;
    private String surname;
    private String passport;
    private String cardNumber;
    private String address;
    private LocalDate shippingDate;

    private ClientInfo() {

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassport() {
        return passport;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public static class Builder {

        private ClientInfo clientInfo;

        public Builder() {
            clientInfo = new ClientInfo();
        }

        public Builder setName(String name) {
            clientInfo.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            clientInfo.surname = surname;
            return this;
        }

        public Builder setPassport(String passport) {
            clientInfo.passport = passport;
            return this;
        }

        public Builder setCardNumber(String cardNumber) {
            clientInfo.cardNumber = cardNumber;
            return this;
        }

        public Builder setAddress(String address) {
            clientInfo.address = address;
            return this;
        }

        public Builder setShippingDate(LocalDate date) {
            clientInfo.shippingDate = date;
            return this;
        }

        public ClientInfo build() {
            return clientInfo;
        }
    }
}
