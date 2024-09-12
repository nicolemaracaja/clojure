(defn eh_triangulo [a b c]
  (and (> (+ a b) c)
       (> (+ a c) b)
       (> (+ b c) a)))

(defn tipo_triangulo [a b c]
  (cond
    (not (eh_triangulo a b c)) nil
    (and (= a b) (= b c)) :equilatero
    (or (= a b) (= a c) (= b c)) :isosceles
    :else :escaleno))

(println (tipo_triangulo 3 3 3))
(println (tipo_triangulo 3 3 5))
(println (tipo_triangulo 3 4 5))
(println (tipo_triangulo 1 2 3))
