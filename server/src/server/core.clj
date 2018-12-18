(ns server.core
(:require [org.httpkit.server :as http]
          [ring.middleware.reload :as reload]
          [ring.util.response :as r]
          [compojure.response :as response]
          [compojure.handler :refer [site]]
          [compojure.core :refer [defroutes GET POST ANY]]))

(defn make-file [path]
  (-> (clojure.java.io/file (str "./resources/" path))))

(defn file-response [file] 
  (-> file
    r/response
    (r/header "Content-Type" "application/json")))

(defroutes all-routes
  (GET "/index.html" [] "<h1>INDEX</h1>")
  (GET "/" [] "<h1>INDEX</h1>")
  (GET ["/:filename" :filename #".*"] [filename]
    (let [file (make-file filename)]
      (if (.exists file)
        (file-response file)
        (str "file not found: " filename)
        )))
  (GET "*" [] "not found"))

(def port 8080)

(defn -main [& args]
  (http/run-server (reload/wrap-reload (site #'all-routes)) {:port port})
  (println (str "Server started on port " port)))