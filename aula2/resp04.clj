(defn conta []
  (loop [n 0]
    (println n)
    (recur (inc n))))

(conta)

;;O motivo pelo qual o erro do estouro da pilha não ocorre mais é o uso do recur
;;Clojure trata a recursão como uma iteração, ou seja, não há acúmulo de chamadas na pilha
