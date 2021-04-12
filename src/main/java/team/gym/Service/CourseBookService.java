package team.gym.Service;

import team.gym.Beans.CourseBook;

import java.util.List;

public interface CourseBookService {

    //查询报名表信息
    public List<CourseBook> findClassOrder();

    //添加报名报信息，会员选课
    public void saveClassOrder(CourseBook courseBook);

    //id查询个人报名
    List<CourseBook> myClassOrder(Integer conumber);

    //id删除我的课程
    int deleteByCoid(Integer coid);

    //会员报名情况
    List<CourseBook> memOrderList(Integer conum);

    //查询会员是否报名该课程
    CourseBook selMemberByCoid(Integer conum, Integer conumber);
}