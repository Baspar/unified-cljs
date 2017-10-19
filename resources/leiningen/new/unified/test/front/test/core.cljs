(ns test.core
  (:require [cljs.test :as t :refer [deftest is run-tests]]
            [doo.runner :refer-macros [doo-all-tests]]
            [test.common.core]))

(enable-console-print!)

(deftest dummy-test-front
  (is (= 2 (inc 1))))

(doo-all-tests #"test\..*")
