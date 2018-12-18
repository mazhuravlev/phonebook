(defproject server "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :main server.core
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :jvm-opts ["--add-modules" "java.xml.bind"]        
  :dependencies [
    [ring/ring-jetty-adapter "1.4.0"]
    [compojure "1.6.1"]
    [ring/ring-devel "1.7.1"]
    [ring/ring-core "1.7.1"]
    [http-kit "2.3.0"]
    [org.clojure/clojure "1.10.0"]])
