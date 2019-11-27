(ns todo-list.core
  (:require [ring.adapter.jetty :as webserver]))


(defn -main
  "A very simple web server using Ring & Jetty"
  [port-number]
  (webserver/run-jetty
    (fn [request]
      {:status  200
       :headers {}
       :body    "<h1>Hello, Clojure World</h1>
                 <p>Welcome to your first Clojure app.
                 This message is returned regardless of the request, sorry</p>"})
    {:port  (Integer. port-number)
     :join? false}))
