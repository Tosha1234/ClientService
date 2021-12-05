package toha.shelepov.clientService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toha.shelepov.clientService.model.Basket;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {

    List<Basket> findByOrderid(long id);

    Basket findByOrderidAndProductid(long orderid, long productid);
}
