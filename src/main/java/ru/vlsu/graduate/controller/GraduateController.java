package ru.vlsu.graduate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vlsu.graduate.persistence.Graduate;
import ru.vlsu.graduate.persistence.GraduateRepository;
import ru.vlsu.graduate.persistence.Group;
import ru.vlsu.graduate.persistence.GroupRepository;

import java.security.Principal;
import java.util.List;

@Controller
public class GraduateController {

    private GraduateRepository graduateRepo;
    private GroupRepository groupRepo;

    @Autowired
    public GraduateController(GraduateRepository graduateRepository, GroupRepository groupRepository){
        this.graduateRepo = graduateRepository;
        this.groupRepo = groupRepository;
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
    public String createPet(Model model){
        List<Group> groups = groupRepo.findAll();
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
