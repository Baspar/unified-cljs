#!/bin/bash
echo "-> $TARGET"
if [[ $TARGET == "front" ]]
then
    echo "Testing Frontend"
    lein test-front
else
    echo "Testing Backend"
    lein test-back
fi
