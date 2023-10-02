APP=switch_tex_styles.clj
GAKU=${HOME}/teaching/2023-python/tex/bin

.PHONY: all install clean install-bin

all: install install-gaku

install-gaku:
	cp bb/${APP} ${GAKU}/switch-tex-styles
	chmod +x ${GAKU}/switch-tex-styles

install:
	cp bb/${APP} ~/bin/switch-tex-styles
	chmod +x ~/bin/switch-tex-styles

clean:
	${RM} *~
