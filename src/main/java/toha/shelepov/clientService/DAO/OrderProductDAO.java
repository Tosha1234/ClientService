package toha.shelepov.clientService.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import toha.shelepov.clientService.model.OrderProduct;
import toha.shelepov.clientService.repository.OrderProductRepository;

import java.util.List;

@Component
public class OrderProductDAO {

    @Autowired
    OrderProductRepository orderProductRepository;

    public OrderProduct getOrderProduct(long oId, long bId) {
        return orderProductRepository.findByOrderAndProduct(oId, bId);
    }

    public void saveOrderProduct(OrderProduct orderPoduct) {
        orderProductRepository.save(orderPoduct);
    }

    public void deleteOrder(OrderProduct orderPoduct) {
        orderProductRepository.delete(orderPoduct);
    }

    public List<OrderProduct> getOrderProduct(long oId) {
        return orderProductRepository.findAllByOrder(oId);
    }
}
