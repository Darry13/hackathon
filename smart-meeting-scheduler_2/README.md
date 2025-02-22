# Smart Meeting Scheduler
This project automates meeting scheduling using Microsoft Teams and Outlook Calendar.

## Components
- **Backend (Spring Boot)**: Handles meeting scheduling using Microsoft Graph API.
- **Bot (Node.js)**: A Teams bot to interact with users.
- **Teams App**: The app that integrates the bot.
- **Deployment**: Scripts to deploy to Azure.

## Setup
1. Configure API keys in `.env` and `application.yml`.
2. Run `mvn clean install` for backend.
3. Start bot using `npm install && node src/bot.js`.
4. Deploy to Azure using `./deployment/azure-deploy.sh`.