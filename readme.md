# motdmod

This is a basic Minecraft Forge 1.7.10 server side mod that sends MOTD messages on connection to the minecraft server. It is not required on the client at all.

# building

1. `./gradlew setupDecompWorkspace`
2. `./gradlew runServer`
3. `/stop`
4. Edit the server.properties file in your favorite text editor to allow offline mode (so that you can connect a client)
5. Create the motd.txt file using your favorite text editor. There is no text formatting currently, it will just print all of the lines in the file when you connect.
6. `./gradlew runServer`
7. Profit

# license

All my code is MIT. Beyond that, check out the /dist folder for more stuff from the upstream developers for the FML.