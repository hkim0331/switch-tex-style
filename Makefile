APP=switch_tex_styles.clj
DEST=${HOME}/teaching/2023-python/tex/bin

.PHONY: all install clean install-bin

all: install install-bin

install:
	cp bb/${APP} ${DEST}/${APP}
	chmod +x ${DEST}/${APP}

install-bin:
	cp bb/${APP} ~/bin/switch-tex-styles
	chmod +x ~/bin/switch-tex-styles

clean:
	${RM} *~
