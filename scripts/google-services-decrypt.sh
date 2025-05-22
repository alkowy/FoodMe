#!/bin/bash

ENCRYPTED_FILE="scripts/google-services.json.enc"
OUTPUT_FILE="app/google-services.json"

# Check if encrypted file exists
if [ ! -f "$ENCRYPTED_FILE" ]; then
  echo "ERROR: Encrypted file '$ENCRYPTED_FILE' not found."
  exit 1
fi

# Prompt for password securely
echo -n "🔑 Enter password to decrypt: "
read -s PASSWORD
echo

# Create output directory if missing
mkdir -p "$(dirname "$OUTPUT_FILE")"

# Decrypt
echo "🔐 Decrypting $ENCRYPTED_FILE to $OUTPUT_FILE..."
openssl aes-256-cbc -d -in "$ENCRYPTED_FILE" -out "$OUTPUT_FILE" -k "$PASSWORD"

if [ $? -eq 0 ]; then
  echo "Decryption successful! File created at $OUTPUT_FILE"
else
  echo "ERROR: Decryption failed. Check your password."
  exit 1
fi
