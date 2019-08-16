JAVADIR=/usr/share/java
PROJDIR=/home/oops/project
CLASSPATH=$JAVADIR/po-uilib.jar:$JAVADIR/edt-support.jar:$PROJDIR/edt-textui/edt-textui.jar:$PROJDIR/edt-core/edt-core.jar
echo $CLASSPATH

java -Dimport=testes/A-005-002-M-ok.import -Din=testes/A-005-002-M-ok.in -Dout=testes/myout.out -cp $CLASSPATH edt.textui.TextEditor