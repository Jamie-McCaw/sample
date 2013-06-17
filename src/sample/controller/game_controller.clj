(ns sample.controller.game-controller
  (:require [compojure.core :refer [GET defroutes]]
            [joodo.views :refer [render-template]]))

(defroutes game-controller
 (GET "/game" []
      (render-view "game" :name "Jamie")))