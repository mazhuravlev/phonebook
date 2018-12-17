(ns server.core
(:require [org.httpkit.server :as http]
          [ring.middleware.reload :as reload]
          [compojure.response :as response]
          [compojure.handler :refer [site]]
          [compojure.core :refer [defroutes GET POST ANY]]))

(defn make-file [path]
  (-> (clojure.java.io/file (str "./resources/" path))))

(defroutes all-routes
  (GET "/index.html" [] "<h1>INDEX</h1>")
  (GET "/" [] "<h1>INDEX</h1>")
  (GET ["/:filename" :filename #".*"] [filename]
    (let [file (make-file filename)]
      (if (.exists file)
        file
        (str "file not found: " filename)
        )))
  (GET "*" [] "not found"))

(defn -main [& args]
  (http/run-server (reload/wrap-reload (site #'all-routes)) {:port 8080})
  (println "Server started on port 8080"))