(ns {{name}}.common.core)

(def hello-world
  (str "I'm a common Hello World. (But technically I'm run on a "
       #?(:clj "Clojure"
          :cljs "ClojureScript")
       " project)"))
