(ns todo-list.core
  (:require [ring.adapter.jetty :as webserver]))

(defn welcome
  "A ring handler to process all requests sent to the webapp"
  [request]
  {:status  200
   :headers {}
   :body    "<h1>Hello, Clojure World</h1>
             <p>Welcome to your first Clojure app.
             This message is returned regardless of the request, sorry<p>"})

(defn -main
  "A very simple web server using Ring & Jetty"
  [port-number]
  (webserver/run-jetty
    welcome
    {:port  (Integer. port-number)
     :join? false}))
