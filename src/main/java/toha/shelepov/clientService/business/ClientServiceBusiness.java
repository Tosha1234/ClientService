package toha.shelepov.clientService.business;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import toha.shelepov.clientService.DAO.OrderDAO;
import toha.shelepov.clientService.DAO.OrderProductDAO;
import toha.shelepov.clientService.DAO.ProductDAO;
import toha.shelepov.clientService.model.Order;
import toha.shelepov.clientService.model.OrderPoduct;
import toha.shelepov.clientService.model.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//        log.fatal("fatal");
//        log.error("error");
//        log.warn("warn");
//        log.info("info");
//        log.debug("debug");
//        log.trace("trace");

@Component
public class ClientServiceBusiness {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private OrderProductDAO orderProductDAO;

    private Order order;

    private static final Logger log = Logger.getLogger(ClientServiceBusiness.class);

    public void deleteOrder(String idString) {
        int id = 0;

        try {
            id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            log.info("method deleteOrder", e);
        }
        orderProductDAO.getOrderProduct(id).forEach(OrderPoduct-> orderProductDAO.deleteOrder(OrderPoduct));
        orderDAO.deleteOrder(id);
    }

    public void createOrder() {
        order = new Order();
        orderDAO.saveOrder(order);
    }

    public void addProduct(Product product) {

        int count = product.getCount();
        long id = product.getId();
        product = productDAO.getProductId(id);

        long id1 =  order.getId();
        OrderPoduct orderPoduct;
        try {
            orderPoduct = orderProductDAO.getOrderProduct(id1, id);
            int countProduct = orderPoduct.getCountProduct();
            orderPoduct.setCountProduct(countProduct +count);
        }catch (Exception e){
            orderPoduct=new OrderPoduct();
            orderPoduct.setOrder(id1);
            orderPoduct.setProduct(id);
            orderPoduct.setCountProduct(count);
        }

        orderProductDAO.saveOrderProduct(orderPoduct);

        int countProduct = order.getCountProduct();
        order.setCountProduct(countProduct +count);

        int price = order.getPrice();
        int price1 = product.getPrice();
        order.setPrice(price + price1 *count);
        orderDAO.saveOrder(order);
    }

    public void saveOrder() {
        order.setStatus("1");
        orderDAO.saveOrder(order);
    }

//    public void saveOrder(Order order) {
//        orderDAO.saveOrder(order);
//    }

    public void updateOrder(long id, Order order) {
        orderDAO.updateOrder(id, order);
    }

    public void getClientPage(Model model) {
        List<Order> all = orderDAO.getAll();
        model.addAttribute("list", all);
    }

    public void getProductPage(Model model) {
        Object all = productDAO.getAll();
        model.addAttribute("list", all);
    }

    public void editClientOrder(long id, Model model) {
        Order orderId = orderDAO.getOrderId(id);
        model.addAttribute("clientOrder", orderId);
    }
}
