package week4.role;

import week3.policy.Policy;
import week3.policy.StaffPolicy;

public class Staff extends Role {
    private int studentId;

    public Staff(String name, String major, int cohort, String part, int studentId){
        super(name, major, cohort, part);
        this.studentId = studentId;
    }

    @Override
    public boolean isSubmittable() {
        return false;
    }

    @Override
    public Policy getPolicy() {
        return new StaffPolicy(); // claude의 도움을 받음
    }

    @Override
    public String getDetails() {
        return "🎭역할: 운영진\n"
                + "👤이름: " + getName() + " | 🎓전공: " + getMajor()
                + " | 📌기수: " + getCohort() + " | 🖥파트: " + getPart() + "\n"
                + "⭐직책: " + studentId;
    }
}
