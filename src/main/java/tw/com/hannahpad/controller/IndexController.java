package tw.com.hannahpad.controller;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tw.com.hannahpad.dto.DetailDto;
import tw.com.hannahpad.service.SevenElevenService;
import tw.com.hannahpad.service.SlackService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;

@Validated
@Controller
public class IndexController {

    @Autowired
    private SlackService slack;

    @Autowired
    private SevenElevenService service;

    @GetMapping("/")
    public String getPage() {
        return "/index";
    }

    @PostMapping(value = "/preview")
    public String getPreview(@RequestParam Set<@Valid @Pattern(regexp = "^[A-Z][0-9]{11}$", message = "格式不符") String> ids,
                             @RequestParam @Valid @Range(min = 1, max = 4, message = "數量錯誤") Integer perPage,
                             ModelMap map, HttpServletRequest request) {
        slack.sendMessage(ids, request);
        List<DetailDto> list = service.entry(ids);
        map.addAttribute("list", list);
        map.addAttribute("perPage", perPage);
        map.addAttribute("totalPages", Math.ceil(list.size() * 1.0 / perPage));
        return "/preview";
    }

}
