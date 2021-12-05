package toha.shelepov.clientService.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import toha.shelepov.clientService.model.Order;
import toha.shelepov.clientService.repository.OrderRepository;
import java.util.List;

@Component
public class OrderDAO {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getOrderId(long id) {
        return orderRepository.findById(id).get();
    }

    public void deleteOrder(long id) {
        orderRepository.delete(this.getOrderId(id));
    }

    public void updateOrder(long id, Order order) {
        Order order1=this.getOrderId(id);
        order1.setStatus(order.getStatus());
        orderRepository.save(order1);
    }

    public void createOrder(Order order) {
        orderRepository.save(order);
    }
}
