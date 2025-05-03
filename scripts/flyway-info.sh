#!/bin/bash

# Load environment variables from .env
set -a
source "$(dirname "$0")/../.env"
set +a

# Show Flyway migration info
mvn flyway:info
