import com.rev.dao.Dao;
import com.rev.dao.DaoImpl;
import com.rev.pojos.Person;

public class Main {
    public static void main(final String[] args) throws Exception {
        Person p = new Person(1, "Richard", "Marquez");

        Dao dao = new DaoImpl();
        dao.createPerson(p);

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