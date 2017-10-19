(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"

  ;; Clean
  :clean-targets ^{:protect false} ["resources/front/public/js/"
                                    "target/"
                                    "*.log"]

  ;; Common dependencies
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [lein-doo "0.1.7"]]

  ;; Common plugins
  :plugins [[lein-doo "0.1.7"]]

  ;; Common paths
  :source-paths ["src/common"]
  :test-paths ["test/common"]
  :resource-paths []

  ;; Aliases
  :aliases {;; Dev
            "back" "backend"
            "backend" ["with-profile" "back" "ring" "server-headless"]
            "front" "frontend"
            "frontend" ["with-profile" "front" "figwheel"]
            ;; Test
            "test-back" "test-backend"
            "test-backend" ["with-profile" "back" "test"]
            "test-front" "test-frontend"
            "test-frontend" ["with-profile" "front" "doo" "phantom" "test" "once"]
            ;; Prod
            "build-front" "build-frontend"
            "build-frontend" ["with-profile" "front" "cljsbuild" "once" "prod"]}

  ;; Other
  :cljsbuild {:builds {:devcards {:source-paths ["src/front" "src/common"]
                                  :figwheel {:devcards true
                                             :open-urls ["http://localhost:3449/cards.html"]}
                                  :compiler {:main       "{{name}}.core"
                                             :asset-path "js/compiled/devcards_out"
                                             :output-to  "resources/front/public/js/compiled/{{sanitized}}_devcards.js"
                                             :output-dir "resources/front/public/js/compiled/devcards_out"
                                             :source-map-timestamp true }}
                       :dev {:source-paths ["src/front" "src/common"]
                             :figwheel true
                             :compiler {:main       "{{name}}.core"
                                        :asset-path "js/compiled/out"
                                        :output-to  "resources/front/public/js/compiled/{{sanitized}}.js"
                                        :output-dir "resources/front/public/js/compiled/out"
                                        :source-map-timestamp true }}
                       :prod {:source-paths ["src/front" "src/common"]
                              :compiler {:main       "{{name}}.core"
                                         :asset-path "js/compiled/out"
                                         :output-to  "resources/front/public/js/compiled/{{sanitized}}.js"
                                         :optimizations :advanced}}
                       :test {:source-paths ["src/front" "src/common" "test/front" "test/common"]
                              :compiler {:output-to "resources/front/test/compiled.js"
                                         :output-dir "resources/front/test/out"
                                         :pretty-print true
                                         :main test.core
                                         :optimizations :none}}}}

  ;; Profiles
  :profiles {:front {;; Dependencies
                     :dependencies [[org.clojure/clojurescript "1.9.229"]
                                    [devcards "0.2.3"]
                                    [rum "0.10.8"]]

                     ;; Plugins
                     :plugins [[lein-figwheel "0.5.9"]
                               [lein-cljsbuild "1.1.5" :exclusions [org.clojure/clojure]]]

                     ;; Paths
                     :source-paths ["src/front"]
                     :target-path "target/front"
                     :test-paths ["test/front"]
                     :resource-paths ["resources/front"]}
             :back {;; Dependencies
                    :dependencies [[compojure "1.5.1"]
                                   [ring/ring-defaults "0.2.1"]]

                    ;; Plugins
                    :plugins [[lein-ring "0.9.7"]]

                    ;; Paths
                    :source-paths ["src/back"]
                    :target-path "target/back"
                    :test-paths ["test/back"]
                    :resource-paths ["resources/back"]

                    ;; Other
                    :ring {:handler {{name}}.core/main}}})
