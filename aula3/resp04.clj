(defn somador [op]
  (fn [seq]
    (loop [s seq             ;;seq de entrada
           acc 0]            ;;acumulador
        (if (empty? s)       ;;verifica se a seq está vazia
          acc                ;;retorna o valor acumulado quando a seq tiver vazia
          (recur (rest s)
                 (+ acc (op (first s))))))))   ;;atualiza o acumulador aplicando o operador ao primeiro elemento da seq

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
