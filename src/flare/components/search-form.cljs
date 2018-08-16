(ns flare.components.search-form
  (:require [flare.components.icons :refer [flare-icon]]
            [flare.helpers :refer [query-solr get-query]]))

(defn search-form [query]
   [:form 
    [:div {:id "search-form":class "input-group"}
     [:label {:for "q" :class "sr-only"} "Search"]
     [:input {:type "text" :defaultValue query :id "q" }]
     [:span {:class "input-group-append"}
      [:button {:type "submit" :class "btn btn-primary search-btn" :id "search"
                :onClick (query-solr get-query)}
       [:span {:class "submit-search-text"} "Search"]
       [flare-icon :search]]] ]])
