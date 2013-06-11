(ns sample.game_spec
  (:use
    [speclj.core]
    [joodo.spec-helpers.controller]
    [sample.root]))

(describe "game"

  (with-mock-rendering)
  (with-routes app-handler)

  (it "handles game page"
    (let [result (do-get "/game")]
      (should= 200 (:status result))
      (should= "game" @rendered-template)))
  )

(run-specs)