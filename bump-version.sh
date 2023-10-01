#!/bin/sh
#
# origin: ${utils}/tools/src/bump-version.sh
#
# last update: 2023-09-23
#
# CAUSION:
# The POSIX standard regular expressions does not support back-references.
# Back-references are considered as an "extended" faciliy.
# This script, bump-version.sh, uses the extended function.
# So, gnu-sed on macOS.

if [ -z "$1" ]; then
    echo "usage: $0 <version>"
    exit 1
fi

if [ -x "${HOMEBREW_PREFIX}/bin/gsed" ]; then
    SED="${HOMEBREW_PREFIX}/bin/gsed -E"
else
    SED="/usr/bin/sed -E"
fi

# leiningen
#${SED} -i "s|(defproject \S+).*|\1 \"$1\"|" project.clj

# clj
${SED} -i "s|(def \^:private version).*|\1 \"$1\")|" bb/switch_tex_style.clj

# cljs
#${SED} -i "s|(def \^:private version).*|\1 \"$1\")|" src/main.cljs
