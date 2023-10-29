package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("employers")
public class EmployerController {

    @Autowired
    EmployerRepository employerRepository;

    @GetMapping("")
    public String index(Model model) {
        Iterable<Employer> employers;
        employers = employerRepository.findAll();
        model.addAttribute("title", "Employers");
        model.addAttribute("employers", employers);
        return "employers/index";
    }

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        model.addAttribute("title", "Add Employer");
        return "employers/add";
    }

    @PostMapping(value="add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "employers/add";
        } else {
            employerRepository.save(newEmployer);
        }
        Iterable<Employer> employers;
        employers = employerRepository.findAll();
        model.addAttribute("title", "Add Employer");
        model.addAttribute("employers", employers);
        return "employers/index";
    }

    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        Optional optEmployer = employerRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            return "redirect:../";
        }

    }
}
