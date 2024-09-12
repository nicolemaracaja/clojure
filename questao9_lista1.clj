(defn raizes [a b c]
  (let 
    [ 
      delta (- (* b b) (* 4 a c))
      raiz (fn [operador]
              (/ (operador (- b) (Math/pow delta 0.5)) (* 2 a)))
    ]

    (cond 
        (> delta 0) [(raiz +), (raiz -)]
        (= delta 0) [(raiz +)]
        (< delta 0) []
    )
  )
)

(println (raizes 1 2 3))
(println (raizes 1 2 1))
(println (raizes 2 -3 -5))
