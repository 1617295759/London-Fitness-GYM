package team.gym.Beans;

import java.io.Serializable;

/**
 * 课程表
 */
public class CourseTable implements Serializable {

    private int classid;
    private String classname;
    private String classbegin;
    private String classtime;
    private String teacher;

    @Override
    public String toString() {
        return "CourseTable{" +
                "classid=" + classid +
                ", classname='" + classname + '\'' +
                ", classbegin='" + classbegin + '\'' +
                ", classtime='" + classtime + '\'' +
                ", teacher='" + teacher + '\'' +
                '}';
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getClassbegin() {
        return classbegin;
    }

    public void setClassbegin(String classbegin) {
        this.classbegin = classbegin;
    }

    public String getClasstime() {
        return classtime;
    }

    public void setClasstime(String classtime) {
        this.classtime = classtime;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}