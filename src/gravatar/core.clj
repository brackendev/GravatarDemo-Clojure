(ns gravatar.core
  (:require
    [clojure.data.json :as json-strict]
    [org.httpkit.client :as http]
    [digest]
    [clojure.string :as str]
    [clojure.java.io :as io])
  (:use clojure.pprint))

(defn image-url
  [email]
  (str "http://www.gravatar.com/avatar/" (digest/md5 email) "?s=2048&r=x"))

(defn profile-url
  [email]
  (str "http://www.gravatar.com/" (digest/md5 email) ".json"))

(defn- save-image [body fileName]
  (io/copy body (java.io.File. fileName)))

(defn file-extension [string]
  (cond
    (= "image/jpeg" string) ".jpg"
    (= "image/png" string) ".png"
    :default ""))

;; Download the image for the email address
(defn image-for-email
  [email]
  (let [{:keys [headers body]} @(http/get (image-url email) {:as :stream})]
    (let [contentType (get headers :content-type)
          emailHash (digest/md5 email)
          fileExtension (file-extension contentType)
          fileName (str emailHash fileExtension)]
      (save-image body fileName))))

;; Retrieve the profile for the email address
(defn profile-for-email
  [email]
  (let [{:keys [body]} @(http/get (profile-url email))]
    (def entry (get (json-strict/read-str body) "entry"))
    (get entry 0)))

(defn -main [& argv]
  (if (= (first argv) "image") (do (image-for-email (second argv))))
  (if (= (first argv) "profile") (do (pprint (profile-for-email (second argv))))))
