const { BotFrameworkAdapter } = require('botbuilder');
const { TeamsActivityHandler } = require('botbuilder');

class MeetingBot extends TeamsActivityHandler {
    constructor() {
        super();
        this.onMessage(async (context, next) => {
            await context.sendActivity('Hello! I can help schedule meetings.');
            await next();
        });
    }
}

module.exports.MeetingBot = MeetingBot;