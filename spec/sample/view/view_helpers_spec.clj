(ns sample.view.view-helpers-spec
  (:require [speclj.core :refer [describe it should= run-specs around with]]
            [sample.view.view-helpers :refer [get-post-name get-post-date order-posts
                                                get-post-route]]
            [chee.datetime :refer [parse-datetime]]))
 
(describe "view_helpers"
  (with test-post-1 "20111215_test-post-1.hiccup")
  (with test-post-2 "20111216_test-post-2.hiccup")
  (with test-post-3 "20111217_test-post-3.hiccup")
 
  (it "gets the title of a post"
    (should= "test post 1"
             (get-post-name "20111215_test-post-1.hiccup")))
 
  (it "gets the date of a post"
    (should= (parse-datetime :dense "20111215000000")
             (get-post-date "20111215_test-post-1.hiccup")))
 
  (it "orders posts from most recent to oldest"
    (should= [@test-post-3 @test-post-2 @test-post-1]
             (order-posts [@test-post-2 @test-post-1 @test-post-3])))
   
  (it "gets the route for a specified post"
    (should= "/post/20111215_test-post-1"
             (get-post-route @test-post-1))))