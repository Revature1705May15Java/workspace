import com.rev.dao.Dao;
import com.rev.dao.DaoImpl;
import com.rev.pojos.Person;

import java.util.List;

public class Main {
    public static void main(final String[] args) throws Exception {
        Dao dao = new DaoImpl();

//        Person p = new Person("asdf", "Marquez");
//        dao.createPerson(p);

//        Person p = dao.getPersonById(1);
//        System.out.println(p);
        Person t = dao.getPersonByRegex("FIRST_NAME", "as%");
        System.out.println(t);

//        List<Person> people = dao.getAllPeople();
//        for (Person q : people) {
//            System.out.println(q);
//        }

//        final Session session = ConnectionUtil.getSession();
//
//        try {
//            System.out.println("querying all the managed entities...");
//            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//        } finally {
//            session.close();
//        }
    }
}