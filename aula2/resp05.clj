(defn conta []
  (doseq [n (range)]    ;;gera uma seq infinita de nums
    (println n)))

(conta)

;;uso da função range sem aregumentos gera uma seq infinita de nums naturais, começando em 0
;;A contagem não acaba até que o programa seja interrompido manualmente
