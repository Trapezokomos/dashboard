#!/bin/sh
docker build -t dashboard-app-image .
docker compose up -d