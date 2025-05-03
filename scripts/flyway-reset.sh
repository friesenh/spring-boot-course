#!/bin/bash

# Load environment variables from .env
set -a
source "$(dirname "$0")/../.env"
set +a

echo "⚠️  This will clean and reapply all migrations from scratch."
read -p "Are you sure? [y/N]: " confirm

if [[ "$confirm" =~ ^[Yy]$ ]]; then
  mvn flyway:clean flyway:migrate
else
  echo "Aborted."
fi
