package iticbcn.yeray.mvc.Service;

import java.util.Set;

import iticbcn.yeray.mvc.Model.Product;

public interface ProductService {
 
    Set<Product> findAllProducts();
    Product findProductsByName(String name);
    Set<Product> findAllProducts(String subcategory);
    void increasePrice(Product product);
}
