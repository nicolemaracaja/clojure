(defn fahr-celsius [temp]
  (map (fn [f] (/ (- f 32) 1.8)) temp)) ;;(f - 32) / 1.8

;;testes de fahr-celsius
(assert (= [0] (fahr-celsius [32])))
(assert (= [100] (fahr-celsius [212])))
(assert (= [10 20 30] (fahr-celsius [50 68 86])))
