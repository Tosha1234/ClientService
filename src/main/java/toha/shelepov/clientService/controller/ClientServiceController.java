package toha.shelepov.clientService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientServiceController {

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String getClientPage() {
        return "ClientPage";
    }
}
