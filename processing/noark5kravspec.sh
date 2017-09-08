#!/bin/sh

php noark5kravspec.php >noark5kravspec.sql
sqlite3 noark5kravspec.db <noark5kravspec.sql
