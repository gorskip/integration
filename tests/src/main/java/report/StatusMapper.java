package report;

public class StatusMapper {

    public Status map(int status) {
        switch(status) {
            case -1: return Status.CREATED;
            case 1: return Status.SUCCESS;
            case 2: return Status.FAILURE;
            case 3: return Status.SKIP;
            case 4: return Status.SUCCESS_PERCENTAGE_FAILURE;
            case 16: return Status.STARTED;
        }
        throw new IllegalArgumentException("Cannot map status with value: " + status);
    }
}
