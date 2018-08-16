(ns flare.helpers
  (:require [ajax.core :refer  [GET POST]]
            [flare.session :refer [app-state]]))

(defn get-results [data]
  (.log js/console data)
  (swap! app-state assoc :docs (get-in data ["response" "docs"])))

(defn get-query []
  (.-value (.getElementById js/document "q")))

(def query-fields
  (clojure.string/join ", " (map name (keys (@app-state :fields)))))

(defn query-solr [query]
  (fn [event]
    (.preventDefault event)
    (GET (:solr-url @app-state)
         {:params (assoc default-solr-params :q (query) :wt "json" :fl query-fields) 
          :handler get-results})))

