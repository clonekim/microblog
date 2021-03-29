(ns micro.graphql
  (:require [clojure.edn :as edn]
            [com.walmartlabs.lacinia.util :refer [attach-resolvers]]
            [com.walmartlabs.lacinia.schema :as s]
            [micro.db :as db]))



(defn init-schema [schema-name]
  (-> (clojure.java.io/resource schema-name)
      slurp
      edn/read-string
      (attach-resolvers
       {:post-pagination db/post-pagination
        :post            db/post
        :attachments     db/attachments
        :create-post     db/create-post
        :update-post     db/update-post
        :remove-post     db/remove-post}

       )
      s/compile)
)
