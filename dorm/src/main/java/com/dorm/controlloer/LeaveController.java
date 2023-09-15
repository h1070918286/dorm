package com.dorm.controlloer;

import com.dorm.pojo.Leave;
import com.dorm.pojo.User;
import com.dorm.service.LeaveService;
import com.dorm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/leave")
public class LeaveController {

    private final LeaveService leaveService;

    private final UserService userService;

    public LeaveController(LeaveService leaveService, UserService userService) {
        this.leaveService = leaveService;
        this.userService = userService;
    }

    @PostMapping("/submit")
    public ModelAndView change(@ModelAttribute Leave leave,
                               HttpServletRequest request
                             ){
        // 获取 session 对象
        HttpSession session = request.getSession();
        // 获取 session 中的属性
        Integer userId = (Integer) session.getAttribute("userId");
        leaveService.submit(userId,leave);
        List<Leave> list = leaveService.getById(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","申请成功");
        modelAndView.addObject("leaveRecords",list);
        modelAndView.setViewName("stud_leave");
        return modelAndView;
    }

    @PostMapping("/search")
    public String search(@RequestParam("status") int status,Model model){
        if (status == 0){
            List<Leave> list = leaveService.getAll();
            for (Leave item:
                 list) {
                Integer user_id = item.getUser_id();
                User u = userService.getById(user_id);
                item.setName(u.getName());
            }
            model.addAttribute("leaves",list);
        }
        if (status == 1){
            List<Leave> list = leaveService.getNoPermit();
            for (Leave item:
                    list) {
                Integer user_id = item.getUser_id();
                User u = userService.getById(user_id);
                item.setName(u.getName());
            }
            model.addAttribute("leaves",list);
        }
        if (status == 2){
            List<Leave> list = leaveService.getPermit();
            for (Leave item:
                    list) {
                Integer user_id = item.getUser_id();
                User u = userService.getById(user_id);
                item.setName(u.getName());
            }
            model.addAttribute("leaves",list);
        }
        return "tea_leave";
    }

    @PostMapping("/permit")
    public String permit(Model model,@RequestParam("id") int id){
        leaveService.permit(id);
        List<Leave> list = leaveService.getAll();
        for (Leave item:
                list) {
            Integer user_id = item.getUser_id();
            User u = userService.getById(user_id);
            item.setName(u.getName());
        }
        model.addAttribute("leaves",list);
        model.addAttribute("msg","操作成功");
        return "tea_leave";
    }

    @PostMapping("/noPermit")
    public String noPermit(Model model,@RequestParam("id") int id){
        leaveService.noPermit(id);
        List<Leave> list = leaveService.getAll();
        for (Leave item:
                list) {
            Integer user_id = item.getUser_id();
            User u = userService.getById(user_id);
            item.setName(u.getName());
        }
        model.addAttribute("msg","操作成功");
        model.addAttribute("leaves",list);
        return  "tea_leave";
    }


}
