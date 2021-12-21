package hellojpa;

public class TestTeam {

    private Long id;
    private String testTeamName;

    @Override
    public String toString() {
        return "TestTeam{" +
                "id=" + id +
                ", testTeamName='" + testTeamName + '\'' +
                '}';
    }

    public TestTeam() {
    }

    public TestTeam(Long id, String testTeamName) {
        this.id = id;
        this.testTeamName = testTeamName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestTeamName() {
        return testTeamName;
    }

    public void setTestTeamName(String testTeamName) {
        this.testTeamName = testTeamName;
    }
}
