package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("hello");
        EntityManager em = ef.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Team myTeam = em.find(Team.class, 1L);
            Member user3 = new Member("jobs", myTeam);

            em.persist(user3);

//            Team findTeam = em.find(Team.class, 1L);
//            // findTeam에 Team의 1번을 찾아서 저장. Long 타입이기 때문에 1에 L을 붙여
//            member1.setTeamId(findTeam.getId());

//            Product product1 = new Product(
//                    "iPhone",
//                    6,
//                    "one more thing",
//                    999,
//                    0,
//                    3
//            );

            //Create:
//            Member member = new Member();
//            member.setId(1);
//            member.setName("test");
//            Member saveMember = em.merge(member);

            //Update:
//            Member findMember = em.find(Member.class, 1);
//            findMember.setName("Beat1105");

//            em.persist(member1);
//            em.persist(team2);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {

            em.close();
        }



        ef.close();
    }
}
