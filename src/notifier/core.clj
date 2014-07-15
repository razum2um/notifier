(ns notifier.core
  (:require [tempfile.core :refer [tempfile with-tempfile]]
            [clojure.java.io :as io])
  (:import [com.sun.jna Native Library]
           [org.apache.commons.lang3 SystemUtils]
           [org.apache.commons.io FileUtils]))

(gen-interface
 :name notifier.core.Bridge
 :extends [com.sun.jna.Library]
 :methods [[sendNotification [String, String, String, int] void]])

(defn- library-name
  []
  (if (SystemUtils/IS_OS_MAC_OSX)
    "NsUserNotificationsBridge.dylib"
    (throw (Exception. "unsupported platform"))))

(defn- bridge []
  (let [resource (io/file (io/resource (library-name)))]
    (with-tempfile [t (tempfile)]
      (FileUtils/copyFile resource t)
      (Native/loadLibrary (.getAbsolutePath t) notifier.core.Bridge))))

(defn notify
  ([message]
   (notify "" message))
  ([title message]
   (notify title "" message))
  ([title subtitle message]
   (try
     (.sendNotification (bridge) (str title) (str subtitle) (str message) 0)
     (catch Exception e (str "caught exception: " (.getMessage e))))))

