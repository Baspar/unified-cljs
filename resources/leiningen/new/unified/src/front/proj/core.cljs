(ns {{name}}.core
  (:require
    [rum.core :refer [defc mount]]
    [reaction.core :refer-macros [defaction defaction! dispatch!]]
    [kvlt.chan :refer [request!]]
    [cljs.core.async :refer [timeout]]
    [{{name}}.common.core :refer [hello-world]])
  (:require-macros
    [cljs.core.async.macros :refer [go]]
    [devcards.core :refer [defcard]]))

(enable-console-print!)

;; Actions
(defaction first-action
  "Increment the counter"
  [m]
  (update m :counter inc))
(defaction! first-action
  "Dispatch [:first-action] after 1s"
  [state]
  (go
    (<! (timeout 1000))
    (dispatch! state :first-action)))

;; Component
(defc first-component [state]
  [:div
   [:div
    [:button {:on-click #(go
                           (let [res (<! (request! {:url "/api"
                                                    :method :get}))]
                             (println res)))}
     "Click to test the back-end connection"]
    [:div hello-world]]
   [:div
    [:button {:on-click #(dispatch! state [! :first-action])} "Call [! :first-action]"]]])

;; Devcard
(defcard first-card
  (fn [state] (first-component state))
  {}
  {:inspect-data true})

;; Main function
(defn render-fn [state]
  (if-let [node (.getElementById js/document "main-app-area")]
    (mount (first-component state) node)))

;; Main State
(defonce app-state (atom {}))
(add-watch app-state
           :rendering
           (fn [_ state old-state new-state]
             (render-fn state)))

(render-fn state)
