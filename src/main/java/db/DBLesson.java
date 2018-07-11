package db;

import models.Course;
import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class DBLesson {

    private static Session session;

    public static Course getCourseFromLesson(Lesson lesson){
        session = HibernateUtil.getSessionFactory().openSession();
        Course course = null;

        try{
            Criteria cr = session.createCriteria(Course.class);
            cr.createAlias("lessons", "lesson");
            cr.add(Restrictions.eq("lesson.id", lesson.getId()));
            course = (Course) cr.uniqueResult();
        }
        catch (HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return course;
    }
}
