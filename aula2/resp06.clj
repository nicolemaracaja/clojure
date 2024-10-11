(defn conta []
  (let [limite (read)]          ;;le o num limite na entrada
    (doseq [n (range (inc limite))]     ;;gera a seq até o valor (inclusivo)
      (println n))))

(conta)

;;read usado para pegar o valor que o usuário deseja contar
;;inc limite gera uma seq de números naturais que vai de 0 até n (inclusivo)
;;a função doseq percorre a seq e imprime cada num
