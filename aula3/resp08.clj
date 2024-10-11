(defn soma-quadrados-de-pares [seq]
  (reduce + (map (fn [n] (* n n))
                (filter even? seq)))) ;;filter even filtra os pares da seq

(assert (= 20 (soma-quadrados-de-pares [2 3 4 5])))
(assert (= 0 (soma-quadrados-de-pares [1 3 5])))
(assert (= 4 (soma-quadrados-de-pares [2])))
(assert (= 56 (soma-quadrados-de-pares [2 4 6])))
