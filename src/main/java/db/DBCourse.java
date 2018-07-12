package db;

import models.Course;
import models.Instructor;
import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBCourse {

    private static Session session;

    public static List<Lesson> getLessonsForCourse(Course course){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Lesson> lessons = null;

        try{
            Criteria cr = session.createCriteria(Lesson.class);
            cr.add(Restrictions.eq("course.id", course.getId()));
            lessons = cr.list();
        }
        catch (HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return lessons;
    }

    public static List<Student> getStudents(Course course){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Student> students = null;

        try{
            Criteria cr = session.createCriteria(Student.class);
            cr.add(Restrictions.eq("course.id", course.getId()));
            students = cr.list();
        }
        catch (HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return students;
    }


}
