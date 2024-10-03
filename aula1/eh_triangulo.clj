(defn eh_triangulo [a b c]
  (and (> (+ a b) c)
       (> (+ a c) b)
       (> (+ b c) a)))

(println (eh_triangulo 3 4 5))
(println (eh_triangulo 1 2 3)) 
