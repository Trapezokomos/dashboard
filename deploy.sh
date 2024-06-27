#!/bin/bash

ENVIRONMENT=$1

if [ "$ENVIRONMENT" == "staging" ]; then
  echo "Deploying to staging..."
  # Add your staging deployment commands here
elif [ "$ENVIRONMENT" == "production" ]; then
  echo "Deploying to production..."
  # Add your production deployment commands here
else
  echo "Unknown environment: $ENVIRONMENT"
  exit 1
fi
