package com.example.demo.controller;
import com.example.demo.controller.LeagueEntity;
import com.example.demo.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/LeagueofLegend")
public class LeagueController {   


    @Autowired
    LeagueRepository lol;



    @GetMapping("/index")
    public String index(Model model) {
    model.addAttribute("League",lol.findAll());
        return "index";
    }


    @GetMapping("/create")
    public String create(Model model) {
        return "createpage";
    }


    @PostMapping("/save")
    public String createdb(Model model, String itemname,String damageitem, String categoryitem, String ablityitem , String price ){
        if (itemname == null) {
            model.addAttribute("League","กรุณากรอกค่า");
        }else{
            LeagueEntity Legend = new LeagueEntity();
            Legend.setItemname(itemname);
            Legend.setDamageitem(damageitem);
            Legend.setCategoryitem(categoryitem);
            Legend.setAblityitem(ablityitem);
            Legend.setPrice(price);
            lol.save(Legend);
            
        }
        return "redirect:/LeagueofLegend/index";
    }

    @GetMapping("/edit")
    public String edit(Model model, Integer id) {
        model.addAttribute("League",lol.findById(id));
        return "edit";
    }

    @PostMapping("/editsave")
    public String editdb(Model model, Integer id, String itemname,String damageitem, String categoryitem, String ablityitem , String price ){
        if (itemname == null) {
            model.addAttribute("League","กรุณากรอกค่า");
        }else{
            LeagueEntity Legend = new LeagueEntity();
            Legend.setItemname(itemname);
            Legend.setDamageitem(damageitem);
            Legend.setCategoryitem(categoryitem);
            Legend.setAblityitem(ablityitem);
            Legend.setPrice(price);
            Legend.setId(id);
            lol.save(Legend);
            
        }
        return "redirect:/LeagueofLegend/index";
    }

    @GetMapping("/delete")
    public String delete(Model model, Integer id) {
        
        lol.delete(lol.findById(id).get());
        
        return "redirect:/LeagueofLegend/index";
    }
        
}