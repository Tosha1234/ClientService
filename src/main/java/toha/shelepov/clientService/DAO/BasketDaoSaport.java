package toha.shelepov.clientService.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import toha.shelepov.clientService.model.Order;
import toha.shelepov.clientService.model.Product;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class BasketDaoSaport {

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    BasketDAO basketDAO;

    public BasketDaoSaport() {
    }

    private Order order=new Order();
    private List<Product> productList=new ArrayList<>();


    public void addProduct(Product product) {
        productList.add(product);
    }

    public void save() {
        orderDAO.createOrder(order);
        productList.forEach(product -> basketDAO.addProdForBasket(order.getId(), product.getId()));
    }
}
