package toha.shelepov.clientService.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import toha.shelepov.clientService.model.Basket;
import toha.shelepov.clientService.repository.BasketRepository;

@Component
public class BasketDAO {

    @Autowired
    BasketRepository basketRepository;

    public void addProdForBasket(long id, long id1) {
        Basket basket= (Basket) basketRepository.findByOrderid(id);
        if(basket==null){
            basket=new Basket();
            basket.setOrderId(id);
            basket.setProductId(id1);
            basket.setCount(basket.getCount()+1);
        }else {
            basket.setCount(basket.getCount()+1);
        }
        basketRepository.save(basket);
    }
}
