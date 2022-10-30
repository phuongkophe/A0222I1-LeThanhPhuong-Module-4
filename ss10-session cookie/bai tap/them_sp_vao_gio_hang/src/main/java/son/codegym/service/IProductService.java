package son.codegym.service;

import son.codegym.entity.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
    void delete(Product product);
}
