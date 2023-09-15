package com.dorm.service;

import com.dorm.mapper.LeaveMapper;
import com.dorm.pojo.Leave;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveService {
    private final LeaveMapper leaveMapper;

    public LeaveService(LeaveMapper leaveMapper) {
        this.leaveMapper = leaveMapper;
    }

    public void submit(Integer id, Leave leave){
        leaveMapper.submit(id, leave);
    }

    public List<Leave> getById(Integer id){
        return leaveMapper.getById(id);
    }

    public List<Leave> getAll(){
        return leaveMapper.getAll();
    }

    public List<Leave> getPermit(){
        return leaveMapper.getPermit();
    }

    public List<Leave> getNoPermit(){
        return leaveMapper.getNoPermit();
    }

    public void permit(Integer id){
        leaveMapper.permit(id);
    }

    public void noPermit(Integer id){
        leaveMapper.noPermit(id);
    }
}
