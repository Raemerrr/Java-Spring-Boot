package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            Member member = new Member(1L, "Hello");

            em.persist(member);

            Member a = em.find(Member.class, 1L);
            Member b = em.find(Member.class, 1L);
            // 주소값을 공유하지만 c를 변경했을때 b에도 반영이 될까?
            Member c = a;
            // 주
            Member d = new Member(a.getId(), a.getName());


            System.out.println(a == b);
            System.out.println(b == c);
            System.out.println(a == d);

            a.setName("Raemin.Kang");

            System.out.println(a == b);

            c.setName("Hello");
            d.setName("HHHHH");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
