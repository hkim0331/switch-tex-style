# switch-tex-style

## Unreleased
- BUG: バックスラッシュ始まりの単語の後ろのスペース
  '\item 小さなものを' が '\item小さなものを' にしてしまう。
- two pass で。
  switch-tex-style 後にエラーになったものをリストする手では？


## 0.3.2 - 2023-10-02
### Changed
- インストール先でのスクリプト名は switch-tex-styles とする。
- プロジェクト名を swith-tex-styles に変更（複数形）。
- make install-bin
  スクリプトファイル `switch_tex_styles.clj` を
  拡張子 .clj をとったケバブスタイルの switch-tex-styles で ~/bin にインストール。
- make install は ~/bin に、学術図書フォルダへは make install-gaku とする。
- (usage) を定義。

## 0.3.1 - 2023-10-01
- プロジェクト名 switch-tex-style に変更。
- スクリプト名は `switch_tex_style.clj` でいいか？
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
