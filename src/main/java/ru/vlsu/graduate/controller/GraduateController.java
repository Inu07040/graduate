package ru.vlsu.graduate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vlsu.graduate.persistence.Graduate;
import ru.vlsu.graduate.persistence.GraduateRepository;
import ru.vlsu.graduate.persistence.AcGroup;
import ru.vlsu.graduate.persistence.AcGroupRepository;

import java.util.List;

@Controller
public class GraduateController {

    private GraduateRepository graduateRepo;
    private AcGroupRepository groupRepo;

    @Autowired
    public GraduateController(GraduateRepository graduateRepository, AcGroupRepository acGroupRepository){
        this.graduateRepo = graduateRepository;
        this.groupRepo = acGroupRepository;
    }

    @GetMapping("/")
    public String indexPage(Model model){

        return "index";
    }

    @GetMapping("/graduates")
    public String graduatePage(Model model) {

        List<Graduate> graduates;
        graduates = graduateRepo.findAll();
        model.addAttribute("graduates", graduates);
        return "graduates";
    }

    @GetMapping("/newgraduate")
    public String createGraduate(Model model){
        List<AcGroup> groups = groupRepo.findAll();
        Graduate graduate = new Graduate();
        model.addAttribute("groups", groups);
        model.addAttribute("graduate", graduate);
        return "newgraduate";
    }

    @PostMapping("/save")
    public String savePet(Graduate graduate){
        graduateRepo.save(graduate);
        return "redirect:/graduates";
    }
}
