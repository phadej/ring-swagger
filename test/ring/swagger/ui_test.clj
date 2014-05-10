(ns ring.swagger.ui-test
  (:require [midje.sweet :refer :all]
            [ring.swagger.ui :refer :all]))

(tabular
  (fact get-path
    (get-path ?root ?uri) => ?path)

  ?root           ?uri                      ?path
  ""              "/"                       ""
  "/"             "/"                       ""
  ""              "/index.html"             "index.html"
  "/"             "/index.html"             "index.html"
  "/ui-docs"      "/index.html"             nil
  "/ui-docs"      "/ui-docs/index.html"     "index.html"
  )

(tabular
  (fact index-path
    (index-path ?path) => ?redirect)
  ?path           ?redirect
  ""              "/index.html"
  "/"             "/index.html"
  "/ui-docs"      "/ui-docs/index.html"
  "/ui-docs/"     "/ui-docs/index.html")