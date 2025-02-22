import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MeetingScheduler {
    private final GraphApiService graphApiService;

    public MeetingScheduler(GraphApiService graphApiService) {
        this.graphApiService = graphApiService;
    }

    public String scheduleMeeting(List<String> attendees, String startTime, String endTime) {
        return graphApiService.createMeeting(attendees, startTime, endTime);
    }
}