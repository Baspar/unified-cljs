(ns test.common.core
  #?(:cljs (:require-macros [devcards.core :refer [deftest]]))
  (:require #?(:cljs [cljs.test :refer [is]]
               :clj [clojure.test :refer [deftest is]])))

(deftest dummy-test-common
  (is (= 2 (inc 1))))
