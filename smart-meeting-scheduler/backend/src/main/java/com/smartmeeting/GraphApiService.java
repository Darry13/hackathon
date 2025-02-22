import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GraphApiService {
    private final String GRAPH_API_URL = "https://graph.microsoft.com/v1.0/me/calendar/getSchedule";
    private final RestTemplate restTemplate = new RestTemplate();

    public String getAvailability(String accessToken, String[] attendees) {
        String requestBody = "{ "schedules": ["" + String.join("", "", attendees) + ""],"
                + ""startTime": {"dateTime": "2025-02-20T09:00:00", "timeZone": "UTC"},"
                + ""endTime": {"dateTime": "2025-02-20T18:00:00", "timeZone": "UTC"},"
                + ""availabilityViewInterval": 30 }";

        return restTemplate.postForObject(GRAPH_API_URL, requestBody, String.class);
    }
}