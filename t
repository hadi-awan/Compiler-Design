echo "----- Test $1"
java -classpath .:./AST TestHL Tests/$1.hl >Tests/$1.out
diff -b Tests/$1.out Tests/$1.expected
