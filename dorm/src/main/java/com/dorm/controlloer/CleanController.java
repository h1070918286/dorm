package com.dorm.controlloer;

import com.dorm.pojo.Clean;
import com.dorm.pojo.Dorm;
import com.dorm.pojo.Leave;
import com.dorm.pojo.User;
import com.dorm.service.CleanService;
import com.dorm.service.DormService;
import com.dorm.service.LeaveService;
import com.dorm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/clean")
public class CleanController {
    private final CleanService cleanService;

    private final UserService userService;

    private final LeaveService leaveService;

    private final DormService dormService;

    public CleanController(CleanService cleanService, UserService userService, LeaveService leaveService, DormService dormService) {
        this.cleanService = cleanService;
        this.userService = userService;
        this.leaveService = leaveService;
        this.dormService = dormService;
    }

    @GetMapping("/mag_clean")
    public String mag_clean(Model model){
        List<Clean> list = cleanService.getAll();
        model.addAttribute("Records",list);
        return "mag_clean";
    }

    @GetMapping("/mag_dorm")
    public String mag_dorm(Model model){
        List<Dorm> list = dormService.getAll();
        for (Dorm item:
             list) {
            Integer user_id = item.getUser_id();
            User u = userService.getById(user_id);
            item.setName(u.getName());
        }
        model.addAttribute("adjustmentRecords",list);
        return "mag_dorm";
    }

    @GetMapping("/mag_info")
    public String mag_info(Model model){
        List<User> list = userService.getAllStu();
        model.addAttribute("students",list);
        return "mag_info";
    }

    @GetMapping("/mag_leave")
    public String mag_leave(Model model){
        List<Leave> list = leaveService.getAll();
        for (Leave item:
                list) {
            Integer user_id = item.getUser_id();
            User u = userService.getById(user_id);
            item.setName(u.getName());
        }
        model.addAttribute("leaves",list);
        return "mag_leave";
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
        return "mag_info";
    }

    @PostMapping("/search_")
    public String search_(@RequestParam("status") int status,Model model){
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
        return "mag_leave";
    }

    @PostMapping("/search_dorm")
    public String search_dorm(@RequestParam("status") int status,Model model){
        if (status == 0){
            List<Dorm> list = dormService.getAll();
            for (Dorm item:
                    list) {
                Integer user_id = item.getUser_id();
                User u = userService.getById(user_id);
                item.setName(u.getName());
            }
            model.addAttribute("adjustmentRecords",list);
        }
        if (status == 1){
            List<Dorm> list = dormService.getNoPermit();
            for (Dorm item:
                    list) {
                Integer user_id = item.getUser_id();
                User u = userService.getById(user_id);
                item.setName(u.getName());
            }
            model.addAttribute("adjustmentRecords",list);
        }
        if (status == 2){
            List<Dorm> list = dormService.getPermit();
            for (Dorm item:
                    list) {
                Integer user_id = item.getUser_id();
                User u = userService.getById(user_id);
                item.setName(u.getName());
            }
            model.addAttribute("adjustmentRecords",list);
        }
        return "mag_dorm";
    }

    @PostMapping("/permit")
    public String permit(Model model,@RequestParam("id") int id){
        dormService.permit(id);
        List<Dorm> list = dormService.getAll();
        for (Dorm item:
                list) {
            Integer user_id = item.getUser_id();
            User u = userService.getById(user_id);
            item.setName(u.getName());
        }
        model.addAttribute("adjustmentRecords",list);
        return "mag_leave";
    }

    @PostMapping("/noPermit")
    public String noPermit(Model model,@RequestParam("id") int id){
        dormService.noPermit(id);
        List<Dorm> list = dormService.getAll();
        for (Dorm item:
                list) {
            Integer user_id = item.getUser_id();
            User u = userService.getById(user_id);
            item.setName(u.getName());
        }
        model.addAttribute("adjustmentRecords",list);
        return "mag_leave";
    }

    @PostMapping("/submit")
    public String submit(Model model, @ModelAttribute Clean clean){
        cleanService.submit(clean.getDorm_room(),clean.getRecord_time(),clean.getScore(),clean.getReason());
        model.addAttribute("msg","提交卫生评分成功");
        return "mag_clean";
    }

    @PostMapping("/getByDorm")
    public String getByDorm(Model model,@RequestParam("search") String dorm_room){
        if (ObjectUtils.isEmpty(dorm_room)){
            List<Clean> list = cleanService.getAll();
            model.addAttribute("Records",list);
        }else{
            List<Clean> list = cleanService.getByDorm(dorm_room);
            model.addAttribute("Records",list);
        }
        return "mag_clean";
    }




}
