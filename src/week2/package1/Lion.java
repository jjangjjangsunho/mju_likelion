package week2.package1;

public class Lion {
    // 인스턴스 변수 선언
    public String name;
    String major;
    private int cohort;

    // 생성자
    public Lion() {}

    // Step1에서 사용 X
    public Lion(String name, String major, int cohort) {
        this.name = name;
        this.major = major;
        this.cohort = cohort;
    }

    // Getter // Step1에서 사용 X
    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getCohort() {
        return cohort;
    }

    // Setter // Step1에서 사용 X
    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setCohort(int cohort) {
        this.cohort = cohort;
    }
}
