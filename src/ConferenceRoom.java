import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConferenceRoom {
    private final List<Event> eventList = new ArrayList<>();

    public void addEvent(Event event) {
        if (isAvailable(event)) {
            eventList.add(event);
            System.out.println(String.format("%s successfully added.", event.getName()));
        } else {
            System.out.println("Can't add new event. Please peek another interval.");
        }
    }

    private boolean isAvailable(Event event) {
        final LocalDateTime begin = event.getBeginDateTime();
        final LocalDateTime end = event.getEndDateTime();

        if (begin.isAfter(end)) {
            return false;
        }
        return eventList.stream().noneMatch(e -> isInside(e, begin, end));
    }

    private boolean isInside(Event event, LocalDateTime begin, LocalDateTime end) {
        final LocalDateTime beginDateTime = event.getBeginDateTime();
        final LocalDateTime endDateTime = event.getEndDateTime();
        return ((beginDateTime.isAfter(begin) || beginDateTime.isEqual(begin)) &&
                (beginDateTime.isBefore(end) || beginDateTime.isEqual(end)))
                ||
                ((endDateTime.isAfter(begin) || endDateTime.isEqual(begin)) &&
                        (endDateTime.isBefore(end) || endDateTime.isEqual(end)));
    }
}
