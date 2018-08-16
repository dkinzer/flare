(ns flare.session
  (:require [reagent.core :as reagent :refer [atom]]))

(defonce app-state
  (atom {:title "Flare"
         :default-query ""
         :solr-url "http://0.0.0.0:32784/solr/blacklight/select"
         :title-field :title_statement_display
         :fields {:id {:label "Doc ID"}
                  :title_statement_display {:label "title"}} 
         :docs []}))

