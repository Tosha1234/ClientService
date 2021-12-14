package toha.shelepov.clientService.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import toha.shelepov.clientService.model.Order;
import toha.shelepov.clientService.model.OrderPoduct;
import toha.shelepov.clientService.repository.OrderProductRepository;

import java.util.List;
import java.util.Optional;

@Component
public class OrderProductDAO {

    @Autowired
    OrderProductRepository orderProductRepository;

    public OrderPoduct getOrderProduct(long oId, long bId) {
        OrderPoduct orderPoduct=orderProductRepository.findByOrderAndProduct(oId, bId);

        return orderPoduct;
    }

    public void saveOrderProduct(OrderPoduct orderPoduct) {
        orderProductRepository.save(orderPoduct);
    }

    public void deleteOrder(OrderPoduct orderPoduct) {
        orderProductRepository.delete(orderPoduct);
    }

    public List<OrderPoduct> getOrderProduct(long oId) {
        List<OrderPoduct> byId = orderProductRepository.findAllByOrder(oId);
        return byId;
    }
}
