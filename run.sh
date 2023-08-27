#!/bin/bash
pwd

mvn spring-boot:run > LOG.txt &
echo "Running process on port : 8080" &
sleep 2
start http://127.0.0.1:8080/birds 

$ SHELL