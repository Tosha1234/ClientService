package toha.shelepov.clientService.DAO;

import org.springframework.stereotype.Component;
import toha.shelepov.clientService.model.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class OrderDAO {

    private List<Order> orderList;

    {
        orderList=new ArrayList<>();

        orderList.add(new Order(1, 12, 14, new Date(), "qwe"));
        orderList.add(new Order(2, 12, 234, new Date(), "qwe"));
        orderList.add(new Order(3, 12, 346, new Date(), "qwe"));
        orderList.add(new Order(4, 12, 12435, new Date(), "qwe"));
    }

    public Object getAll() {
        return orderList;
    }
}
