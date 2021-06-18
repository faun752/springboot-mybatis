package dev.sb.mb.controller;

import dev.sb.mb.mapper.*;
import dev.sb.mb.model.*;
import dev.sb.mb.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class StudentController {
    private final StudentService service;

    @GetMapping("/")
    public String getAllStudents(Model model) {
        model.addAttribute("page", service.selectAll());

        return "list";
    }

    @GetMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        return "form";
    }

    @PostMapping("/process")
    public String process(@Validated @ModelAttribute Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        service.save(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.selectByPrimaryKey(id));
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteByPrimaryKey(id);
        return "redirect:/";
    }
}
