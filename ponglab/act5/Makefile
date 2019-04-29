JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Block.java \
	Collidable.java \
	Locatable.java \
	Ball.java \
	BlinkyBall.java \
	Paddle.java \
	Pong.java \
	Score.java \
	Wall.java \
	TheGame.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
