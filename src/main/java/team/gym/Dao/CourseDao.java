package team.gym.Dao;

import org.springframework.stereotype.Repository;
import team.gym.Beans.Course;

import java.util.List;


/**
 * operate the data Persistence in regard to Course
 */
public interface CourseDao {
    /**String customerAccount,String trainerAccount,String startTime,String endTime,
     String category,double price
     These parameters are needed to be involved
     *
     * @param courses the courses information to be added
     * @return whether the operation is success
     */
    int addNewCourse(Course courses);

    /** get the Course object by the courseID
     *
     * @param courseId referenced courseID
     * @return the course information stored in Persistence layer
     */
    Course selByCourseId(int courseId);


    /**deleted specific course
     *
     * @param course the course information to be deleted
     * @return operation status
     */
    int delCourse(Course course);

    /** modify the specific field in the Course Object and save it in Persistence layer
     *
     * @param course the course information to be modified
     * @param field the specific field that you want to modify
     * @param newValue  new value
     * @return operation status
     */
    int modifyCourse(Course course, String field, String newValue);

    /** get all courses of a Customer by customer account
     *
     * @param account the customer account
     * @return the list of all courses of the customer
     */
    List<Course> getCustomerCourses(String account);

    /** get all courses of a Trainer by trainer account
     *
     * @param account the trainer account
     * @return the list of all courses of the trainer
     */
    List<Course> getTrainerCourses(String account);
}