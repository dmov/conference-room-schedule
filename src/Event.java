import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event {
    private final LocalDateTime beginDateTime;
    private final LocalDateTime endDateTime;
    private final String name;

    public Event(String begin, String end, String name) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        this.beginDateTime = LocalDateTime.parse(begin, dateTimeFormatter);
        this.endDateTime = LocalDateTime.parse(end, dateTimeFormatter);
        this.name = name;
    }

    public LocalDateTime getBeginDateTime() {
        return beginDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public String getName() {
        return name;
    }
}
