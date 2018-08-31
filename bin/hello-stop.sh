#!/usr/bin/env bash

cd `dirname $0`
#lsof -i:8888 | grep java | awk '{print $2}' | xargs kill -9
ps -ef | grep kafka-sender | grep java | awk '{print $2}' | xargs kill -9

