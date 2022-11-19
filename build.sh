mvn package

if [ $? -ne 0 ]; then
    echo "Build failed"
    exit 1
fi

# check if file exists
if [ -f /home/emil/Desktop/dev_server/plugins/varo-1.0-SNAPSHOT.jar ]; then
    echo "Removing old plugin file..."
    rm /home/emil/Desktop/dev_server/plugins/varo-1.0-SNAPSHOT.jar
    if [ $? -eq 0 ]; then
        echo "Old plugin file removed!"
    else
        echo "Error while removing old plugin file!"
        exit 1
    fi
else
    echo "No old plugin file found!"
fi
# check args for "removeConfig"
if [ "$1" = "--removeConfig" ]; then
    if [ -d /home/emil/Desktop/dev_server/plugins/Varo ]; then
        echo "Removing old config folder..."
            rm -r /home/emil/Desktop/dev_server/plugins/Varo
            if [ $? -eq 0 ]; then
                echo "Old config folder removed!"
            else
                echo "Error while removing old config file!"
                exit 1
            fi
    else
        echo "No old config folder found!"
    fi
fi
# copy new plugin file
echo "Moving new plugin file..."
mv  /run/media/emil/HDD/PROJEKTE/Scripting/VaroPlugin/target/varo-1.0-SNAPSHOT.jar /home/emil/Desktop/dev_server/plugins
if [ $? -eq 0 ]; then
    echo "New plugin file moved!"
else
    echo "Error while moving new plugin file!"
    exit 1
fi
echo "Done!"

# check if directory exists


#java -Xmx16G -Xms512M -jar /home/emil/Desktop/dev_server/spigot-1.16.5.jar nogui