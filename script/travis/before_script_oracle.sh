#!/bin/bash -e
# Sets up environment for p6psy backend Oracle at travis-ci.org
#
# Copyright (c) 2013 Peter Butkovic <butkovic@gmail.com>
#

# for some reason the file is not found any more here => creating user in install scirpt
# Load Oracle environment variables so that we could run `sqlplus`.
. /usr/lib/oracle/xe/app/oracle/product/10.2.0/server/bin/oracle_env.sh

# create user for testing
echo "CREATE USER travis IDENTIFIED BY travis;" | \
sqlplus -S -L sys/admin AS SYSDBA

echo "grant connect, resource to travis;" | \
sqlplus -S -L sys/admin AS SYSDBA

echo "grant create session, alter any procedure to travis;" | \
sqlplus -S -L sys/admin AS SYSDBA

