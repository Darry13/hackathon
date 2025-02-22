const axios = require('axios');

async function scheduleMeeting(attendees, startTime, endTime) {
    const response = await axios.post('http://localhost:8080/api/meetings/schedule', {
        attendees, startTime, endTime
    });
    return response.data;
}

module.exports = { scheduleMeeting };