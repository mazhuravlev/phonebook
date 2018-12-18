(ns client.core
    (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)
(println "This text is printed from src/client/core.cljs. Go ahead and edit it and see reloading in action.")

(defn process-contact [contact]
  (assoc (apply hash-map (rest contact)) :name (first contact)))

(defonce test-data
  [["Name1" :phone "123"]
   ["Name2" :phone "456"]
   ["Name3"]
   ["Name4" :phone "789" :photo "img"]
   ["Name5" :photo "img"]])

(defonce contacts (atom []))

(defn add-contact [contact]
  (swap! contacts conj (process-contact contact)))

(defn contact [{:keys [name phone photo]}]
  [:div.contact
   [:div.contact__photo-wrapper.contact__phone-wrapper_centr
    [:p photo]]
   [:div.contact__name-wrapper.contact__phone-wrapper_centr
    [:p name]]
   [:div.contact__phone-wrapper.contact__phone-wrapper_centr
    [:p phone]]
   [:button.contact__button {:on-click #(js/console.log (str name " " phone))} "Beep"]])

(defn contact-list []
  [:div.contacts
    [:h1 "Contact list"]
    (for [c @contacts]
      [contact c])])

(doseq [c test-data] (add-contact c))

(reagent/render-component [contact-list]
                          (. js/document (getElementById "app")))