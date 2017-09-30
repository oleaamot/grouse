#!/bin/sh

# php noark5kravspec.php >noark5kravspec.sql
mysql grouse -uroot -ppassword -hlocalhost <noark5kravspec.sql
