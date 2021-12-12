package toha.shelepov.clientService.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import toha.shelepov.clientService.model.Order;
import toha.shelepov.clientService.repository.OrderRepository;
import java.util.List;
import java.util.Optional;

@Component
public class OrderDAO {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getOrderId(long id) {
        Optional<Order> byId = orderRepository.findById(id);
        Order order = byId.orElse(new Order());
        return order;
    }

    public void deleteOrder(long id) {
        Order orderId = this.getOrderId(id);
        orderRepository.delete(orderId);
    }

    public void updateOrder(long id, Order order) {
        Order order1=this.getOrderId(id);
        order1.setStatus(order.getStatus());
        orderRepository.save(order1);
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
