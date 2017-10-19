(ns {{name}}.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [{{name}}.common.core :refer [hello-world]]))

(defroutes app-routes
  (GET "/" [] hello-world)
  (route/not-found "Not Found"))

(def main
  (wrap-defaults app-routes site-defaults))
