(ns sample.login_spec
  (:use
    [speclj.core]
    [joodo.spec-helpers.controller]
    [sample.root]))

(describe "login"

  (with-mock-rendering)
  (with-routes app-handler)

  (it "handles login page"
    (let [result (do-get "/login")]
      (should= 200 (:status result))
      (should= "login" @rendered-template)))
  )

(run-specs)