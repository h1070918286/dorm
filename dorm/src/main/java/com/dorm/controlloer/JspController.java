package com.dorm.controlloer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspController {

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("msg","跟一一哥学习SpringBoot中使用JSP功能!");
        //要跳转到的页面视图名称
        return "index";
    }


}
