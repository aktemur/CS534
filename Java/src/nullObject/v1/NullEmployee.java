package nullObject.v1;

public class NullEmployee implements IEmployee {
    @Override
    public boolean isTimeToPay() {
        return false;
    }

    @Override
    public void pay() {
        // nothing
    }
}
