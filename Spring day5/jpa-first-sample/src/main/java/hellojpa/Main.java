package hellojpa;

public class Main {
    public static void main(String[] args) {
        TestTeam testTeam = new TestTeam(1L, "BackEnd");
        TestTeam testTeam1 = new TestTeam(2L, "FrontEnd");
        TestUser testUser = new TestUser(1L, "BusanFullStack", testTeam);
        TestUser testUser1 = new TestUser(2L, "Union", testTeam1);
        System.out.println("testUser = " + testUser);
        System.out.println("testUser1 = " + testUser1);
    }
}
