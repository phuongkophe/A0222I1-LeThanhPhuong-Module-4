package son.codegym.controller;

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
import son.codegym.entity.*;
import son.codegym.service.rent_type.IRentTypeService;
import son.codegym.service.service.IServiceService;
import son.codegym.service.service_type.IServiceTypeService;
import son.codegym.validation.ValidationCustomer;
import son.codegym.validation.ValidationService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/service")
@Controller
public class ServiceController {
    @Autowired
    IServiceService serviceService;

    @Autowired
    IServiceTypeService serviceTypeService;

    @Autowired
    IRentTypeService rentTypeService;

    @ModelAttribute("rentTypes")
    List<RentType> getAllRentType(){
        return rentTypeService.findAll();
    }

    @ModelAttribute("serviceTypes")
    List<ServiceType> getAllServiceType(){
        return serviceTypeService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView list(@PageableDefault(value = 5) Pageable pageable) {
//        List<RentType> rentTypes = rentTypeService.findAll();
//        List<ServiceType> serviceTypes = serviceTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("service/list");
//        modelAndView.addObject("rentTypes", rentTypes);
//        modelAndView.addObject("serviceTypes", serviceTypes);
        Page<Service> services = serviceService.findAllWithPaging(pageable);
        modelAndView.addObject("services", services);
        return modelAndView;
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
//        List<RentType> rentTypes = rentTypeService.findAll();
//        List<ServiceType> serviceTypes = serviceTypeService.findAll();
        Service service = new Service();
        service.setServiceTypeId(new ServiceType());
        service.setRentTypeId(new RentType());
        model.addAttribute("service", service);
//        model.addAttribute("rentTypes", rentTypes);
//        model.addAttribute("serviceTypes", serviceTypes);
        return "/service/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("service") Service service, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        ValidationService validationService = new ValidationService();
        validationService.validate(service, bindingResult);
        if (service.getRentTypeId() == null) {
            service.setRentTypeId(new RentType());
        }
        if (service.getServiceTypeId() == null) {
            service.setServiceTypeId(new ServiceType());
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("mess", "Thêm mới thất bại");
//            List<RentType> rentTypes = rentTypeService.findAll();
//            List<ServiceType> serviceTypes = serviceTypeService.findAll();
            model.addAttribute("service", service);
//            model.addAttribute("rentTypes", rentTypes);
//            model.addAttribute("serviceTypes", serviceTypes);
            return "/service/create";
        }

        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        serviceService.create(service);
        return "redirect:/service/list";
    }
}
