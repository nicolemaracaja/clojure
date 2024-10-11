from functools import reduce

def inicializar_tabuleiro():
    return [[" " for _ in range(7)] for _ in range(6)]

def mostrar_tabuleiro(tabuleiro):
    print("\n".join(["|".join(linha) for linha in tabuleiro]))
    print("-" * 29)

def realizar_jogada(tabuleiro, coluna, jogador):
    nova_linha = encontrar_linha_vazia(tabuleiro, coluna)
    if nova_linha is not None:
        novo_tabuleiro = [linha[:] for linha in tabuleiro]
        novo_tabuleiro[nova_linha][coluna] = jogador
        return novo_tabuleiro
    return tabuleiro

def encontrar_linha_vazia(tabuleiro, coluna):
    for i in range(5, -1, -1):
        if tabuleiro[i][coluna] == ' ':
            return i
    return None

def verificar_vencedor(tabuleiro):
    return verificar_linhas(tabuleiro) or verificar_colunas(tabuleiro) or verificar_diagonais(tabuleiro)

def verificar_linhas(tabuleiro):
    for linha in tabuleiro:
        if 'XXXX' in ''.join(linha):
            return 'X'
        elif 'OOOO' in ''.join(linha):
            return 'O'
    return None

def verificar_colunas(tabuleiro):
    for j in range(7):
        coluna = ''.join(tabuleiro[i][j] for i in range(6))
        if 'XXXX' in coluna:
            return 'X'
        elif 'OOOO' in coluna:
            return 'O'
    return None

def verificar_diagonais(tabuleiro):
    for r in range(6):
        for c in range(7):
            if r + 3 < 6 and c + 3 < 7:
                if tabuleiro[r][c] == tabuleiro[r+1][c+1] == tabuleiro[r+2][c+2] == tabuleiro[r+3][c+3] and tabuleiro[r][c] != ' ':
                    return tabuleiro[r][c]
            if r + 3 < 6 and c - 3 >= 0:
                if tabuleiro[r][c] == tabuleiro[r+1][c-1] == tabuleiro[r+2][c-2] == tabuleiro[r+3][c-3] and tabuleiro[r][c] != ' ':
                    return tabuleiro[r][c]
    return None

def alternar_jogador(jogador):
    return 'X' if jogador == 'O' else 'O'

def tabuleiro_cheio(tabuleiro):
    return all(tabuleiro[i][j] != ' ' for i in range(6) for j in range(7))

def jogar(tabuleiro, jogador):
    mostrar_tabuleiro(tabuleiro)

    if tabuleiro_cheio(tabuleiro):
        return "Empate!", tabuleiro

    vencedor = verificar_vencedor(tabuleiro)
    if vencedor:
        return f'Jogador {vencedor} venceu!', tabuleiro

    coluna = int(input(f"Jogador {jogador}, escolha uma coluna (1-7): ")) - 1
    novo_tabuleiro = realizar_jogada(tabuleiro, coluna, jogador)

    if novo_tabuleiro != tabuleiro:
        return jogar(novo_tabuleiro, alternar_jogador(jogador))
    else:
        print("Coluna cheia! Tente novamente.")
        return jogar(tabuleiro, jogador)

def main():
    placar_x, placar_o, empates = 0, 0, 0
    while True:
        tabuleiro = inicializar_tabuleiro()
        resultado, tabuleiro = jogar(tabuleiro, 'X')

        if 'X' in resultado:
            placar_x += 1
        elif 'O' in resultado:
            placar_o += 1
        else:
            empates += 1

        print(f"Placar: Jogador X: {placar_x}, Jogador O: {placar_o}, Empates: {empates}")

        if input("Deseja jogar novamente? (s/n): ").lower() != 's':
            break

if __name__ == "__main__":
    main()
