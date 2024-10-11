(defn msg-rec [msg]
    (println msg)
    (msg-rec msg))

(msg-rec (read))

;;Execution error (StackOverflowError) at sun.nio.cs.UTF_8/updatePositions (UTF_8.java:79).
;;como não há um caso base, o programa será chamado infinitas vezes, até o momento em que a memória se esgotar
;;para consertar isso, basta adicionar um caso base e um contador na função
