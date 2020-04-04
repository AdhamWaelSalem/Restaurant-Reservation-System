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


public class LoadXML {

    XMLRestaurant Restaurant = new XMLRestaurant();
    File source = new File("main.xml");
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
                user = new Client(xmluser.getUsername(),xmluser.getPassword(),xmluser.getName().split(" ",2)[0],xmluser.getName().split(" ",2)[1]);
            }else if (xmluser.getRole().equals("Manager")){
                user = new Manager(xmluser.getUsername(),xmluser.getPassword(),xmluser.getName().split(" ",2)[0],xmluser.getName().split(" ",2)[1]);
            }else if (xmluser.getRole().equals("Waiter")){
                user = new Waiter(xmluser.getUsername(),xmluser.getPassword(),xmluser.getName().split(" ",2)[0],xmluser.getName().split(" ",2)[1]);
            }else if (xmluser.getRole().equals("Cooker")){
                user = new Chef(xmluser.getUsername(),xmluser.getPassword(),xmluser.getName().split(" ",2)[0],xmluser.getName().split(" ",2)[1]);
            }else { user = null; }
            Users.add(user);
        }
        return Users;
    }
    public List<Dish> LoadDishes() {

        List<Dish> Dishes = new ArrayList<>();

        for (XMLDish xmldish : Restaurant.getXMLDishes().getXMLDishes()) {
            Dish dish = new Dish();
            dish.setName(xmldish.getName());
            dish.setPrice(xmldish.getPrice());

            if (xmldish.getType().equals("main_course"))
                dish.setType(Dish.Type.MainCourse);
            else if (xmldish.getType().equals("appetizer"))
                dish.setType(Dish.Type.Appetizer);
            else if (xmldish.getType().equals("desert"))
                dish.setType(Dish.Type.Dessert);

            Dishes.add(dish);
        }

        return Dishes;
    }

    public List<Table> LoadTables() {
        List<Table> Tables = new ArrayList<>();

        for (XMLTable xmltable : Restaurant.getXMLTables().getXMLTables()) {
            Table table = new Table();
            table.setNumber(xmltable.getNumber());
            table.setNumberOfSeats(xmltable.getNumberOfSeats());
            table.setSmoking(xmltable.getSmoking());
            table.setLocation(Table.randomLocation());
            Tables.add(table);
        }

        return Tables;
    }
}
