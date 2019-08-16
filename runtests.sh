#!/bin/bash
#ficheiro que corre todos os testes automaticamente no pc
 
JAVADIR=/usr/share/java
PROJDIR=/home/oops/project
TESTDIR=/home/oops/project/tests-ef-eval201512011200
 
set -e
 
echo "Cleaning and compiling..."
cd "$PROJDIR"
make clean
make
 
#corre os testes:
 
tput sgr0
echo -e "\e[34m"
echo "Running tests"
tput sgr0
 
mkdir -p "$TESTDIR/out"
cd "$TESTDIR"
 
for i in *.in;
        do
                TEST=${i%.in}
                cd "$PROJDIR";
                echo "$TEST";
                if [ -e "$TESTDIR/$TEST.import" ]
                        then
                                java -Dimport="$TESTDIR/$TEST.import" -cp "$JAVADIR/po-uilib.jar:$JAVADIR/edt-support.jar:$PROJDIR/edt-core/edt-core.jar:$PROJDIR/edt-textui/edt-textui.jar"  -Din="$TESTDIR/$TEST.in" -Dout="$TESTDIR/out/$TEST.out" edt.textui.TextEditor
                        else
                                java -cp "$JAVADIR/po-uilib.jar:$JAVADIR/edt-support.jar:$PROJDIR/edt-core/edt-core.jar:$PROJDIR/edt-textui/edt-textui.jar" -Din="$TESTDIR/$TEST.in" -Dout="$TESTDIR/out/$TEST.out" edt.textui.TextEditor
                fi
        done
 
#faz os diffs:
tput sgr0
echo -e "\e[34m"
echo "Diffing stuff"
tput sgr0
cd "$TESTDIR"
for i in *.in;
        do
                TEST=${i%.in}
                tput sgr0
                echo -ne "\e[34m"
                echo "$TEST"
                tput sgr0
                diff "./expected/$TEST.out" "./out/$TEST.out" | colordiff
                tput sgr0
        done
 
echo ""
echo "All tests done."
 
tput sgr0