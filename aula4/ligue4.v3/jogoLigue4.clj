(ns ligue4.core)

;função para inicializar o tabuleiro
(defn inicializar-tabuleiro []
  (vec (repeat 6 (vec (repeat 7 " ")))))

;função para exibir o tabuleiro no terminal
(defn mostrar-tabuleiro [tabuleiro]
  (doseq [linha tabuleiro]
    (println (clojure.string/join "|" linha)))
  (println "-----------------------------"))

;função para encontrar a linha mais baixa disponível em uma coluna
(defn encontrar-linha-vazia [tabuleiro coluna]
  (first (filter (fn [i] (= " " (get (nth tabuleiro i) coluna)))
                 (range 5 -1 -1))))

;função para inserir a jogada no tabuleiro
(defn realizar-jogada [tabuleiro coluna jogador]
  (let [linha (encontrar-linha-vazia tabuleiro coluna)]
    (if linha
      (assoc-in tabuleiro [linha coluna] jogador)
      tabuleiro)))

;função para verificar se há uma sequência de 4 peças em uma lista
(defn verificar-sequencia [lista jogador]
  (some (fn [sublista] (= (repeat 4 jogador) sublista))
        (partition 4 1 lista)))

;função para verificar se há uma vitória na linha
(defn verificar-linhas [tabuleiro jogador]
  (some (fn [linha] (verificar-sequencia linha jogador)) tabuleiro))

;função para verificar se há uma vitória nas colunas
(defn verificar-colunas [tabuleiro jogador]
  (verificar-linhas (apply map vector tabuleiro) jogador))

;função para verificar se há uma vitória nas diagonais
(defn diagonais [tabuleiro]
  (let [linhas (count tabuleiro)
        colunas (count (first tabuleiro))]
    (for [i (range (- linhas 3))
          j (range (- colunas 3))]
      (for [k (range 4)]
        [(+ i k) (+ j k)]))))

(defn diagonais-inversas [tabuleiro]
  (let [linhas (count tabuleiro)
        colunas (count (first tabuleiro))]
    (for [i (range (- linhas 3))
          j (range 3 (- colunas))]
      (for [k (range 4)]
        [(+ i k) (- j k)]))))

(defn verificar-diagonais [tabuleiro jogador]
  (or
    (some (fn [diag]
            (verificar-sequencia (map (fn [pos] (get-in tabuleiro pos)) diag) jogador))
          (diagonais tabuleiro))
    (some (fn [diag-inv]
            (verificar-sequencia (map (fn [pos] (get-in tabuleiro pos)) diag-inv) jogador))
          (diagonais-inversas tabuleiro))))

;função para verificar se o jogador venceu
(defn verificar-vitoria [tabuleiro jogador]
  (or (verificar-linhas tabuleiro jogador)
      (verificar-colunas tabuleiro jogador)
      (verificar-diagonais tabuleiro jogador)))

;função para alternar jogadores
(defn alternar-jogador [jogador]
  (if (= jogador "X") "O" "X"))

;função principal do jogo
(defn jogar []
  (loop [tabuleiro (inicializar-tabuleiro)
         jogador "X"]
    (mostrar-tabuleiro tabuleiro)
    (println (str "Jogador " jogador ", escolha uma coluna (1-7): "))
    (let [coluna (read-line)
          coluna-int (dec (Integer/parseInt coluna))]
      (if (and (>= coluna-int 0) (<= coluna-int 6))
        (let [novo-tabuleiro (realizar-jogada tabuleiro coluna-int jogador)]
          (if (verificar-vitoria novo-tabuleiro jogador)
            (do (mostrar-tabuleiro novo-tabuleiro)
                (println (str "Jogador " jogador " venceu!")))
            (recur novo-tabuleiro (alternar-jogador jogador))))
        (do
          (println "Escolha inválida, tente novamente.")
          (recur tabuleiro jogador))))))

(jogar)
