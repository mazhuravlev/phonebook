(ns client.core
    (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)
(println "This text is printed from src/client/core.cljs. Go ahead and edit it and see reloading in action.")


;; (defn create-id-generator []
;;  (let [next-id (atom 0)]
;;    (fn [] (swap! next-id inc) @next-id)))
;; (defonce generate-id (create-id-generator))

(defonce test-data
  [{:first "Vladimir" :last "Putin"}
   {:first "Barrak" :last "Obama"}
   {:first "Donald" :last "Trump"}
   {:first "Ingeborga" :last "Dopkunaite"}
   {:first "Ronald" :last "McDonald"}])

(defonce app-state (atom {:text "Hello world!"}))
(defonce contacts (atom []))

(defn add-contact [contact]
  (swap! contacts conj contact))

(defn display-name [{:keys [first last]}]
  (str last " " first))

(defn console-name [{:keys [first last]}]
  (js/console.log (str first " " last)))

(defn contact [c]
  [:li
    [:span (display-name c)]
    [:button {:on-click #(console-name c)} "Beep"]])

(defn contact-list []
  [:div
    [:h1 "Contact list"]
    [:ul
      (for [c @contacts]
        [contact c])]])

(doseq [c test-data] (add-contact c))

(reagent/render-component [contact-list]
                          (. js/document (getElementById "app")))
