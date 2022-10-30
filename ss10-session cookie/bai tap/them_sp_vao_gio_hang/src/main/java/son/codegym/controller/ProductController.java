package son.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import son.codegym.entity.Cart;
import son.codegym.entity.Product;
import son.codegym.service.IProductService;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCard(){
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action, RedirectAttributes redirectAttributes) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("reduce")) {
           cart.reduceProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if(action.equals("delete")) {
            cart.deleteProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        redirectAttributes.addFlashAttribute("mess",productOptional.get().getName()+" Đã thêm vào giỏ hàng");
        return "redirect:/shop";
    }

    @GetMapping("/pay")
    private String pay(@ModelAttribute Cart cart, RedirectAttributes redirectAttributes){
        double totalPay = cart.countTotalPayment();
        redirectAttributes.addFlashAttribute("totalPay", totalPay);
        cart.pay();
        redirectAttributes.addFlashAttribute("mess", "Thanh toán thành công");
        return "redirect:/shopping-cart";
    }

    @GetMapping("/view/{id}")
    private String pay(@PathVariable("id") Long id,@ModelAttribute Cart cart, Model model){
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()){
            return "/error.404";
        }
        model.addAttribute("product",product);
        return "/view";
    }
}
