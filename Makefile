all: run

clean:
	rm -f out/Bluck.jar out/LCM.jar

out/Bluck.jar: out/parcs.jar src/Bluck.java src/Node.java
	@javac -cp out/parcs.jar src/Bluck.java src/Node.java
	@jar cf out/Bluck.jar -C src Bluck.class -C src Node.class
	@rm -f src/Bluck.class src/Node.class

out/LCM.jar: out/parcs.jar src/LCM.java src/Node.java
	@javac -cp out/parcs.jar src/LCM.java src/Node.java
	@jar cf out/LCM.jar -C src LCM.class -C src Node.class
	@rm -f src/LCM.class src/Node.class

build: out/Bluck.jar out/LCM.jar

run: out/Bluck.jar out/LCM.jar
	@cd out && java -cp 'parcs.jar:Bluck.jar' Bluck
