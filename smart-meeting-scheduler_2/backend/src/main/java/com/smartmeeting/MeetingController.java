import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/meetings")
public class MeetingController {
    private final MeetingScheduler meetingScheduler;

    public MeetingController(MeetingScheduler meetingScheduler) {
        this.meetingScheduler = meetingScheduler;
    }

    @PostMapping("/schedule")
    public String scheduleMeeting(@RequestBody MeetingRequest request) {
        return meetingScheduler.scheduleMeeting(request.getAttendees(), request.getStartTime(), request.getEndTime());
    }
}

class MeetingRequest {
    private List<String> attendees;
    private String startTime;
    private String endTime;

    public List<String> getAttendees() { return attendees; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
}