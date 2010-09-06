package uit.qass.model;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import uit.qass.core.search.searchAuthor;
import uit.qass.util.hibernate.HibernateUtil;

public class Test {

    public static void main(String[] args) {
        test5();
    }

    public static void test1() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        //get Publication with ID = 1
        Publication a = (Publication) session.load(Publication.class, 1);
        System.out.println(a.getTitle());
        for (int i = 0; i < a.getAuthors().size(); i++) {
            Author temp = (Author) a.getAuthors().get(i);
            System.out.println("Author -------------");
            System.out.println("Name: " + temp.getAuthor());
            System.out.println("--------------------------");
        }
        session.close();
    }

    public static void test2() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        // get author with name = Philip K. Chan
        Query q = session.createQuery("from Author au where au.author = :var");
        q.setString("var", "Philip K. Chan");
        List result = q.list();
        System.out.println("Number of Objects: " + result.size());
        for (int i = 0; i < result.size(); i++) {
            Author temp = (Author) result.get(i);
            Publication pubs = temp.getPublications();
            System.out.println("Publication -------------");
            System.out.println("ID: " + pubs.getId());
            System.out.println("Name: " + pubs.getTitle());
            System.out.println("--------------------------");
        }
        session.close();
    }

    public static void test3() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        //get Publication with ID = 1
        Publication a = (Publication) session.load(Publication.class, 344420);
        System.out.println(a.getTitle());
        System.out.println(a.getRefPubs().get(1).getTitle());
        for (int i = 0; i < a.getRefPubs().size(); i++) {
            Publication object = a.getRefPubs().get(i);
            System.out.println("ref: " + object.getTitle());
        }
        session.close();
    }

    public static void test4() {
        List rs = searchAuthor.searchAuthorByKey("Philip K");
        System.out.println(rs.size());
        for (int i = 0; i < rs.size(); i++) {
            String s = (String) rs.get(i);
            System.out.println(s);
        }
    }

    public static void test5() {
        List<Publication> pubs = searchAuthor.searchPubsByAuthorName("Philip K. Chan");
        for (int i = 0; i < pubs.size(); i++) {
            Publication pub = (Publication) pubs.get(i);
            System.out.println(pub.getTitle());
        }
    }
}