package toha.shelepov.clientService.business;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import toha.shelepov.clientService.DAO.OrderDAO;
import toha.shelepov.clientService.DAO.ProductDAO;
import toha.shelepov.clientService.model.Order;
import toha.shelepov.clientService.model.Product;

import java.util.ArrayList;
import java.util.Set;

@Component
public class ClientServiceBusiness {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private ProductDAO productDAO;

    private Order order;

    private static final Logger log = Logger.getLogger(ClientServiceBusiness.class);

    public void deleteOrder(String idString) {
        int id = 0;

        try {
            id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            log.info("method deleteOrder", e);
        }
        orderDAO.deleteOrder(id);
    }


//
//    public static void main(String[] args) {
//        log.fatal("fatal");
//        log.error("error");
//        log.warn("warn");
//        log.info("info");
//        log.debug("debug");
//        log.trace("trace");
//    }

    public void createOrder() {
        order = new Order();
        orderDAO.saveOrder(order);
    }

    public void addProduct(Product product) {
        int count = product.getCount();
        long id = product.getId();
        product = productDAO.getProductId(id);
        product.setCount(count);
        order.getProductList().add(product);
    }

    public void saveOrder() {
//        Set<Product> prList = order.getProductList();
//        Set<Product> productList = (Set<Product>) new ArrayList<Product>();
//        order.setProductList(productList);
//        orderDAO.createOrder(order);
//        order.setProductList(prList);
        orderDAO.saveOrder(order);
    }

    public void saveOrder(Order order) {
        orderDAO.saveOrder(order);
    }

    public void updateOrder(long id, Order order) {
        orderDAO.updateOrder(id, order);
    }
}
