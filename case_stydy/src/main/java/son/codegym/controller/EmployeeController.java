package son.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import son.codegym.entity.*;
import son.codegym.service.division.IDivisionService;
import son.codegym.service.education.IEducationService;
import son.codegym.service.employee.IEmployeeService;
import son.codegym.service.postion.IPositionService;
import son.codegym.validation.ValidationEmployee;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IPositionService positionService;
    @Autowired
    IDivisionService divisionService;
    @Autowired
    IEducationService educationService;

    @ModelAttribute("positions")
    List<Position> findAllPosition(){
        return positionService.findAll();
    }

    @ModelAttribute("divisions")
    List<Division> findAllDivision(){
        return divisionService.findAll();
    }

    @ModelAttribute("educations")
    List<EducationDegree> findAllEducation(){
        return educationService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView list(Model model, @RequestParam(defaultValue = "0") int page,
                             @RequestParam("nameSearch") Optional<String> nameSearch,
                             @RequestParam("positionSearch") Optional<String> positionSearch,
                             @RequestParam("divisionSearch") Optional<String> divisionSearch) {
        String nameSearchValue = "";
        String positionSearchValue = "";
        String divisionSearchValue = "";
        ModelAndView modelAndView = new ModelAndView("employee/list");
        if (nameSearch.isPresent()) {

            nameSearchValue = nameSearch.get();
        }
        if (positionSearch.isPresent()) {

            positionSearchValue = positionSearch.get();
        }
        if (divisionSearch.isPresent()) {

            divisionSearchValue = divisionSearch.get();
        }
        model.addAttribute("nameSearch", nameSearchValue);
        model.addAttribute("positionSearch", positionSearchValue);
        model.addAttribute("divisionSearch", divisionSearchValue);

        Page<Employee> employees = employeeService.findAllAndSearch(nameSearchValue, positionSearchValue, divisionSearchValue, PageRequest.of(page, 4));

        if(employees.isEmpty()){
            modelAndView.addObject("mess", "Không tìm thấy");
        }
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }


    @GetMapping("/create")
    public String viewCreate(Model model) {
        Employee employee = new Employee();
        employee.setDivisionId(new Division());
        employee.setEducationDegreeId(new EducationDegree());
        employee.setPositionId(new Position());
        model.addAttribute("employee", employee);
       
        return "/employee/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        ValidationEmployee validationemployee = new ValidationEmployee();
        validationemployee.validate(employee, bindingResult);
        if (employee.getPositionId() == null) {
            employee.setPositionId(new Position());
        }
        if (employee.getDivisionId() == null) {
            employee.setDivisionId(new Division());
        }
        if (employee.getEducationDegreeId() == null) {
            employee.setEducationDegreeId(new EducationDegree());
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("mess", "Thêm mới thất bại");
            model.addAttribute("employee", employee);
            return "/employee/create";
        }

        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        employeeService.create(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/edit/{employee_id}")
    public String showUpdate(@PathVariable("employee_id") int id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "/employee/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        ValidationEmployee validationemployee = new ValidationEmployee();
        validationemployee.validate(employee, bindingResult);
        if (employee.getPositionId() == null) {
            employee.setPositionId(new Position());
        }
        if (employee.getDivisionId() == null) {
            employee.setDivisionId(new Division());
        }
        if (employee.getEducationDegreeId() == null) {
            employee.setEducationDegreeId(new EducationDegree());
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("mess", "Cập nhật thất bại");
            model.addAttribute("employee", employee);
            return "/employee/edit";
        }

        redirectAttributes.addFlashAttribute("mess", "Cập nhật thành công");
        employeeService.create(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") int id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "/employee/view";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") int id) {
        Employee employee = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("employee/form-delete");
        modelAndView.addObject("employee",employee);
        return modelAndView;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("deleteId") int id, RedirectAttributes redirectAttributes) {
        employeeService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/employee/list";
    }
}
