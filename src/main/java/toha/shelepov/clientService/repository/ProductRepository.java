package toha.shelepov.clientService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toha.shelepov.clientService.model.Product;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long>{

}
