(ns {{name}}.dev.core
  (:require [test.core]
            [reaction.core :refer [bind-actions-list]]
            [{{name}}.core]))

(bind-actions-list)

;; /!\ This file won't be available when compiling in Prod /!\
