(ns gravatar.core
  (:require [clojure.data.json :as json-strict]
            [org.httpkit.client :as http]
            [digest]
            [clojure.string :as str]
            [clojure.java.io :as io]
            [clojure.pprint :as pp]))

(defn image-url
  [email]
  (str "http://www.gravatar.com/avatar/" (digest/md5 email) "?s=2048&r=x"))

(defn profile-url
  [email]
  (str "http://www.gravatar.com/" (digest/md5 email) ".json"))

(defn file-extension [string]
  (cond (= "image/jpeg" string) ".jpg"
        (= "image/png" string) ".png"
        :else ""))

(defn image-for-email
  "Download the Gravatar image for the email address"
  [email]
  (let [{:keys [headers body]} @(http/get (image-url email) {:as :stream})
        content-type (get headers :content-type)
        email-hash (digest/md5 email)
        file-extension (file-extension content-type)
        file-name (str email-hash file-extension)]
    (io/copy body (java.io.File. file-name))))

(defn profile-for-email
  "Retrieve the Gravatar profile for the email address."
  [email]
  (let [{:keys [body]} @(http/get (profile-url email))
        entry (get (json-strict/read-str body) "entry")]
    (get entry 0)))

(defn -main [& argv]
  (cond (= (first argv) "image") (image-for-email (second argv))
        (= (first argv) "profile") (pp/pprint (profile-for-email (second argv)))))
