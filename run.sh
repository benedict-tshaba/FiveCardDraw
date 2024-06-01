#!/usr/bin/bash

mvn clean package
java -jar ./target/five-card-1.0-SNAPSHOT.jar

