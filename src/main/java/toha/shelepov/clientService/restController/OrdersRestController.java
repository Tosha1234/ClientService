package toha.shelepov.clientService.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import toha.shelepov.clientService.DAO.OrderDAO;
import toha.shelepov.clientService.model.Order;

import java.util.List;

@RestController
@RequestMapping("/orders/list")
public class OrdersRestController {

    @Autowired
    OrderDAO orderDAO;

    @GetMapping
    public List<Order> ordersReturlList(){
        List<Order> all = orderDAO.getAll();
        return all;
    }
}
