package son.codegym.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import son.codegym.entity.Customer;
import son.codegym.entity.CustomerType;
import son.codegym.service.customer.ICustomerService;
import son.codegym.service.customer_type.ICustomerTypeService;
import son.codegym.validation.ValidationCustomer;

import javax.validation.Valid;
import javax.validation.Validation;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    public ModelAndView list(@PageableDefault(value = 5, sort = "customerName", direction = Sort.Direction.DESC) Pageable pageable,
                             @RequestParam("customerNameSearch") Optional<String> customerName,
                             @RequestParam("customerTypeId") Optional<Integer> customerTypeId,
                             @RequestParam("customerEmail") Optional<String> customerEmail) {
        List<CustomerType> customerTypes = customerTypeService.findAll();
        Page<Customer> customerList;
        String condition = "";
        ModelAndView modelAndView = new ModelAndView("customer/list");
        if (customerName.isPresent() || customerTypeId.isPresent() || customerEmail.isPresent()) {
            customerList = customerService.search(customerName.get(), customerEmail.get(), customerTypeId.get(), pageable);
            if (customerList.isEmpty()) {
                modelAndView.addObject("mess", "Không tìm thấy");
            }
            if (customerName.isPresent()) {
//                modelAndView.addObject("nameSearch", customerName.get());
                condition += "&customerName=" + customerName.get();
            }
            if (customerTypeId.isPresent()) {
//                modelAndView.addObject("typeIdSearch", customerTypeId.get());
                condition += "&customerTypeId=" + customerTypeId.get();
            }
            if (customerEmail.isPresent()) {
//                modelAndView.addObject("emailSearch", customerEmail.get());
                condition += "&customerEmail=" + customerEmail.get();
            }
        } else {
            customerList = customerService.findAllWithPaging(pageable);
        }
        modelAndView.addObject("customerTypes", customerTypes);
            modelAndView.addObject("condition", condition);
        modelAndView.addObject("customers", customerList);
        return modelAndView;
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        List<CustomerType> customerTypes = customerTypeService.findAll();
        Customer customer = new Customer();
        customer.setCustomerTypeId(new CustomerType());
        model.addAttribute("customer", customer);
        model.addAttribute("customerTypes", customerTypes);
        return "/customer/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        ValidationCustomer validationCustomer = new ValidationCustomer();
        validationCustomer.validate(customer, bindingResult);
        if (customer.getCustomerTypeId() == null) {
            customer.setCustomerTypeId(new CustomerType());
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("mess", "Thêm mới thất bại");
            List<CustomerType> customerTypes = customerTypeService.findAll();
            model.addAttribute("customer", customer);
            model.addAttribute("customerTypes", customerTypes);
            return "/customer/create";
        }

        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        customerService.create(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/edit/{customer_id}")
    public String showUpdate(@PathVariable("customer_id") String id, Model model) {
        List<CustomerType> customerTypes = customerTypeService.findAll();
        Customer customer = customerService.findById(id);
        model.addAttribute("customerTypes", customerTypes);
        model.addAttribute("customer", customer);
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        ValidationCustomer validationCustomer = new ValidationCustomer();
        validationCustomer.validate(customer, bindingResult);
        if (customer.getCustomerTypeId() == null) {
            customer.setCustomerTypeId(new CustomerType());
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("mess", "Cập nhật thất bại");
            List<CustomerType> customerTypes = customerTypeService.findAll();
            model.addAttribute("customer", customer);
            model.addAttribute("customerTypes", customerTypes);
            return "/customer/edit";
        }

        redirectAttributes.addFlashAttribute("mess", "Cập nhật thành công");
        customerService.create(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") String id, Model model) {
        Customer customer = customerService.findById(id);
        System.out.println(customer.getCustomerId());
        model.addAttribute("customer", customer);
        return "/customer/view";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") String id) {
        List<CustomerType> customerTypes = customerTypeService.findAll();
        Customer customer = customerService.findById(id);
        System.out.println(customer.getCustomerId());
        ModelAndView modelAndView = new ModelAndView("customer/form-delete","customerTypes",customerTypes);
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("deleteId") String id, RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/customer/list";
    }
}
