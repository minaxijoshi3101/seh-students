#!/bin/bash

#stop the existing application
echo "Stopping existing application..."
PID=$(pgrep -f seh-students.jar)
if [ -n "$PID" ]; then
    kill -9 $PID
fi

#Copy jar file to deployment folder
echo "Copying new jar file to deployment folder..."
cp seh-students.jar /prodlib/SEH/deployments/backend-app/

#Start the application
echo "Starting the application..."
cd /prodlib/SEH/deployments/backend-app/
nohup java -jar seh-students.jar > seh-students.log 2>&1 &
echo "Application started successfully."