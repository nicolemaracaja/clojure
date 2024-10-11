(require '[clojure.string :as str])

(defn ini-vogais [palavras]
  (let [vogais #{"a" "e" "i" "o" "u"}]
    (filter (fn [palavra]
              (vogais (str/lower-case (subs palavra 0 1))))
            (map str/lower-case palavras))))

;;testes ini-vogais
(assert (= '("amor" "elefante" "igreja") (ini-vogais ["Amor" "Elefante" "Igreja" "carro" "Casa"])))
(assert (= '("ave" "unicornio") (ini-vogais ["Ave" "unicornio" "Barco"])))
(assert (= '() (ini-vogais ["casa" "barco" "navio"])))
