#!/bin/bash
set -ux
GIT_NAME=$(git --no-pager show -s --format='%an' $GIT_COMMIT)
if [ "$GIT_NAME" != "Jenkins Automation Server" ]; then
        git branch --set-upstream-to=origin/master master
  sbt "release with-defaults"
fi
