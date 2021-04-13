package team.gym.Service;

import team.gym.Beans.CourseTable;

import java.util.List;

public interface CourseTableService {
    //查询课程信息
    public List<CourseTable> findClassTable();

    //删除课程
    public int deleteClassId(Integer classId);

    //新增课程
    public void saveClass(CourseTable courseTable);

    //id查询课程
    CourseTable selectByClassId(Integer classId);

    Boolean deleteByConum(Integer conum);

}
