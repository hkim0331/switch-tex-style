#!/usr/bin/env bb
;; a script for 2023-python/tex
;; upload _main.pdf or other pdfs to https://p.melt.kyutech.ac.jp
;; 2023-10-11

(require '[babashka.process :as ps]
         '[clojure.string :as str])

(def url "ubuntu@tiger.melt.kyutech.ac.jp/2023-python/public/")

(defn usage
  []
  (println
   "usage:
   push.clj dest ... scp _main.pdf ubuntu@tiger.melt.kyutech.ac.jp/2023-python/public/dest.pdf
   push.clj some.pdf abc ... scp some.pdf ubuntu@tiger.melt.kyutech.ac.jp/2023-python/public/dest.pdf"))

(defn append-pdf
  "when s ends with '.pdf', return s.
   otherwise returns s.pdf"
  [s]
  (if (str/ends-with? s ".pdf")
    s
    (str s ".pdf")))

(defn push
  ([dest] (push "_main.pdf" dest))
  ([pdf dest]
   (ps/shell (str "scp " (append-pdf pdf) " " url (append-pdf dest)))))

(defn -main
  [& _]
  (case (count *command-line-args*)
    1 (push "_main.pdf" (first *command-line-args*))
    2 (push (first *command-line-args*)
            (second *command-line-args*))
    (usage)))

(-main)
