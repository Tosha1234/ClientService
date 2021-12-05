package toha.shelepov.clientService.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import toha.shelepov.clientService.model.Product;
import toha.shelepov.clientService.repository.ProductRepository;

@Component
public class ProductDAO {

    @Autowired
    ProductRepository productRepository;

    public Object getAll() {
        return productRepository.findAll();
    }

    public Product getProductId(long id) {
        return productRepository.findById(id).get();
    }

}
