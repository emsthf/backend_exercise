package hellojpa;

public class TestUser {

    private Long id;
    private String TestUserName;
    private TestTeam testTeam;   // 컬럼에 객체를 담아버림. 테이블 안에 테이블을 담아버린 것

    @Override
    public String toString() {
        return "TestUser{" +
                "id=" + id +
                ", TestUserName='" + TestUserName + '\'' +
                ", testTeam=" + testTeam +
                '}';
    }

    public TestUser(Long id, String testUserName, TestTeam testTeam) {
        this.id = id;
        TestUserName = testUserName;
        this.testTeam = testTeam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestUserName() {
        return TestUserName;
    }

    public void setTestUserName(String testUserName) {
        TestUserName = testUserName;
    }

    public TestTeam getTestTeam() {
        return testTeam;
    }

    public void setTestTeam(TestTeam testTeam) {
        this.testTeam = testTeam;
    }
}
