(defn conta
  ([] (conta 0))
    ([n]
     (println n)
     (conta (inc n))))

(conta)

;;Execution error (StackOverflowError) at user/conta (resp03.clj:4).
;;A aridade sem parâmetros inicia a contagem com 0 e a aridade com um parâmetro [n] faz a recursão, incrementando o valor
;;Assim como na resp01 e na resp02, a ausência de uma condição de parada leva a um estouro da pilha
