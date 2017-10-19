(ns test.core
  (:require [clojure.test :refer [deftest is]]))

(deftest dummy-test-back
  (is (= 2 (inc 1))))
