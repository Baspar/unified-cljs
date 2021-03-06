(ns leiningen.new.unified
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "unified"))

(defn unified
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' unified project.")
    (->files data
             ["resources/public/cards.html" (render "resources/public/cards.html" data)]
             ["resources/public/index.html" (render "resources/public/index.html" data)]
             ["resources/public/css/style.css" (render "resources/public/css/style.css" data)]
             ["test/common/test/common/core.cljc" (render "test/common/test/common/core.cljc" data)]
             ["test/back/test/core.clj" (render "test/back/test/core.clj" data)]
             ["test/front/test/core.cljs" (render "test/front/test/core.cljs" data)]
             ["src/common/{{sanitized}}/common/core.cljc" (render "src/common/proj/common/core.cljc" data)]
             ["src/back/{{sanitized}}/core.clj" (render "src/back/proj/core.clj" data)]
             ["src/front/{{sanitized}}/core.cljs" (render "src/front/proj/core.cljs" data)]
             ["dev/{{sanitized}}/dev/test_runner.cljs"  (render "dev/proj/dev/test_runner.cljs" data)]
             ["dev/{{sanitized}}/dev/core.cljs" (render "dev/proj/dev/core.cljs" data)]
             ["README.md" (render "README.md" data)]
             [".gitignore" (render ".gitignore" data)]
             ["project.clj" (render "project.clj" data)]
             ["test.sh" (render "test.sh" data)]
             [".travis.yml" (render ".travis.yml" data)]
             [".circleci/config.yml" (render ".circleci/config.yml" data)]
             )))
