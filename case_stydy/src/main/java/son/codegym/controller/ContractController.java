package son.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import son.codegym.entity.Contract;
import son.codegym.entity.Customer;
import son.codegym.entity.Employee;
import son.codegym.entity.Service;
import son.codegym.service.contract.IContractService;
import son.codegym.service.customer.ICustomerService;
import son.codegym.service.employee.IEmployeeService;
import son.codegym.service.service.IServiceService;
import son.codegym.validation.ValidationContract;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractService contractService;

    @Autowired
    ICustomerService customerService;

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    IServiceService serviceService;

    @ModelAttribute("customers")
    List<Customer> findAllCustomer(){
        return customerService.findAll();
    }

    @ModelAttribute("employees")
    List<Employee> findAllEmployee(){
        return employeeService.findAll();
    }

    @ModelAttribute("services")
    List<Service> findAllService(){
        return serviceService.findAll();
    }


    @GetMapping("/list")
    public ModelAndView list(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("contract/list");
        Page<Contract> contracts = contractService.findAllWithPaging(pageable);
        modelAndView.addObject("contracts", contracts);
        return modelAndView;
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        Contract contract = new Contract();
        contract.setCustomerId(new Customer());
        contract.setEmployeeId(new Employee());
        contract.setServiceId(new Service());
        model.addAttribute("contract", contract);
        return "/contract/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("contract") Contract contract, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        ValidationContract validation = new ValidationContract();
        validation.validate(contract, bindingResult);
        if (contract.getCustomerId() == null) {
            contract.setCustomerId(new Customer());
        }
        if (contract.getEmployeeId() == null) {
            contract.setEmployeeId(new Employee());
        }

        if (contract.getServiceId() == null) {
            contract.setServiceId(new Service());
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("mess", "Thêm mới thất bại");
            model.addAttribute("contract", contract);
            return "/contract/create";
        }

        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        contractService.create(contract);
        return "redirect:/contract/list";
    }
}
