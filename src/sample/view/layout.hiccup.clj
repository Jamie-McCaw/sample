(doctype :html5)
[:html
 [:head
  [:meta {:http-equiv "Content-Type" :content "text/html" :charset "iso-8859-1"}]
  [:title "sample"]
  (include-css "/stylesheets/sample.css")
  (include-js "/javascript/sample.js")]
 [:body
 	[:div {:id "navbar"}
 	(unordered-list [(link-to "/" "Home") 
 									 (link-to "/jamie" "Jamie")
 									 (link-to "/game" "Game")
 									 (link-to "/login" "Login")
 									 (link-to "/blog" "Blog")])
  (eval (:template-body joodo.views/*view-context*))
]]]