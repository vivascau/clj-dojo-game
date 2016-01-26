(ns clj-dojo.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]))

(def guess (atom (inc (rand-int 30))))

(defn post-number [number] (println number) (cond (= @guess number) "correct"
                                                  (< @guess number) "lower"
                                                  (> @guess number) "higher"))

(defn get-game [] (println @guess) (str @guess))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/game" [] (get-game) )
  (POST "/guess/:number" [number] (post-number (Integer/parseInt number)))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes api-defaults))
