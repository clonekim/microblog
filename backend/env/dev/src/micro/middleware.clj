(ns micro.middleware
  (:require [ring.middleware.cors :refer [wrap-cors]]
            [ring.logger :refer [wrap-with-logger]]))



(defn dev-middleware [handler]
  (-> handler
      (wrap-cors :access-control-allow-origin [#".*"]
                 :access-control-allow-headers ["Content-Type" "Accept" "X-Requested-With"]
                 :access-control-allow-methods [:get :put :post :delete])
      (wrap-with-logger {:timing false})))


(def defaults
  {:middleware dev-middleware})
