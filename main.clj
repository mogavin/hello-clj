;;1

(defn greeting
  ([] "Hello, World!")
  ([x] (str "Hello, " x, "!"))
  ([x y] (str x ", " y "!")))

;(println (greeting))

(assert (= "Hello, World!" (greeting)))
(assert (= "Hello, Clojure!" (greeting "Clojure")))
(assert (= "Good morning, Clojure!" (greeting "Good morning" "Clojure")))

;;2
(defn do-nothing [x] x)

(defn always-thing [& y] 
  ":thing")

(defn make-thingy [x] (fn [& y] x))

;(println ((make-thingy :foo)))

(let [n (rand-int Integer/MAX_VALUE)
      f (make-thingy n)]
  (assert (= n (f)))
  (assert (= n (f :foo)))
  (assert (= n (apply f :foo (range))))
)

;;3
(defn triplicate [f] 
  (f)
  (f)
  (f)
)

;(triplicate (fn [](println "Teste")))

(defn opposite [f]
  (fn [& args] 
    (not(apply f args))))

(println
  ((opposite 
  (fn [& args] (apply + args))) 
  1 2 3 ))
