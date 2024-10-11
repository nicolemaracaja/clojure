(defn lenght [seq]
  (if (empty? seq)
    0
    (inc (lenght (rest seq)))))

;;Testes do lenght
(assert (= 3 (lenght [1 2 3])))
(assert (= 0 (lenght [])))
(assert (= 5 (lenght [1 2 3 4 5])))


(defn value_at [i seq]
  (if (zero? i)                      ;;vrifica se o índice é 0
    (first seq)                      ;;se sim, retorna o primeiro elemento
    (value_at (dec i) (rest seq))))  ;;se não, decrementa o índice e chama recursivamente

;;Testes do value_at
(assert (= 3 (value_at 2 [1 2 3 4 5])))
(assert (= 1 (value_at 0 [1 2 3])))
(assert (= 5 (value_at 4 [1 2 3 4 5])))


(defn index [v seq]
  (letfn [(aux [seq i]
            (cond
              (empty? seq) -1                    ;;se a seq estiver vazia, retorna -1
              (= (first seq) v) i                ;;se o primeiro elemento for igual a v, retorna o índice atual
              :else (aux (rest seq) (inc i))))]  ;;caso contrário, chama a função com o resto da seq e incrementa
    (aux seq 0)))                                ;;inicializa a função auxiliar com o índice 0

;;Testes de index
(assert (= 2 (index 3 [1 2 3 4 5])))
(assert (= -1 (index 6 [1 2 3])))
(assert (= 0 (index 1 [1 2 3 4 5])))
