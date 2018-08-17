(ns flare.core
  (:require [flare.configuration :as config :refer [default-solr-params]]
            [flare.components.search-form :refer [search-form]]
            [flare.components.results :refer [results]]
            [flare.session :refer [app-state]]
            [reagent.core :as reagent]))

(defn catalog [state]
  [:div
   [:h1 (:title @state)]
   [search-form (:default-query @state)]
   [results (:docs @state)]])

(reagent/render-component
  [catalog app-state]
  (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)

