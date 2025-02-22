import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MeetingController {
    private final GraphApiService graphApiService;

    public MeetingController(GraphApiService graphApiService) {
        this.graphApiService = graphApiService;
    }

    @PostMapping("/schedule")
    public List<String> getMeetingSlots(@RequestBody List<String> attendees) {
        String availabilityData = graphApiService.getAvailability("your-access-token", attendees.toArray(new String[0]));
        return List.of(availabilityData);
    }
}