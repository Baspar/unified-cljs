(ns {{name}}.dev.test-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [test.core]
            [test.common.core]))

(enable-console-print!)

(doo-tests 'test.core
           'test.common.core)
