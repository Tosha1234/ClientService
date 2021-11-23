package toha.shelepov.clientService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import toha.shelepov.clientService.DAO.OrderDAO;

@Controller
@RequestMapping("/orders")
public class ClientServiceController {

    @Autowired
    OrderDAO orderDAO;

    @GetMapping
    public String getClientPage(Model model) {
        model.addAttribute("list", orderDAO.getAll());
        return "ClientPage";
    }
}
