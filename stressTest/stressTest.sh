#!/bin/bash

# Target URL to stress test
target_url="http://127.0.0.1:51380/products"

# Number of requests to make
total_requests=10000

# Number of concurrent requests
concurrent_requests=100

# Function to make a single request
make_request() {
    curl -s "$target_url" -o /dev/null -w "%{http_code}\n"
}

# Run stress test
for ((i = 1; i <= total_requests; i++)); do
    make_request &

    # Control the number of concurrent requests
    if ((i % concurrent_requests == 0)); then
        wait
    fi
done

# Wait for remaining background jobs to finish
wait
