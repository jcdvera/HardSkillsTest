#!/bin/bash

mkdir wiremock && cd wiremock
wget https://repo1.maven.org/maven2/com/github/tomakehurst/wiremock-jre8-standalone/2.27.2/wiremock-jre8-standalone-2.27.2.jar
mkdir mappings
cp ../src/main/resources/mapping.json mappings/.
sudo chmod 777 ./wiremock-jre8-standalone-2.27.2.jar
java -jar wiremock-jre8-standalone-2.27.2.jar --port 8081 &

