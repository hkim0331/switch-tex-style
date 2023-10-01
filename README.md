# switch-tex-style

tex スタイルスイッチャー。
tex ファイルの句読点、全角半角の境界にスペースを調整する。

* --gaku, -g で学術図書スタイルに。
* --my, -m hkimura スタイルに。

## https://qiita.com/richmikan@github/items/7c0f0eb03e5affd645a3

- 全角文字の正規表現 [^\x01-\x7E]

- LANG=ja_JP.UTF8 のもとで、

```shell
$ echo 'MSX ＭＳＸ２　ＭＳＸ２＋' | sed 's/[[:alnum:]]/*/g'
*** ****　****＋
$ echo 'MSX ＭＳＸ２　ＭＳＸ２＋' | awk '{gsub(/[[:alnum:]]/,"*");print}'
*** ****　****＋
$

$ echo 'MSX ＭＳＸ２　ＭＳＸ２＋' | sed 's/[[:blank:]]/*/g'
MSX*ＭＳＸ２*ＭＳＸ２＋
$ echo 'MSX ＭＳＸ２　ＭＳＸ２＋' | awk '{gsub(/[[:alnum:]]/,"*");print}'
MSX*ＭＳＸ２*ＭＳＸ２＋
$
```
