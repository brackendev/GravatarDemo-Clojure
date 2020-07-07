(defproject gravatar "0.1.0-SNAPSHOT"
  :main gravatar.core
  :description "Clojure implementation to interact with the Gravatar API"
  :url "https://github.com/brackendev/GravatarDemo-Clojure"
  :license {:name "MIT License"
            :url  "http://opensource.org/licenses/MIT"}
  :dependencies [[digest "1.4.9"]
                 [http-kit "2.4.0-alpha6"]
                 [org.clojure/clojure "1.10.1"]
                 [org.clojure/data.json "1.0.0"]]
  :repl-options {:init-ns gravatar.core})
