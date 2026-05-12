package week5.policy;

public class StaffPolicy implements Policy {
    @Override
    public boolean isSubmittable(){
        return false;
    } // Staff는 false 반환
}
