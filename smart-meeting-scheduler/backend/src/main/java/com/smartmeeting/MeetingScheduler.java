import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MeetingScheduler {
    public static List<LocalTime> findBestMeetingSlots(List<String> availabilityViews, int duration) {
        List<LocalTime> bestSlots = new ArrayList<>();
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(18, 0);
        LocalTime current = startTime;

        while (current.isBefore(endTime)) {
            boolean slotAvailable = availabilityViews.stream().allMatch(view -> view.charAt(current.getHour() - 9) == '1');
            if (slotAvailable) {
                bestSlots.add(current);
            }
            current = current.plusMinutes(duration);
        }
        return bestSlots;
    }
}