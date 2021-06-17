package ru.vlsu.graduate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.vlsu.graduate.persistence.AcGroup;
import ru.vlsu.graduate.persistence.AcGroupRepository;
import ru.vlsu.graduate.persistence.Graduate;
import ru.vlsu.graduate.persistence.GraduateRepository;

import java.security.Principal;
import java.util.List;

@Controller
public class AcGroupController {

    private AcGroupRepository groupRepo;
    private GraduateRepository graduateRepo;

    public AcGroupController(AcGroupRepository groupRepo, GraduateRepository graduateRepo) {
        this.groupRepo = groupRepo;
        this.graduateRepo = graduateRepo;
    }

    @GetMapping("/groups")
    public String groupPage(Model model){
        List<AcGroup> groups;
        groups = groupRepo.findAll();
        model.addAttribute("groups", groups);
        return "groups";
    }

    @GetMapping("/groups/graduates/{id}")
    public String graduatesByGroup(@PathVariable("id") Integer id, Model model){
        List<Graduate> graduates;
        graduates = graduateRepo.findByGroupId(id);
        model.addAttribute("graduates", graduates);
        return "graduatesbygroup";
    }
}
