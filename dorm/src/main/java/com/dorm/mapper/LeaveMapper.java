package com.dorm.mapper;

import com.dorm.pojo.Leave;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface LeaveMapper {
    @Insert("INSERT INTO leave_records (user_id,reason,leave_time) values (#{id},#{leave.reason},#{leave.leave_time})")
    void submit(Integer id, Leave leave);

    @Select("select * from leave_records where user_id = #{id}")
    List<Leave> getById(Integer id);

    @Select("select * from leave_records")
    List<Leave> getAll();

    @Select("select * from leave_records where permit != '否'")
    List<Leave> getPermit();

    @Select("select * from leave_records where permit = '否'")
    List<Leave> getNoPermit();

    @Update("update leave_records set permit = '批准' where id = #{id}")
    void permit(Integer id);

    @Update("update leave_records set permit = '否决' where id = #{id}")
    void noPermit(Integer id);




}
