(ns test.common.core
  (:require #?(:cljs [cljs.test :refer [deftest is]]
               :clj [clojure.test :refer [deftest is]])))

(deftest dummy-test-common
  (is (= 2 (inc 1))))
