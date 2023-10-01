APP=switch_tex_style.clj
DEST=${HOME}/teaching/2023-python/tex/bin

.PHONY: all install clean

all: install

install:
	cp bb/${APP} ${DEST}/${APP}
	chmod +x ${DEST}/${APP}

clean:
	${RM} *~
