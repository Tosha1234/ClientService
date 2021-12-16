package toha.shelepov.clientService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toha.shelepov.clientService.model.OrderProduct;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

    OrderProduct findByOrderAndProduct(long oId, long pId);

    List<OrderProduct> findAllByOrder(long oId);
}
