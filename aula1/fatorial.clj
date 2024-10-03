(defn fatorial [n]
  (if (= n 1) 1
      (* n (fatorial (- n 1)))))

(defn -main [& args]
  (println "Digite um valor: ")
  (flush)
  (def n (Integer/parseInt (read-line)))
  (print (fatorial n)))
  (flush)

(-main)
