def print_tabuleiro(tabuleiro):
    for linha in tabuleiro:
        print("|".join(linha))
    print("-" * 29)

def verifica_vencedor(tabuleiro):
    #verifica as linhas
    for linha in tabuleiro:
        if "XXXX" in "".join(linha):
            return "X"
        if "OOOO" in "".join(linha):
            return "O"

    #verifica as colunas
    for col in range(7):
        col_str = ''.join(tabuleiro[row][col] for row in range(6))
        if 'XXXX' in col_str:
            return 'X'
        if 'OOOO' in col_str:
            return 'O'

    #verifica diagonais
    for linha in range(3):
        for col in range(4):
            if tabuleiro[linha][col] == tabuleiro[linha + 1][col + 1] == tabuleiro[linha + 2][col + 2] == tabuleiro[linha + 3][col + 3] != ' ':
                return tabuleiro[linha][col]
            if tabuleiro[linha + 3][col] == tabuleiro[linha + 2][col + 1] == tabuleiro[linha + 1][col + 2] == tabuleiro[linha][col + 3] != ' ':
                return tabuleiro[linha + 3][col]

    return None

placar = {'X': 0, 'O': 0, 'empates': 0}
while True:
    tabuleiro = [[' ' for _ in range(7)] for _ in range(6)]
    turno = 'X'
    while True:
        print_tabuleiro(tabuleiro)
        coluna = input(f"Jogador {turno}, escolha uma coluna (1-7) ou 'd' para desistir: ")
        if coluna.lower() == 'd':
            print(f"Jogador {turno} desistiu.")
            if turno == 'X':
                placar['O'] += 1
            else:
                placar['X'] += 1
            break

        try:
            col_idx = int(coluna) - 1
            if col_idx < 0 or col_idx >= 7:
                print("Coluna inválida. Tente novamente.")
                continue
        except ValueError:
            print("Entrada inválida. Tente novamente.")
            continue

        #coloca a ficha na coluna
        for linha in reversed(range(6)):
            if tabuleiro[linha][col_idx] == ' ':
                tabuleiro[linha][col_idx] = turno
                break
        else:
            print("Coluna cheia. Tente outra.")
            continue

        vencedor = verifica_vencedor(tabuleiro)
        if vencedor:
            print_tabuleiro(tabuleiro)
            print(f"Jogador {vencedor} venceu!")
            if vencedor == 'X':
                placar['X'] += 1
            else:
                placar['O'] += 1
            break

        if all(tabuleiro[0][col] != ' ' for col in range(7)):
            print_tabuleiro(tabuleiro)
            print("Empate!")
            placar['empates'] += 1
            break

        turno = 'O' if turno == 'X' else 'X'

    print(f"Placar: Jogador X: {placar['X']}, Jogador O: {placar['O']}, Empates: {placar['empates']}")
    jogar_novamente = input("Deseja jogar novamente? (s/n): ").lower()
    if jogar_novamente != 's':
        break
