(defn imprimir_palavra [n palavra]
  (when (> n 0)
    (println palavra)
    (recur (dec n) palavra)))

(def -main []
  (println "Digite um número N:")
  (flush)
  (let [n (Integer/parseInt (read-line))]
    (println "Digite uma palavra:")
    (flush)
    (let [palavra (read-line)]
      (imprimir_palavra n palavra))))

(-main)
