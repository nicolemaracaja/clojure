(defn conta-rec [n]
    (println n)
    (conta-rec (inc n)))

(defn conta []
    (conta-rec 0))

(conta)

;;Execution error (StackOverflowError) at user/conta-rec (resp02.clj:2).
;;a funcão conta chama conta-rec, que aplica a recursividade.
;;o n atualiza durante a execução, mas não há condição de parada.
