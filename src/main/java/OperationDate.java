import java.time.LocalDateTime;

public class OperationDate implements CustomDate {

    @Override
    public String now() {
        return LocalDateTime.now().toString();
    }
}
