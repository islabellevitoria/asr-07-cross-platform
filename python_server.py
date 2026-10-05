import socket

def iniciar_servidor():
    host = 'localhost'
    port = 6000

    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind((host, port))
        s.listen()
        print("Servidor Python aguardando conexão na porta 6000...")
        
        conn, addr = s.accept()
        with conn:
            dados = conn.recv(1024)
            print(f"Recebido do Java: {dados.decode('utf-8').strip()}")
            
            resposta = 'Mensagem recebida com sucesso! (Assinado: Servidor Python)\n'
            conn.sendall(resposta.encode('utf-8'))

if __name__ == "__main__":
    iniciar_servidor()
