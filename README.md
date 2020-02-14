_My Gravatar demo projects are for users to get acquainted with languages and platforms with something more than a "Hello World" example. Versions are available for [Clojure](https://github.com/brackendev/GravatarDemo-Clojure), [F#](https://github.com/brackendev/GravatarDemo-FSharp), [Newspeak](https://github.com/brackendev/GravatarDemo-Newspeak), [Pharo](https://github.com/brackendev/GravatarDemo-Pharo), [Racket](https://github.com/brackendev/GravatarDemo-Racket), and [Squeak](https://github.com/brackendev/GravatarDemo-Squeak)._

- - -

GravatarDemo-Clojure
====================

**[Clojure](https://www.clojure.org/) implementation to interact with the [Gravatar API](https://en.gravatar.com/site/implement/).**

* [Clojure 1.10.1](https://www.clojure.org/) reference platform.
* Tests included.

## Installation

* Install and setup [Clojure](https://www.clojure.org/) and [Leiningen](https://leiningen.org).

## Example Usage

Execute in a shell (in the project directory):

```bash
lein run image email@example.com
```

```bash
lein run profile email@example.com
```

***or***

To use the REPL, execute in a shell (in the project directory):

```bash
lein repl
```

Then in the REPL, evaluate:

```clojure
;; Retrieve the image for the email address
(image-for-email "email@example.com")
```

```clojure
;; Retrieve the profile for the email address
(profile-for-email "email@example.com")
```

To run the tests, execute in a shell:

```bash
lein test
```

## Author

[brackendev](https://www.github.com/brackendev)

## License

GravatarDemo-Clojure is released under the MIT license. See the LICENSE file for more info.

- - -

## Useful Links

* [/r/Clojure](https://www.reddit.com/r/Clojure/) [Reddit]
* [Clojure tutorial - boot, basic functions and how to do REST requests](https://joaoptrindade.com/clojure-tutorial-part-1-http-requests)
* [ClojureVerse](https://clojureverse.org/)
* [Rails Conf 2012 Keynote: Simplicity Matters by Rich Hickey](https://www.youtube.com/watch?v=rI8tNMsozo0)
* [clojure.org](https://www.clojure.org/)
