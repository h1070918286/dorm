package com.dorm.mapper;

import com.dorm.pojo.Clean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CleanMapper {
    @Select("select * from clean_records")
    List<Clean> getAll();

    @Insert("INSERT INTO clean_records set dorm_room = #{dorm_room},record_time = #{record_time},score = #{score},reason = #{reason}")
    void submit(String dorm_room,String record_time,String score,String reason);

    @Select("select * from clean_records where dorm_room = #{dorm_room}")
    List<Clean> getByDorm(String dorm_room);
}
