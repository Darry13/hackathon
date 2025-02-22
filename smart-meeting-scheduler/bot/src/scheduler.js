const fetch = require('node-fetch');

async function getAvailableSlots(attendees) {
    const response = await fetch("https://graph.microsoft.com/v1.0/me/calendar/getSchedule", {
        method: "POST",
        headers: {
            Authorization: `Bearer YOUR_ACCESS_TOKEN`,
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            schedules: attendees,
            startTime: { dateTime: "2025-02-20T09:00:00", timeZone: "UTC" },
            endTime: { dateTime: "2025-02-20T18:00:00", timeZone: "UTC" },
            availabilityViewInterval: 30
        })
    });

    const data = await response.json();
    return data.value;
}

module.exports = { getAvailableSlots };