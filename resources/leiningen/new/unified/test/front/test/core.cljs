(ns test.core
  (:require-macros [devcards.core :refer [deftest]])
  (:require [cljs.test :as t :refer [is run-tests]]
            [test.common.core]))

(deftest dummy-test-front
  (is (= 2 (inc 1))))
