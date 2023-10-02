#!/usr/bin/env bb

(ns switch-tex-styles)

(require '[babashka.fs :as fs])
(require '[babashka.process :as ps])

(def ^:private version "0.3.2")

(defn usage
  []
  (println "switch-tex-styles, version" version)
  (println "usage: switch-tex-styles {--gaku|--my} dir")
  (println "ファイル dir/*.tex の句読点、全角半角間のスペースを調整する。")
  (println " --gaku ... 句読点は 「．，」を使い、全角半角間のスペースを削除。")
  (println " --my ..... 句読点は 「。、」を使い、全角半角間にスペースを入れる。"))

(defn tex-files
  "tex files in dir."
  [dir]
  (map fs/unixify (fs/glob dir "*.tex")))

(comment
  (tex-files "resources")
  :rcf)

(defn insert-space
  "半角全角、全角半角と続く場所にスペースを入れる。"
  [f]
  (ps/shell
   (str "gsed -E -i
         -e 's/([\\x01-\\x7E])([^\\x01-\\x7E])/\\1 \\2/g'
         -e 's/([^\\x01-\\x7E])([\\x01-\\x7E])/\\1 \\2/g'" f)))

(defn remove-spaces
  "半角 全角、全角 半角と切り替わる場所にある連続するスペースを取り除く。"
  [f]
  (ps/shell
   (str "gsed -E -i
           -e 's/([\\x01-\\x7E])\\s+([^\\x01-\\x7E])/\\1\\2/g'
           -e 's/([^\\x01-\\x7E])\\s+([\\x01-\\x7E])/\\1\\2/g'" f)))

(defn ->gaku
  "gaku style"
  [f]
  ;; (println "->gaku " f)
  (ps/shell
   (str "gsed -i -e 's/。/．/g' -e 's/、/，/g'" f)))

(defn ->my
  "normal `hkimura` style"
  [f]
  (ps/shell
   (str "gsed -i -e 's/．/。/g' -e 's/，/、/g'" f)))

(comment
  (->gaku "resources/_preface.tex")
  (->my "resources/_preface.tex")
  (remove-spaces "resources/_preface.tex")
  (insert-space "resources/_preface.tex")
  :rcf)

(defn -main
  []
  (let [[action dir] *command-line-args*]
    (if (and action dir)
      (let [files (tex-files dir)]
        (case action
          "--gaku"
          (do
            (doall (pmap ->gaku files))
            (doall (pmap remove-spaces files)))
          "--my"
          (do
            (doall (pmap ->my files))
            (doall (pmap insert-space files)))
          (usage)))
      (usage))))

(-main)
