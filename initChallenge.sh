#!/bin/sh

mvn package docker:build
delay 10#
cd docker/
docker-compose up