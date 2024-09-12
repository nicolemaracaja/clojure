(defn calcula_delta [a b c]
  (- (Math/pow b 2) (* 4 a c)))

(defn raizes []
  (println "Digite os valores dos coeficientes:")
  (let [a (Integer/parseInt (read-line))
        b (Integer/parseInt (read-line))
        c (Integer/parseInt (read-line))
        delta (calcula_delta a b c)]
    (cond
        (> delta 0)
              (do
                  (let [raiz1 (/ (+ (- b) (Math/sqrt delta)) (* 2 a))
                          raiz2 (/ (- (- b) (Math/sqrt delta)) (* 2 a))
                      (println "Raiz 1:" raiz1)
                      (println "Raiz 2:" raiz2)
                  )
              )
        (= delta 0) (let [raiz (/ (- (- b) (Math/sqrt delta)) (* 2 a))]
                      (println "Raiz:" raiz))
        :else (println "Sem raízes.")
      )
    )
  )

(raizes)

