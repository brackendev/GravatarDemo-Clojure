(defproject gravatar "0.1.0-SNAPSHOT"
  :main gravatar.core
  :description "Clojure implementation to interact with the Gravatar API"
  :url "https://github.com/brackendev/GravatarDemo-Clojure"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [http-kit "2.3.0"]
                 [org.clojure/data.json "0.2.6"]
                 [digest "1.4.9"]]
  :repl-options {:init-ns gravatarsdk.core})
