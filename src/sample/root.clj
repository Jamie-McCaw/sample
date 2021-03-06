(ns sample.root
  (:use
    [compojure.core :only (defroutes GET)]
    [compojure.route :only (not-found)]
    [joodo.middleware.view-context :only (wrap-view-context)]
    [joodo.views :only (render-template render-html)]
    [joodo.controllers :only (controller-router)]))

(defroutes sample-routes
  (GET "/"      [] (render-template "index"))
  (GET "/jamie" [] (render-template "jamie"))
  (GET "/login" [] (render-template "login"))
  (GET "/game"  [] (render-template "game"))
  (GET "/blog" [] (render-template "blog"))
  (controller-router 'sample.controller)
  (not-found (render-template "not_found" :template-root "sample/view" :ns `sample.view.view-helpers)))

(def app-handler
  (->
    sample-routes
    (wrap-view-context :template-root "sample/view" :ns `sample.view.view-helpers)))

