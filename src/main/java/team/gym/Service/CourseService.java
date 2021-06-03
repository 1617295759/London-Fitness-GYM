package team.gym.Service;

import team.gym.Beans.Course;
import java.util.List;

/**
 * realize the functions in regard to Courses
 */
public interface CourseService {

    /** After members have pay for course, Add new course information
     *
     * @param course the course information to be added
     */
    void addNewCourse(Course course);

    /** Query the courses that customer arrange to attend
     *
     * @param account the Customer's account
     * @return the courses that customer arrange to take part in
     */
    List<Course> getCustomerTodoCourse(String account);

    /** Query the courses that customer had attended
     *
     * @param account the Customer's account
     * @return the courses that customer had attended
     */
    List<Course> getCustomerOverCourse(String account);

    /** Query the courses that is unconfirmed in regard to the customer
     *
     * @param account the Customer's account
     * @return the courses that is unconfirmed
     */
    List<Course> getCustomerUnconfirmedCourse(String account);

    /** Query the courses that is unconfirmed in regard to the trainer
     *
     * @param account the Trainer's account
     * @return the courses that is unconfirmed
     */
    List<Course> getTrainerUnconfirmedCourse(String account);

    /**Query the courses that trainer arrange to attend
     *
     * @param account the Trainer's account
     * @return the courses that trainer arrange to take part in
     */
    List<Course> getTrainerTodoCourse(String account);

    /**Query the courses that trainer had attended
     *
     * @param account the Trainer's account
     * @return  the courses that trainer missed to take part in
     */
    List<Course> getTrainerOverCourse(String account);

    /** delete a specific course
     *
     * @param course the course to be deleted
     * @return operation status
     */
    int deleteCourse(Course course);

    /** change given course info field to new info
     *
     * @param course the course of course to be modified
     * @param field what field to be modified
     * @param newValue new value
     * @return statues 1-finished successfully 0-failed
     */
    int modifyCourseInfo(Course course, String field, String newValue);

    void reload();
}