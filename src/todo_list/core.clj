(ns todo-list.core
  (:require [ring.adapter.jetty :as webserver]
            [ring.middleware.reload :refer [wrap-reload]]))


(defn welcome
  "A ring handler to process all requests for the web server.
  If a request is for something other than `/` then an error message is returned"
  [request]
  (if (= "/" (:uri request))
    {:status  200
     :headers {}
     :body    "<h1>Hello, Clojure World</h1>
               <p>Welcome to your first Clojure app.</p>"}
    {:status  404
     :headers {}
     :body    "<h1>This is not the page you are looking for</h1>
               <p>Sorry, the page you requested was not found!</p>"}))


(defn -main
  "A very simple web server using Ring & Jetty
  Production mode operation, no reloading."
  [port-number]
  (webserver/run-jetty
    welcome
    {:port (Integer. port-number)}))


(defn -dev-main
  "A very simple web server using Ring & Jetty,
  called via the development profile of Leiningen
  which reloads code changes using ring middleware wrap-reload"
  [port-number]
  (webserver/run-jetty
    (wrap-reload #'welcome)
    {:port  (Integer. port-number)
     :join? false}))
