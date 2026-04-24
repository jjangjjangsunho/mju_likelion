package week4.policy;

public class LionSubmissionPolicy implements SubmissionPolicy {
    @Override
    public boolean isSubmittable() {
            return true;
    } // Lion은 true 반환
}
