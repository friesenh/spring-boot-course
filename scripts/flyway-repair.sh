#!/bin/bash

# Load environment variables from .env
set -a
source "$(dirname "$0")/../.env"
set +a

# Run Flyway repair via Maven using env-backed config from pom.xml
mvn flyway:repair
