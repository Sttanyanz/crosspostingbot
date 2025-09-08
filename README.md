# Crossposting Bot

Telegram bot that can forward posts to other Telegram channels and VKontakte groups.

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Sttanyanz/crosspostingbot.git
   cd crosspostingbot

2. **Create a Telegram Bot:**

   Send the message to https://telegram.me/BotFather and follow their instructions. You'll get a link to your bot and its API token.

3. **Forwarding to Telegram Channels:**

   Add your bot as an administrator to your Telegram channel and give him rights to manage messages.

4. **Forwarding to VK Groups:**

   Go to the page of your vk group to which you want to forward posts. Сreate an Access Key and mark permission to the community wall.

6. **Edit application.yaml:**

   Edit crosspostingbot/src/main/resources/application.yaml. Add information about API token of your bot, access key of your VK group and about IDs of your groups and channels.

7. **Compile:**

    ```bash
   mvn clean package
8. **Launch the bot:**
    ```bash
   java -jar target/crosspostingbot-0.0.1-SNAPSHOT.jar
   ```

## Usage

Once the application is launched, the bot will forward posts it receives from messages to the channels and groups specified in application.yaml
