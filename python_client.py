import socket

def iniciar_cliente():
    host = 'localhost'
    port = 5000

    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.connect((host, port))
        mensagem = 'Olá, servidor Java! Esta é uma requisição do cliente Python.\n'
        s.sendall(mensagem.encode('utf-8'))
        
        resposta = s.recv(1024)
        print(f"Recebido do Java: {resposta.decode('utf-8').strip()}")

if __name__ == "__main__":
    iniciar_cliente()
