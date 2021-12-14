package toha.shelepov.clientService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toha.shelepov.clientService.model.OrderPoduct;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderPoduct, Long> {

    OrderPoduct findByOrderAndProduct(long oId, long pId);

    List<OrderPoduct> findAllByOrder(long oId);
}
