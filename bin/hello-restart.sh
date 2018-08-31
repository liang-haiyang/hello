#!/usr/bin/env bash

cd `dirname $0`
echo 'stoping kafka-sender'
sh hello-stop.sh

echo 'starting kafka-sender'
sh hello.sh
