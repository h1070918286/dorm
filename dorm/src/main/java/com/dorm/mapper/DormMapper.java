package com.dorm.mapper;

import com.dorm.pojo.Dorm;
import com.dorm.pojo.Leave;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DormMapper {
    @Insert("INSERT INTO dorm_records (user_id,dorm_old,dorm_new,reason) values (#{id},#{dorm.dorm_old},#{dorm.dorm_new},#{dorm.reason})")
    void submit(Integer id, Dorm dorm);

    @Select("select * from dorm_records where user_id = #{id}")
    List<Dorm> getById(Integer id);

    @Select("select * from dorm_records")
    List<Dorm> getAll();

    @Select("select * from dorm_records where permit != '否'")
    List<Dorm> getPermit();

    @Select("select * from dorm_records where permit = '否'")
    List<Dorm> getNoPermit();

    @Update("update dorm_records set permit = '批准' where id = #{id}")
    void permit(Integer id);

    @Update("update dorm_records set permit = '否决' where id = #{id}")
    void noPermit(Integer id);
}
