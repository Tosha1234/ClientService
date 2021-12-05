package toha.shelepov.clientService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import toha.shelepov.clientService.DAO.BasketDaoSaport;
import toha.shelepov.clientService.DAO.OrderDAO;
import toha.shelepov.clientService.DAO.ProductDAO;
import toha.shelepov.clientService.dto.ProductDto;
import toha.shelepov.clientService.model.Order;
import toha.shelepov.clientService.model.Product;

@Controller
@RequestMapping("/orders")
public class ClientServiceController {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    ProductDAO productDAO;

    @Autowired
    BasketDaoSaport basketDaoSaport;


    @GetMapping
    public String getClientPage(Model model) {
        model.addAttribute("list", orderDAO.getAll());
        return "ClientPage";
    }

    @GetMapping("/product")
    public String getProductPage(Model model) {
        model.addAttribute("list", productDAO.getAll());
        return "ProductPage";
    }

    @GetMapping("/save")
    public String saveOrder() {
        basketDaoSaport.save();
        return "redirect:/orders";
    }

    @PostMapping
    public String addOrder(@ModelAttribute("order") Order order) {
        System.out.println(order.getId());
        orderDAO.createOrder(order);
        return "redirect:/orders";
    }

    @PostMapping("/product")
    public String addProduct(@ModelAttribute("product") ProductDto productDto) {
        Product product = null;
        try {
            product = productDto.getProduct();
            basketDaoSaport.addProduct(product);
            return "redirect:/orders/product";
        } catch (Exception e) {

            e.printStackTrace();
        }
        return "redirect:/orders/product";
    }

    @GetMapping("/{id}")
    public String editClientOrder(@PathVariable("id") long id, Model model,
                                  @ModelAttribute("order") Order order) {
        model.addAttribute("clientOrder", orderDAO.getOrderId(id));
        return "ClientOrder";
    }

    @DeleteMapping("/{id}")
    public String deleteClientOrder(@PathVariable("id") int id) {
        orderDAO.deleteOrder(id);
        return "redirect:/orders";
    }

    @PatchMapping("/{id}")
    public String updateClientOrder(@ModelAttribute("order") Order order, @PathVariable("id") long id) {
        orderDAO.updateOrder(id, order);
        return "redirect:/orders";
    }

    @GetMapping("/new")
    public String newOrder() {
        basketDaoSaport = new BasketDaoSaport();
        return "redirect:/orders/product";
    }


}
