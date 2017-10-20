(ns {{name}}.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [{{name}}.common.core :refer [hello-world]]))

(defroutes app-routes
  (GET "/api" [] hello-world)
  (route/resources "/")
  (route/not-found "Not Found"))

(def main
  (wrap-defaults app-routes site-defaults))
