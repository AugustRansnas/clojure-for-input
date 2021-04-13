(ns intro
  (:require [clojure.test :refer [is]]
            [clojure.string :refer [lower-case]]))

(defn a-func []
  "hej clojure")

(a-func)

;; vector

(def a-vec [1 2 3])

a-vec

(get a-vec 2)

(conj a-vec 4)

;; map

(def a-map {:key "value" :another-key {:a "korv"}})

(a-map :kalle "not found")

(get-in a-map [:another-key :a])

(assoc a-map :key "august")

;; set

(def a-set #{1 2 3})

(get a-set 4)

;; ----------

(map inc (filter even? (range 1 5)))

(->> (range 1 5)
     (filter even?)
     (map inc))


(def book (slurp "https://www.gutenberg.org/cache/epub/19942/pg19942.txt"))

(count book)

(count (re-seq #"[^\d\W]+" book))

(defn palindrome?
  {:test (fn []
           (is (palindrome? "anna"))
           (is (false? (palindrome? "august")))
           (is (false? (palindrome? "a")))
           )}
  [word]
  (and (= (seq word) (reverse word))
       (> (count word) 1)))

(->> book
     (re-seq #"[^\d\W]+")
     (map lower-case)
     (frequencies)
     (sort-by val)
     (take-last 10))

(->> book
     (re-seq #"[^\d\W]+")
     (distinct)
     (filter palindrome?))


