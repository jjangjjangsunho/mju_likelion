package week4.policy;

public class StaffSubmissionPolicy implements SubmissionPolicy {
    @Override
    public boolean isSubmittable(){
        return false;
    } // Staff는 false 반환
}
