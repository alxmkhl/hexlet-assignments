package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import exercise.model.Product;

import org.springframework.data.domain.Sort;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // BEGIN
    List<Product> findByPriceBetween(int startPrice, int endPrice, Sort sort);
    List<Product> findByPriceGreaterThan(int startPrice, Sort sort);
    List<Product> findByPriceLessThan(int startPrice, Sort sort);
    // END
}
