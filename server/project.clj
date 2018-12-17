(defproject server "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :main server.core
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :jvm-opts ["--add-modules" "java.xml.bind"]        
  :dependencies [
    [compojure "1.1.5"]
    [ring/ring-devel "1.1.8"]
    [ring/ring-core "1.1.8"]
    [http-kit "2.3.0"]
    [org.clojure/clojure "1.8.0"]])
