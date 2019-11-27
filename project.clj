(defproject todo-list "0.1.0-SNAPSHOT"

  :description "A Todo List server-side webapp using Ring & Compojure"
  :url "https://github.com/practicalli/clojure-todo-list-example"

  :license {:name "Creative Commons Attribution Share-Alike 4.0 International"
            :url  "https://creativecommons.org"}

  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring "1.8.0"]]

  :repl-options {:init-ns todo-list.core}
  :main todo-list.core)
