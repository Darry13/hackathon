const { TeamsActivityHandler } = require('botbuilder');
const { getAvailableSlots } = require('./scheduler');

class MeetingBot extends TeamsActivityHandler {
    async onMessage(context, next) {
        const text = context.activity.text.toLowerCase();

        if (text.includes("schedule meeting")) {
            const bestSlots = await getAvailableSlots(["alice@company.com", "bob@company.com"]);
            await context.sendActivity(`Available slots: ${bestSlots.join(", ")}`);
        }

        await next();
    }
}

module.exports.MeetingBot = MeetingBot;