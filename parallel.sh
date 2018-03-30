#!/bin/bash
#ENVIRONMENT=$1
#BROWSER=$2

BROWSER=$1




#./gradlew runScenarios -Dgeb.browser=${BROWSER}  -Dgeb.environmemt=${ENVIRONMENT}
#./gradlew runFeatures -Dgeb.browser=${BROWSER}  -Dgeb.environmemt=${ENVIRONMENT}
./gradlew runFeatures -Dgeb.browser=${BROWSER}
