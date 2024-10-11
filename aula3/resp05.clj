(defn somador [op]
  (fn [seq]
    (reduce + (map op seq))))

(def soma-cubos (somador (fn [n] (* n n n))))
(def soma-dobros (somador (fn [n] (* n 2))))
(def soma-triplos (somador (fn [n] (* n 3))))
(def soma (somador (fn [n] n)))
(def conta (somador (fn [n] (+ 1))))

;;Testes do somador
(assert (= 36 (soma-cubos [1 2 3])))
(assert (= 12 (soma-dobros [1 2 3])))
(assert (= 18 (soma-triplos [1 2 3])))
(assert (= 6 (soma [1 2 3])))
(assert (= 3 (conta [1 2 3])))
(assert (= 100000 (conta (range 100000))))
