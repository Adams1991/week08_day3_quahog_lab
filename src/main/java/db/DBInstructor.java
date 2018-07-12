package db;

import models.Course;
import models.Instructor;
import models.Lesson;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBInstructor {

    private static Session session;

    public static List<Lesson> getLessons(Instructor instructor){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Lesson> lessons = null;

        try{
            Criteria cr = session.createCriteria(Lesson.class);
            cr.add(Restrictions.eq("instructor.id", instructor.getId()));
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

}
