package com.dorm.service;

import com.dorm.mapper.CleanMapper;
import com.dorm.pojo.Clean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CleanService {
    private final CleanMapper cleanMapper;

    public CleanService(CleanMapper cleanMapper) {
        this.cleanMapper = cleanMapper;
    }

    public List<Clean> getAll(){
        return cleanMapper.getAll();
    }

    public void submit(String dorm_room,String record_time,String score,String reason){
        cleanMapper.submit(dorm_room, record_time, score, reason);
    }

    public List<Clean> getByDorm(String dorm_room){
        return cleanMapper.getByDorm(dorm_room);
    }
}
