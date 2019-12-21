package tw.com.hannahpad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tw.com.hannahpad.service.SevenElevenService;

import java.util.Set;

@Controller
public class IndexController {

    @Autowired
    private SevenElevenService service;

    @RequestMapping("/")
    public String getPage(ModelMap map) {
        return "/index";
    }

    @RequestMapping(value = "/preview", method = RequestMethod.POST)
    public String getPreview(@RequestParam Set<String> ids, ModelMap map) {
        map.addAttribute("list", service.entry(ids));
        return "/preview";
    }
}
