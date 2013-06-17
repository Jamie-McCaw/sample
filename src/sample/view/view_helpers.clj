(ns sample.view.view-helpers
  (:require
    [joodo.views :refer [render-partial *view-context*]]
    [chee.string :refer [gsub]]
    [chee.datetime :refer [parse-datetime]]
    [hiccup.page :refer :all]
    [hiccup.form :refer :all]
    [hiccup.element :refer :all]
    [sample.controller.post-controller :refer [blog-post-filenames]]
    [clojure.string :as string :refer [split]]))
 
(defn- post-parts [post-file-name]
  (string/split post-file-name #"(\.)|(_)"))
 
(defn get-post-name [post-file-name]
  (gsub
    (second (string/split post-file-name #"(\.)|(_)"))
    #"-"
    (fn [_] " ")))
 
(defn get-post-date [post-file-name]
  (parse-datetime :dense
                  (str (first (post-parts post-file-name)) "000000")))
 
(defn order-posts [post-file-names]
  (sort-by
    #(Integer/parseInt (first (post-parts %)))
    >
    post-file-names))
 
(defn get-post-route [post-file-name]
  (let [this-posts-parts (post-parts post-file-name)
        date (first this-posts-parts)
        title (second this-posts-parts)]
    (str "/post/" date "_" title)))