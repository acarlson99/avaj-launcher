#!/bin/sh

find . -name *.java > sources.txt
javac -d out/ -sourcepath src/ @sources.txt
