import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConferenceRoom {
    private final List<Event> eventList = new ArrayList<>();

    public void addEvent(Event event) {
        if (isAvailable(event.getBeginDateTime(), event.getEndDateTime())) {
            eventList.add(event);
            System.out.println(String.format("%s successfully added.", event.getName()));
        } else {
            System.out.println("Can't add new event. Please peek another interval.");
        }
    }

    private boolean isAvailable(LocalDateTime begin, LocalDateTime end) {
        if (begin.isAfter(end)) {
            return false;
        }
        return eventList.stream().noneMatch(event -> isInside(event, begin, end));
    }

    private boolean isInside(Event event, LocalDateTime begin, LocalDateTime end) {
        LocalDateTime beginDateTime = event.getBeginDateTime();
        LocalDateTime endDateTime = event.getEndDateTime();
        return ((beginDateTime.isAfter(begin) || beginDateTime.isEqual(begin)) &&
                (beginDateTime.isBefore(end) || beginDateTime.isEqual(end)))
                ||
                ((endDateTime.isAfter(begin) || endDateTime.isEqual(begin)) &&
                        (endDateTime.isBefore(end) || endDateTime.isEqual(end)));
    }
}
