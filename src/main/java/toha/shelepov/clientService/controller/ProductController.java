package toha.shelepov.clientService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import toha.shelepov.clientService.DAO.BasketDaoSaport;
import toha.shelepov.clientService.DAO.OrderDAO;
import toha.shelepov.clientService.DAO.ProductDAO;
import toha.shelepov.clientService.model.Product;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private OrderDAO orderDAO;

    private BasketDaoSaport basketDAO;

    private Long orderId;

    private List<Product> productList = new ArrayList<>();





//    @GetMapping("/{id}/{x}")
//    public String create(@PathVariable("id") long id, @PathVariable("x") String x) {
//        basketDAO.createBasket(orderId, id, x );
//        return "redirect:/product";
//    }

    @GetMapping("/save")
    public String qwe() {

        return "redirect:/orders";
    }
}
