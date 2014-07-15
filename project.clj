(defproject notifier "0.1.0-SNAPSHOT"
  :description "Let's do desktop notifications in an easy way"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [com.sun.jna/jna "3.0.9"]
                 [org.apache.commons/commons-lang3 "3.3.2"]
                 [commons-io/commons-io "2.4"]
                 [org.clojure/tools.namespace "0.2.4"]
                 [tempfile "0.1.0"]]
  :profiles {:dev {:dependencies [[expectations "2.0.6"]
                                  [lein-expectations "0.0.5"]]}}
  :plugins [[lein-expectations "0.0.7"]
            [lein-autoexpect "1.0"]])
