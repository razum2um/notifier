# Notifier

[![Build Status][BS img]][Build Status]

[![Clojars Project](http://clojars.org/notifier/latest-version.svg)](http://clojars.org/notifier)

Let's do desktop notifications in an easy way

## Usage

    ;; (:require [notifier.core :refer [notify]])
    (notify "Title" "Subtitle" "Message") ;; => nil

## It differs from others:

- no `shell` spawning (unlike [java-to-OS-notify](https://github.com/wokier/java-to-OS-notify))
- no [AppleScript](http://alvinalexander.com/mac-os-x/how-to-fire-mac-notifications-applescript-scala-java) on Mac OSX

Instead:

- on Mac OSX it uses a native `.dylib` (thanks to [OSxNotificationCenter](https://github.com/petesh/OSxNotificationCenter))
- on Linux it uses `java-dbus` to talk with [`org.freedesktop.Notifications.Notify`](http://www.galago-project.org/specs/notification/0.9/x408.html)
- otherwise it borrows tray notifications from `java-to-OS-notify`

## License

Copyright © 2014 Vlad Bokov

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

[BS img]: https://travis-ci.org/razum2um/notifier.png
[Build Status]: https://travis-ci.org/razum2um/notifier

