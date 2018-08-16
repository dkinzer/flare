(ns flare.core
  (:require [flare.configuration :as config :refer [default-solr-params]]
            [flare.components.search-form :refer [search-form]]
            [flare.session :refer [app-state]]
            [reagent.core :as reagent]))


(def title-field (name (@app-state :title-field)))

(defn result [doc]
  ^{:key (doc "id")}
  [:article { :id (doc "id") :class ["document" "blacklight-book"]}
   [:header {:class ["documentHeader" "row"]}
    [:h3 {:class ["index_title" "document-title-heading" "col-sm-9" "col-lg-10"]}
     (first (doc title-field))]]
   [:dl {:class ["document-metadata dl-invert row"]}]])

(defn results [docs]
  [:div {:id "documents" :class "document-list"}
   (for [doc docs]
     (result doc))])

(defn catalog []
  [:div
   [:h1 (:title @app-state)]
   [search-form (:default-query @app-state)]
   [results (:docs @app-state)]])

(reagent/render-component
  [catalog]
  (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)

