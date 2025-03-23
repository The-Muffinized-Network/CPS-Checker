# CPS-Checker
![image](https://github.com/user-attachments/assets/0cdbc99b-3b06-45cc-b35a-f3d7b1076570)

## How to Use

1. **Clone the Repository**
   ```sh
   git clone https://github.com/The-Muffinized-Network/CPS-Checker.git
   cd <repository-directory>
   ```

2. **Create a New Artifact**
    - Open the project in IntelliJ IDEA.
    - Navigate to `File` > `Project Structure` > `Artifacts`.
    - Click the `+` button to add a new artifact.
    - Select `JAR` > `From modules with dependencies`.
    - Choose the main module and click `OK`.

3. **Build the Project**
    - In IntelliJ IDEA, go to `Build` > `Build Artifacts`.
    - Select the newly created artifact and click `Build`.

4. **Install the Plugin**
    - Copy the generated JAR file from the `out/artifacts` directory.
    - Paste it into the `plugins` folder of your Minecraft server.

5. **Start the Server**
    - Start your Minecraft server to load the plugin.

6. **Enjoy!**
    - The CPS Checker plugin should now be active on your server.

## Configuration
- You can edit the configuration in the `config.yml` file.
- After editing the configuration, you need to restart the server or execute the command `/cpschecker reload` to apply the changes.
