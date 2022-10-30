package son.codegym.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import son.codegym.entity.Product;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
}
