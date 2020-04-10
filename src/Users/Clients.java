package Users;

import Main.Restaurant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "clients")
@XmlAccessorType(XmlAccessType.FIELD)
public class Clients {




    //Singleton Class
    private static Clients Clients = new Clients();
    public static Clients getClients() {
        return Clients;
    }
    public static void setClients(Users.Clients clients) {
        Clients = clients;
    }

    @XmlElement(name = "client")
    public List<Client> clients = new ArrayList<>();

    public List<Client> getListClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void Merge(){
        for (User user: Restaurant.getRestaurant().getUsers()) {
            if (user instanceof Client){
                for (Client client: Clients.getListClients()) {
                    if (user.getUsername().equals(client.getUsername())){
                        int i = Restaurant.getRestaurant().getUsers().indexOf(user);
                        Restaurant.getRestaurant().getUsers().set(i,client);
                    }
                }
            }
        }
    }

    public void Save(){
        clients.clear();
        for (User user: Restaurant.getRestaurant().getUsers()) {
            if (user instanceof Client){
                clients.add(((Client) user));
            }
        }
    }


}
