package com.dorm.controlloer;

import com.dorm.pojo.Dorm;
import com.dorm.pojo.Leave;
import com.dorm.service.DormService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/dorm")
public class DormController {
    private final DormService dormService;

    public DormController(DormService dormService) {
        this.dormService = dormService;
    }

    @PostMapping("/submit")
    public ModelAndView change(@ModelAttribute Dorm dorm,
                               HttpServletRequest request
    ){
        // 获取 session 对象
        HttpSession session = request.getSession();
        // 获取 session 中的属性
        Integer userId = (Integer) session.getAttribute("userId");
        dormService.submit(userId, dorm);
        List<Dorm> list = dormService.getById(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","申请成功");
        modelAndView.addObject("adjustmentRecords",list);
        modelAndView.setViewName("stud_change_dorm");
        return modelAndView;
    }
}
