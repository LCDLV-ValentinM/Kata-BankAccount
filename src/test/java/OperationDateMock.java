import java.time.LocalDateTime;

public final class OperationDateMock implements CustomDate {
    private final LocalDateTime fixedDateTime;

    OperationDateMock(LocalDateTime fixedDateTime) {
        this.fixedDateTime = fixedDateTime;
    }

    @Override
    public String now() {
        return fixedDateTime.toString();
    }
}
