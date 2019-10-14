import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConferenceRoom conferenceRoom = new ConferenceRoom();
        conferenceRoom.addEvent(new Event("2019-10-15 10:00", "2019-10-15 11:00", "First event"));
        conferenceRoom.addEvent(new Event("2019-10-15 11:30", "2019-10-15 13:00", "Second event"));
        conferenceRoom.addEvent(new Event("2019-10-15 15:00", "2019-10-15 17:00", "Third event"));

        Scanner in = new Scanner(System.in);

        System.out.print("Input event's name: ");
        String eventName = in.nextLine();

        System.out.print("Input event's begin date and time: ");
        String eventBeginTime = in.nextLine();

        System.out.print("Input event's end date and time: ");
        String eventEndTime = in.nextLine();

        conferenceRoom.addEvent(new Event(eventBeginTime, eventEndTime, eventName));
    }
}
