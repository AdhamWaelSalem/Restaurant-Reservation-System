package XMLPack;

import OrdersPack.Dish;
import OrdersPack.OrderItem;
import ReservationPack.ReserveItem;
import ReservationPack.Table;
import UsersPack.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public abstract class LoadXML {

    XMLRestaurant Restaurant = new XMLRestaurant();
    File source = new File("source.xml");
    JAXBContext jaxbContext;
    {
        try {
            jaxbContext = JAXBContext.newInstance(XMLRestaurant.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Restaurant = (XMLRestaurant) jaxbUnmarshaller.unmarshal(source);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public List<User> LoadUsers(){
        List<User> Users = new ArrayList<>();
        for (XMLUser xmluser: Restaurant.getXMLUsers().getXMLUsers() ) {
            User user;
            if (xmluser.getRole().equals("Client")){
                user = new Client(xmluser.getName(),xmluser.getUsername(),xmluser.getPassword());
            }else if (xmluser.getRole().equals("Manager")){
                user = new Manager(xmluser.getName(),xmluser.getUsername(),xmluser.getPassword());
            }else if (xmluser.getRole().equals("Waiter")){
                user = new Waiter(xmluser.getName(),xmluser.getUsername(),xmluser.getPassword());
            }else if (xmluser.getRole().equals("Cooker")){
                user = new Chef(xmluser.getName(),xmluser.getUsername(),xmluser.getPassword());
            }else { user = null; }
            Users.add(user);
        }return Users;
    }
    public List<Dish> LoadDishes() {
        List<Dish> Dishes = new ArrayList<>();
        for (XMLDish xmldish : Restaurant.getXMLDishes().getXMLDishes()) {
            Dish dish = new Dish(xmldish.getName(),xmldish.getPrice());
            if (xmldish.getType().equals("main_course"))
                dish.setType(Dish.Type.MainCourse);
            else if (xmldish.getType().equals("appetizer"))
                dish.setType(Dish.Type.Appetizer);
            else if (xmldish.getType().equals("desert"))
                dish.setType(Dish.Type.Dessert);
            Dishes.add(dish);
        }return Dishes;
    }
    public List<Table> LoadTables() {
        List<Table> Tables = new ArrayList<>();
        for (XMLTable xmltable : Restaurant.getXMLTables().getXMLTables()) {
            Tables.add(new Table(xmltable.getNumber(),xmltable.getNumberOfSeats(),xmltable.getSmoking()));
        }return Tables;
    }
}
