import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class GraphApiService {
    private final CalendarService calendarService;
    private final RestTemplate restTemplate = new RestTemplate();

    public GraphApiService(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    public String createMeeting(List<String> attendees, String startTime, String endTime) {
        String accessToken = calendarService.getAccessToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{ "subject": "Team Meeting", "start": {"dateTime": "" + startTime + "", "timeZone": "UTC"},"
                + ""end": {"dateTime": "" + endTime + "", "timeZone": "UTC"},"
                + ""attendees": [" + String.join(", ", attendees) + "] }";

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.exchange(
            "https://graph.microsoft.com/v1.0/me/events",
            HttpMethod.POST, request, String.class
        );

        return response.getBody();
    }
}