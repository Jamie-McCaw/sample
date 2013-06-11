[:h1 "Not Found"]
(if-let [error (:error *view-context*)]
  [:p error])