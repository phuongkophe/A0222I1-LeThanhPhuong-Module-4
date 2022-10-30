package son.codegym.entity;

import java.util.*;

public class Cart {

    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    ;

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId() == (product.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId() == (product.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(), newQuantity);
        }
    }

    //đếm số lượng SẢN PHẨM đó hiện có trong giỏ hàng
    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    //    Đếm số lượng sản phẩm hiện có trong giỏ hàng
    public Integer countItemQuantity() {
        return products.size();
    }

    public void reduceProduct(Product product) {
        Map.Entry<Product, Integer> entry = selectItemInCart(product);
        int newQuantity = entry.getValue() - 1;
        if (newQuantity >= 0) {
            products.replace(entry.getKey(), newQuantity);
        }
    }

    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }

    public void deleteProduct(Product product) {
        Map.Entry<Product, Integer> entry = selectItemInCart(product);
        products.remove(entry.getKey());
    }

    public void pay() {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productList.add(entry.getKey());
        }
        for (Product product : productList) {
            products.remove(product);
        }
    }
}
