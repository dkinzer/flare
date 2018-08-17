(ns flare.components.results
  (:require [flare.session :refer [title-field]]))

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

