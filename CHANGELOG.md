# switch-tex-style

## Unreleased
- usage またはヘルプメッセージ。
- babashka の aliases や tasks などがまだわかっていない。
- dir を引数にとるよりはシェルを信頼して _*.tex の方がいいんじゃね？
  hajimeni.tex とsample.tex が毎回 git に引っ掛かるなどして面倒くさいぞ。
  -> .gitignore に足しとけばいいか。

## 0.3.1 - 2023-10-01
- プロジェクト名 switch-tex-style に変更。
- added bump-version.sh

## 0.3.0 - 2023-10-01
全角半角の境界でスペースを入れるかどうかを判定する。
- --no-spaces
- --with-space
- added resources/_preface.tex from 2023-python/tex.

## 0.2.2 - 2023-09-30
- added Makefile
- fix DEST in Makefile

## 0.2.1 - 2023-09-30
- pmap の戻り値の lazySeq を実体化するのに doall

## 0.1.0 - 2023-09-30
- .gitignore
- git flow init
- prep ssh://git@git.hkim.jp
