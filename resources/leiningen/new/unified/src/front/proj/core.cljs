(ns {{name}}.core
  (:require
    [rum.core :refer [defc mount]]
    [kvlt.chan :refer [request!]]
    [{{name}}.common.core :refer [hello-world]])
  (:require-macros
    [cljs.core.async.macros :refer [go]]
    [devcards.core :refer [defcard]]))

(enable-console-print!)

(defc first-component []
  [:div
   [:button {:on-click #(go
                          (let [res (<! (request! {:url "/api"
                                                   :method :get}))]
                            (println res)))}
    "Click to test the back-end connection"]
   [:div hello-world]])

(defcard first-card
  (first-component))

(defn main []
  (if-let [node (.getElementById js/document "main-app-area")]
    (mount (first-component) node)))

(main)
