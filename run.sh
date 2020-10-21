rm -f src/*.class
rm -f myJarFile.jar;
javac src/Main.java
java src/Main
# rm -f src/*.class #remove after testing
#creating jar file
jar -cvf myJarFile.jar src/Main.class
#Execute the java file
# java -cp MyJarFile.jar src/Main