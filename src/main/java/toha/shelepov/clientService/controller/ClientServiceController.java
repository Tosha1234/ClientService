package toha.shelepov.clientService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import toha.shelepov.clientService.DAO.OrderDAO;
import toha.shelepov.clientService.DAO.ProductDAO;
import toha.shelepov.clientService.model.Order;
import toha.shelepov.clientService.model.Product;
import toha.shelepov.clientService.business.ClientServiceBusiness;

@Controller
@RequestMapping("/orders")
public class ClientServiceController {

    @Autowired
    ClientServiceBusiness clientServiceBusiness;

    @GetMapping
    public String getAllOrders(Model model) {
        clientServiceBusiness.getClientPage(model);
        return "ClientPage";
    }

    @GetMapping("/new")
    public String createOrder() {
        clientServiceBusiness.createOrder();
        return "redirect:/orders/product";
    }

    @GetMapping("/product")
    public String getProductPage(Model model) {
        clientServiceBusiness.getProductPage(model);
        return "ProductPage";
    }

    @PostMapping("/product")
    public String addProductInOrder(@ModelAttribute("product") Product product) {
        clientServiceBusiness.addProduct(product);
        return "redirect:/orders/product";
    }

    @GetMapping("/save")
    public String saveOrder() {
        clientServiceBusiness.saveOrder();
        return "redirect:/orders";
    }

    @DeleteMapping("/{id}")
    public String deleteClientOrder(@PathVariable("id") String id) {
        clientServiceBusiness.deleteOrder(id);
        return "redirect:/orders";
    }
//    @PostMapping
//    public String addOrder(@ModelAttribute("order") Order order) {
//        clientServiceBusiness.saveOrder(order);
//        return "redirect:/orders";
//    }


    @GetMapping("/{id}")
    public String editClientOrder(@PathVariable("id") long id, Model model) {
        clientServiceBusiness.editClientOrder(id, model);
        return "ClientOrder";
    }

    @DeleteMapping("/product/{id}")
    public String deleteProductInOrder(@PathVariable("id") long id){
        long l = clientServiceBusiness.deleteProductInOrder(id);
        return "redirect:/orders/"+l;
    }

    @PatchMapping("/{id}")
    public String updateClientOrder(@ModelAttribute("order") Order order, @PathVariable("id") long id) {
        clientServiceBusiness.updateOrder(id, order);
        return "redirect:/orders";
    }

}
