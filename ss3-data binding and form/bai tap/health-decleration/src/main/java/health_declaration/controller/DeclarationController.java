package health_declaration.controller;

import health_declaration.model.HealthDeclaration;
import health_declaration.repository.HealthDeclarationRepo;
import health_declaration.repository.HealthDeclarationRepoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeclarationController {
    HealthDeclarationRepo healthDeclarationRepo = new HealthDeclarationRepoImpl();

    @GetMapping
    public String getIndex(Model model) {
        HealthDeclaration healthDeclaration = new HealthDeclaration();
        model.addAttribute("healthDeclaration", healthDeclaration);
        return "index";
    }

    @PostMapping("/submit")
    public ModelAndView submit(@ModelAttribute("healthDeclaration") HealthDeclaration healthDeclaration) {
        healthDeclarationRepo.save(healthDeclaration);
        HealthDeclaration declaration = healthDeclarationRepo.getHealthDeclarationByIdCard(healthDeclaration.getIdCardNumber());
        ModelAndView modelAndView = new ModelAndView("detail");
        if (declaration != null) {
            modelAndView.addObject("declaration", declaration);
            modelAndView.addObject("mess", "Gửi tờ khai thành công");
        } else {
            modelAndView.addObject("mess", "Gửi tờ khai không thành công");
        }

        return modelAndView;
    }
}
