import com.rev.dao.Dao;
import com.rev.dao.DaoImpl;
import com.rev.pojos.Person;

import java.util.List;

public class Main {
    public static void main(final String[] args) throws Exception {
        Dao dao = new DaoImpl();

//        Person p = new Person("asdf", "Qweerty");
//        dao.createPerson(p);

//        Person p = dao.getPersonById(1);
//        System.out.println(p);

        List<Person> people = dao.getAllPeople();
        for (Person p : people) {
            System.out.println(p);
        }

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