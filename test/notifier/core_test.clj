(ns notifier.core-test
  (:use expectations)
  (:require [notifier.core :refer :all]))

(expect nil (notify "title" "message"))

