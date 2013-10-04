#!/bin/bash

if [[ $UID -ne 0 ]]; then
	echo "$0 must be run as root"
	exit 1
fi

cp target/taskworker-core.jar /usr/share/java
cp bin/taskworker-server bin/taskworker-client /usr/bin

if [[ ! -f '/etc/taskworker/config.properties' ]]; then
	sudo mkdir -p /etc/taskworker
	cp src/main/resources/config.properties /etc/taskworker/config.properties
fi
