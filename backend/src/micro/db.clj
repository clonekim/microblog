(ns micro.db
  (:require [clojure.tools.logging :as log]
            [clojure.java.jdbc :as jdbc])
  (:import [java.io File]
           [java.sql DriverManager ResultSet]))


(defonce DB-INSTALL
  (str (System/getenv "HOME") (File/separator) "micro.db"))


(def db-spec
  {:classname "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname DB-INSTALL})



(defn- execute-ddl []
  "http://clojure-doc.org/articles/ecosystem/java_jdbc/using_ddl.html"

  (jdbc/db-do-commands
   db-spec
   (jdbc/create-table-ddl
    :posts
    [[:id "integer primary key autoincrement"]
     [:title "varchar(100) not null"]
     [:content "text not null"]
     [:tag "varchar(200)"]
     [:is_draft :boolean]
     [:created_at :datetime]
     [:updated_at :datetime]]))


   (jdbc/db-do-commands
   db-spec
   (jdbc/create-table-ddl
    :attachments
    [[:id "integer primary key autoincrement"]
     [:display_name "varchar not null"]
     [:saved_name "varchar not null"]
     [:content_type "varchar(100) not null"]
     [:size :integer]
     [:uploaded_at :datetime]
     [:post_id "integer not null"]]))

  )



(defn setup []
  (when-not (.exists (File. DB-INSTALL))
    (log/debug "create database at" DB-INSTALL)
    (execute-ddl)))



(defn post-pagination [ context args _value] )
(defn post [ context args _value] )
(defn attachments [ context args _value] )
(defn create-post [ context args _value] )
(defn update-post [ context args _value] )
(defn remove-post [ context args _value] )
