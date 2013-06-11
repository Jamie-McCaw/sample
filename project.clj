(defproject sample "0.0.1"
  :description "A website deployable to AppEngine"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [joodo "1.0.0"]
                 [hiccup "1.0.3"]]

  :joodo-root-namespace sample.root

  ; leiningen 2
  :profiles {:dev {:dependencies [[speclj "2.3.2"]]}}
  :test-paths ["spec/"]
  :java-source-paths ["src/"]
  :plugins [[speclj "2.3.2"]]

  ; leiningen 1
  :dev-dependencies [[speclj "2.3.2"]]
  :test-path "spec/"
  :java-source-path "src/"

  )
