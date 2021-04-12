package team.gym.Dao;

import team.gym.Beans.CourseTable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 课程接口
 */
@Repository
public interface CourseTableDao {

    //查询所有课程
    public List<CourseTable> findClassTable();

    //删除课程
    public int deleteByClassid(Integer classid);

    //添加课程
    public void saveclass(CourseTable courseTable);

    //根据id查询课表
    public CourseTable selByClassId(Integer classid);

    //CONUM删除课程
    Boolean delByConum(Integer conum);

}