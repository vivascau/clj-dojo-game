(defproject clj-dojo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [org.clojure/clojurescript "1.7.228"]
                 [reagent "0.6.0-alpha"]]
  :plugins [[lein-ring "0.9.7"]
            [lein-cljsbuild "1.1.2"]
            [lein-figwheel "0.5.0-1"]]
  :cljsbuild {
    :builds [{
        ; The path to the top-level ClojureScript source directory:
        :source-paths ["src-cljs"]
        ; The standard ClojureScript compiler options:
        ; (See the ClojureScript compiler documentation for details.)
        :compiler {
          :output-to "resources/public/js/main.js"  ; default: target/cljsbuild-main.js
          :output-dir "resources/public/js/out"
          :figwheel true}}]}
  :ring {:handler clj-dojo.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
