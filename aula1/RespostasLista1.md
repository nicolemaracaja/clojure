1. São expressões simbólicas e podem ser elementos atômicos ou
   listas.

2.  - "nicole" - String;
    - true - Valor booleano;
    - count - Variável que é atualizada a cada loop;
    - % - Operador matemático de resto;
    - 7.0 - Valor em ponto flutuante.

3. Uma forma é toda expressão simbólica escrita em Lisp, que pode
   ser executada pelo interpretador, sem incorrer em erro.

4.  S-expressões que não são formas:
    - (2 3 +)
    - ("String" 1 2)
    - (() 1 2 3)
    S-expressões que são formas:
    - (+ 2 3)
    - (def nome "Nicole")
    - (fn [a b] (+ a b))

5. Símbolos são sequências de caracteres que podem ser usadas
   para definir variáveis ou funções. Exemplos de símbolos podem
   ser: x (variável), count (variável contador), "nicole"
   (String). 

6. (* (+ 2 5 7) (- 8 (inc 3)) 5)
   (* (14) (- 8 (4)) 5)
   (* (14) (4) 5)
   280

7. Formas especiais são aquelas formas que quebram paradigmas.
   São todas as expressões simbólicas escritas em Lisp, em que há
   um símbolo funcional e um conjunto de argumentos (escritos em
   s-expressão), no qual a função é aplicada. As funções definida
   def, fn e if possuem comportamentos que não podem ser replicados por uma
   função normal, por isso elas são formas especiais. 

8. (defn dobro [n] (* 2 n))[
   (defn triplo [n] (* 3 n))
   (defn vezes12 [n] (dobro (dobro (triplo n))))
    
    (vezes12 10)
    (dobro (dobro (triplo 10)))
    (dobro (dobro (* 3 10)))
    (dobro (dobro (30)))
    (dobro (* 2 30))
    (dobro (60))
    (* 2 60)
    120

9. Questão no diretório.

10. Questão no diretório. 

11. Questão no diretório.

12. Questão no diretório.

