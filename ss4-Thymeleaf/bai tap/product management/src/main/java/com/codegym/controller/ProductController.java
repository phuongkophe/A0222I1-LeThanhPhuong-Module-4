package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
//    @Qualifier("productService")
    private IProductService productService;
//    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String showList(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(Product product){
        productService.update(product.getId(), product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(Product product){
        productService.remove(product.getId());
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "view";
    }

    @GetMapping("/search")
    public String search(@RequestParam("nameSearch") String nameSearch, Model model){
        List<Product> productList = productService.search(nameSearch);
        model.addAttribute("productList", productList);
        return "index";
    }
}
