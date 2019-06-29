(ns gravatar.core-test
  (:require [clojure.test :refer [deftest is]]
            [gravatar.core]))

(deftest image-url-test
  (is (= "http://www.gravatar.com/avatar/5658ffccee7f0ebfda2b226238b1eb6e?s=2048&r=x" (gravatar.core/image-url "email@example.com"))))

(deftest profile-url-test
  (is (= "http://www.gravatar.com/5658ffccee7f0ebfda2b226238b1eb6e.json" (gravatar.core/profile-url "email@example.com"))))

(deftest file-extension-test
  (is (= ".jpg" (gravatar.core/file-extension "image/jpeg")))
  (is (= ".png" (gravatar.core/file-extension "image/png"))))
