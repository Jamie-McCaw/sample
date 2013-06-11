(ns sample.controller.game-controller
  (:require [compojure.core :refer [GET context defroutes]]
            [joodo.views :refer [render-template]]))

(defroutes game-controller
 (GET '/game' [] (fn [first-name]
      (render_template 'game' :first-name "Jamie"))))