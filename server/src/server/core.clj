(ns server.core)
(require '[org.httpkit.server :as http])

(defn app [req]
  (println req)
  {:status  200
   :headers {"Content-Type" "text/html;charset=utf-8"}
   :body    (str (:uri req) " тут такого нет")})

(defn -main [& args]
  (http/run-server app {:port 8080})
  (println "Server started on port 8080"))