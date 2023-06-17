# Projeto Final Redes I 2023.1
Projeto apresentado na disciplina de Redes I do curso de Ciência da Computação na 
Universidade Estadual de Santa Cruz - UESC. Como forma de obter a pontuação do 3° crédito
na disciplina.

## Protocolo da Camada de Aplicação
### 1. Visão Geral:
O protocolo da camada de aplicação - Tabuada permite a comunicação entre um cliente e um servidor para gerar a tabuada de um número fornecido pelo cliente. O protocolo envolve trocas de mensagens e segue uma sequência de eventos para manter o software funcionando corretamente.
### 2. Participantes:
* **Cliente:**   *A parte que solicita a geração da tabuada de um número.* 
* **Servidor:**   *A parte que recebe a solicitação do cliente, realiza os cálculos e envia a tabuada de volta.*
### 3. Mensagens:
* **Solicitação:**
   - **Cliente -> Servidor:**  *Número a ser usado para gerar a tabuada.*
* **Resposta:**
    - **Servidor -> Cliente:**  *Tabuada do número fornecido.*
    - **Servidor -> Cliente:**  *Informação se o número é par ou ímpar.*
    - **Servidor -> Cliente:**  *Informação se o número é primo ou não.*
### 4. Eventos e Estados:
* **Cliente:**
   - **Estado Inicial:** *O cliente está aguardando a entrada do número a ser usado para a tabuada.*
   - **Evento:** *O cliente fornece o número.*
   - **Estado Final:** *O cliente aguarda a resposta do servidor.*
* **Servidor:**
   - **Estado Inicial:** *O servidor está aguardando a conexão do cliente.*
   - **Evento:** *O servidor aceita a conexão do cliente.*
   - **Estado Final:** *O servidor aguarda a solicitação do número do cliente.*
   - **Estado Inicial:** *O servidor recebeu a solicitação do número e está realizando os cálculos.*
   - **Evento:** *O servidor concluiu a geração da tabuada, verificou se o número é par ou ímpar e se é primo ou não.*
   - **Estado Final:** *O servidor está enviando a resposta ao cliente.*
   - **Estado Inicial:** *O servidor enviou a resposta ao cliente.*
   - **Evento:** *O servidor encerra a conexão com o cliente.*
   - **Estado Final:** *O servidor está aguardando uma nova conexão.*
### 5. Fluxo de Comunicação:
* **Cliente:** *Envia o número para o servidor.*
*  **Servidor:** *Recebe o número do cliente, gera a tabuada, verifica se é par ou ímpar e se é primo ou não.*
*  **Servidor:** *Envia a tabuada, a informação de par ou ímpar e a informação de primo ou não para o cliente.*
*  **Cliente:** *Recebe a tabuada e as informações do servidor.*
### 6. Considerações:
* O protocolo é baseado em um modelo de requisição-resposta, em que o cliente envia uma solicitação contendo o número e o servidor responde com a tabuada gerada e as informações adicionais.
* A comunicação é estabelecida por meio de sockets TCP/IP.
* Cada nova solicitação do cliente resulta em uma nova conexão entre o cliente e o servidor.
* O protocolo permite a geração da tabuada, verificação de paridade e verificação de primalidade do número fornecido.
  
## Funcionamento do Software
### 1. Propósito do Software:
O software tem como propósito gerar a tabuada de um número fornecido pelo usuário, além de fornecer informações sobre a paridade e primalidade desse número. O software visa fornecer uma ferramenta simples e prática para a geração de tabuadas e análise de números fornecidos pelo usuário.

### 2. Motivação da escolha do protocolo de transporte:
O protocolo de transporte escolhido para é o TCP (Transmission Control Protocol). A escolha do TCP é motivada pela necessidade de uma comunicação confiável e orientada à conexão entre o cliente e o servidor. O TCP garante a entrega ordenada e sem perdas das mensagens, além de realizar a segmentação e retransmissão em caso de congestionamento ou falhas na rede. Essas características são essenciais para garantir que a tabuada seja enviada corretamente e que a resposta do servidor seja recebida de forma confiável.

### 3. Requisitos Mínimos de Funcionamento:
**a) Conectividade de Rede:** O cliente e o servidor devem estar em redes que possibilitem a comunicação entre eles. Isso pode ser alcançado por meio de redes locais (WIFI), ou seja, precisam estar conectados na mesma rede.

**b) Portas de Comunicação:** O servidor deve estar configurado para ouvir em uma porta específica (por exemplo, porta 12345) e o cliente deve ser capaz de se conectar a essa porta para estabelecer a comunicação.

**c) Protocolo TCP:** O cliente e o servidor devem suportar o protocolo TCP para estabelecer uma conexão confiável e orientada à conexão.

**d) Entrada Válida:** O cliente deve fornecer um número válido como entrada para a geração da tabuada. Caso contrário, o servidor deve lidar com essa situação de entrada inválida e fornecer uma resposta apropriada.
