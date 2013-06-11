(ns sample.jamie_spec
  (:use
    [speclj.core]
    [joodo.spec-helpers.controller]
    [sample.root]))

(describe "Jamie"

  (with-mock-rendering)
  (with-routes app-handler)

  (it "handles Jamie page"
    (let [result (do-get "/jamie")]
      (should= 200 (:status result))
      (should= "jamie" @rendered-template)))
  )

(run-specs)