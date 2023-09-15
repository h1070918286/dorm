package com.dorm.service;

import com.dorm.mapper.DormMapper;
import com.dorm.pojo.Dorm;
import com.dorm.pojo.Leave;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormService {
    private final DormMapper dormMapper;

    public DormService(DormMapper dormMapper) {
        this.dormMapper = dormMapper;
    }

    public void submit(Integer id, Dorm dorm){
        dormMapper.submit(id,dorm);
    }

    public List<Dorm> getById(Integer id){
        return dormMapper.getById(id);
    }

    public List<Dorm> getAll(){
        return dormMapper.getAll();
    }

    public List<Dorm> getPermit(){
        return dormMapper.getPermit();
    }

    public List<Dorm> getNoPermit(){
        return dormMapper.getNoPermit();
    }

    public void permit(Integer id){
        dormMapper.permit(id);
    }

    public void noPermit(Integer id){
        dormMapper.noPermit(id);
    }
}
