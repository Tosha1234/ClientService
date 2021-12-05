package toha.shelepov.clientService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toha.shelepov.clientService.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
