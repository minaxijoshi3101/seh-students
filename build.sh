#~/bin/bash
set -e
ART_URL="https://trialcpnyac.jfrog.io/artifactory"
REPO="SEH"
ART_USER="amitajoshi1992@gmail.com"
ART_API_KEY=$1

mvn clean install -DskipTests=true

zip -r deployment-manifest.zip deployment-manifest/

app_name=$(xmllint --xpath "/*[local-name()='project']/*[local-name()='artifactId']/text()" pom.xml)

version=$(xmllint --xpath "/*[local-name()='project']/*[local-name()='version']/text()" pom.xml)

JAR_FILE="target/${app_name}-${version}.jar"

echo "app_name: ${app_name}"
echo "version: ${version}"
echo "JAR_FILE: ${JAR_FILE}"

#upload jar
curl -u "${ART_USER}:${ART_API_KEY}" -T ${JAR_FILE} "https://trialcpnyac.jfrog.io/artifactory/SEH/${app_name}/release/${version}/${app_name}-${version}.jar"

#upload deployment manifest
curl -u "${ART_USER}:${ART_API_KEY}" -T deployment-manifest.zip "https://trialcpnyac.jfrog.io/artifactory/SEH/${app_name}/release/${version}/deployment-manifest.zip"

echo "successfully uploaded artifacts to artifactory"