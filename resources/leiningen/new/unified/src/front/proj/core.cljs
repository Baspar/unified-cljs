(ns {{name}}.core
  (:require
   [rum.core :refer [defc mount]]
   [{{name}}.common.core :refer [hello-world]])
  (:require-macros
   [devcards.core :refer [defcard deftest]]))

(enable-console-print!)

(defc first-component []
  [:div hello-world])

(defcard first-card
  (first-component))

(defn main []
  (if-let [node (.getElementById js/document "main-app-area")]
    (mount (first-component) node)))

(main)
