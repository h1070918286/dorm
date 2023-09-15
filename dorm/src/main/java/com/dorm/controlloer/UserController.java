package com.dorm.controlloer;

import com.dorm.pojo.Dorm;
import com.dorm.pojo.Leave;
import com.dorm.pojo.User;
import com.dorm.service.DormService;
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
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final LeaveService leaveService;

    private final DormService dormService;

    public UserController(UserService userService, LeaveService leaveService, DormService dormService) {
        this.userService = userService;
        this.leaveService = leaveService;
        this.dormService = dormService;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute User user){
        User u= userService.login(user.getName(),user.getPassword());
        if (ObjectUtils.isEmpty(u)){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("msg","账户密码不正确!");
            modelAndView.setViewName("index");
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView();
            if (user.getRole() == 0){
                modelAndView.setViewName("student");
            }else if (user.getRole() == 1){
                modelAndView.setViewName("teacher");
            }else if (user.getRole() == 2){
                modelAndView.setViewName("manager");
            }
            modelAndView.addObject("userId",u.getId());
            return modelAndView;
        }
    }

    @GetMapping("/stud_change_password")
    public String stud_change_password(Model model, HttpServletRequest request){
        // 获取 session 对象
        HttpSession session = request.getSession();

        // 获取 session 中的属性
        Integer attributeValue = (Integer) session.getAttribute("userId");
        System.out.println(attributeValue);
        return "stud_change_password";
    }

    @PostMapping("/change")
    public ModelAndView change(@RequestParam("currentName") String currentName,
                               @RequestParam("currentPassword") String currentPassword,
                               @RequestParam("newPassword") String newPassword,
                               @RequestParam("confirmPassword") String confirmPassword){
        ModelAndView modelAndView = new ModelAndView();
        if (!newPassword.equals(confirmPassword)){
            modelAndView.setViewName("stud_change_password");
            modelAndView.addObject("msg","密码不一致");
        }
        User u= userService.login(currentName,currentPassword);
        if (ObjectUtils.isEmpty(u)){
            modelAndView.setViewName("stud_change_password");
            modelAndView.addObject("msg","当前密码错误");
        }
        userService.change(u.getId(), confirmPassword);
        modelAndView.setViewName("index");
        modelAndView.addObject("msg","修改密码成功");
        return modelAndView;
    }

    @GetMapping("/stud_change_info")
    public String stud_change_info(Model model,HttpServletRequest request){
        // 获取 session 对象
        HttpSession session = request.getSession();
        // 获取 session 中的属性
        Integer userId = (Integer) session.getAttribute("userId");
        User user = userService.getById(userId);
        model.addAttribute("user",user);
        return "stud_change_info";
    }

    @PostMapping("/changeInfo")
    public String changeInfo(@ModelAttribute User user,HttpServletRequest request,Model model){
        // 获取 session 对象
        HttpSession session = request.getSession();
        // 获取 session 中的属性
        Integer userId = (Integer) session.getAttribute("userId");
        userService.changeInfo(userId,user);
        User u = userService.getById(userId);
        model.addAttribute("user",u);
        model.addAttribute("msg","更新成功");
        return "stud_change_info";
    }

    @GetMapping("/stud_leave")
    public String stud_leave(Model model, HttpServletRequest request){
        // 获取 session 对象
        HttpSession session = request.getSession();

        // 获取 session 中的属性
        Integer userId = (Integer) session.getAttribute("userId");
        List<Leave> list = leaveService.getById(userId);
        model.addAttribute("leaveRecords",list);
        return "stud_leave";
    }

    @GetMapping("/stud_change_dorm")
    public String stud_change_dorm(Model model, HttpServletRequest request){
        // 获取 session 对象
        HttpSession session = request.getSession();
        // 获取 session 中的属性
        Integer userId = (Integer) session.getAttribute("userId");
        User user = userService.getById(userId);
        List<Dorm> list = dormService.getById(userId);
        model.addAttribute("currentDorm",user.getDorm_room());
        model.addAttribute("adjustmentRecords",list);
        return "stud_change_dorm";
    }

    @GetMapping("/tea_info")
    public String tea_info(Model model){
        List<User> list = userService.getAllStu();
        model.addAttribute("students",list);
        return "tea_info";
    }

    @PostMapping("/search")
    public String search(Model model,@RequestParam("class_room_form") String class_room_form,
                         @RequestParam("dorm_room_form") String dorm_room_form){
        String class_room = class_room_form;
        String dorm_room = dorm_room_form;
        if(ObjectUtils.isEmpty(class_room) && ObjectUtils.isEmpty(dorm_room)){
            List<User> list = userService.getAllStu();
            model.addAttribute("students",list);
        }
        if (ObjectUtils.isEmpty(class_room) && !ObjectUtils.isEmpty(dorm_room)){
            List<User> list = userService.getStuByDorm(dorm_room);
            model.addAttribute("students",list);
        }
        if (!ObjectUtils.isEmpty(class_room) && ObjectUtils.isEmpty(dorm_room)){
            List<User> list = userService.getStuByClass(class_room);
            model.addAttribute("students",list);
        }
        if (!ObjectUtils.isEmpty(class_room) && !ObjectUtils.isEmpty(dorm_room)){
            List<User> list = userService.getStu(class_room, dorm_room);
            model.addAttribute("students",list);
        }
        return "tea_info";
    }

    @PostMapping("/updateInfo")
    public String updateInfo(Model model,@ModelAttribute User user){
        userService.updateInfo(user);
        List<User> list = userService.getAllStu();
        model.addAttribute("msg","更新成功");
        model.addAttribute("students", list);
        return "tea_info";
    }

    @GetMapping("/tea_leave")
    public String tea_leave(Model model){
        List<Leave> list = leaveService.getAll();
        for (Leave item:
                list) {
            Integer user_id = item.getUser_id();
            User u = userService.getById(user_id);
            item.setName(u.getName());
        }
        model.addAttribute("leaves",list);
        return "tea_leave";
    }


}
