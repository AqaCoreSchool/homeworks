package recep;

import hotel.Hotel;
import human.Client;

import java.util.ArrayList;
import java.util.List;

public class Reception{
    private List<Client> listAdministrator =new ArrayList<>();
    private List<Client> listClient =new ArrayList<>();


    public List<Client> getListAdministrator() {
        return listAdministrator;
    }

    public void setListAdministrator(List<Client> listAdministator) {
        this.listAdministrator = listAdministator;
    }

    public List<Client> getListClient() {
        return listClient;
    }

    public void setListClient(List<Client> listClient) {
        this.listClient = listClient;
    }
}
