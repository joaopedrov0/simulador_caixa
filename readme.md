# Simulador de Caixa de Supermercado

## Respostas das atividades

**1. Execute a simulação para μ = 5,0, σ = 0,5, N = 100 clientes e 1000 rodadas. Registre a média e o desvio-padrão obtidos.**

```txt
--- Simulador de Caixa de Supermercado ---
Parâmetros atuais:
  - Tempo médio de atendimento: 5,00
  - Desvio padrão: 0,50
  - Número de caixas: 1
  - Número de clientes: 100

Escolha uma opção:
1. Rodar simulação
2. Editar tempo médio de atendimento
3. Editar desvio padrão
4. Editar número de caixas
5. Editar número de clientes
0. Sair
Opção: 1

Iniciando simulação com os parâmetros atuais...

--- Resultados da Simulação ---
Média dos tempos totais de atendimento (1000 simulações): 1095,928 min
Desvio-padrão das médias: 11,744 min
```

**2. Varie o número de caixas de 1 para 2 e 3. Compare os resultados obtidos e discuta qualitativamente como mais caixas podem reduzir o tempo médio de atendimento.**

Resultado com 2 caixas:

```txt
--- Simulador de Caixa de Supermercado ---
Parâmetros atuais:
  - Tempo médio de atendimento: 5,00
  - Desvio padrão: 0,50
  - Número de caixas: 2
  - Número de clientes: 100

Escolha uma opção:
1. Rodar simulação
2. Editar tempo médio de atendimento
3. Editar desvio padrão
4. Editar número de caixas
5. Editar número de clientes
0. Sair
Opção: 1

Iniciando simulação com os parâmetros atuais...

--- Resultados da Simulação ---
Média dos tempos totais de atendimento (1000 simulações): 548,688 min
Desvio-padrão das médias: 6,058 min
```

Resultado com 3 caixas:

```txt
--- Simulador de Caixa de Supermercado ---
Parâmetros atuais:
  - Tempo médio de atendimento: 5,00
  - Desvio padrão: 0,50
  - Número de caixas: 3
  - Número de clientes: 100

Escolha uma opção:
1. Rodar simulação
2. Editar tempo médio de atendimento
3. Editar desvio padrão
4. Editar número de caixas
5. Editar número de clientes
0. Sair
Opção: 1

Iniciando simulação com os parâmetros atuais...

--- Resultados da Simulação ---
Média dos tempos totais de atendimento (1000 simulações): 366,383 min
Desvio-padrão das médias: 4,154 min
```

O tempo de atendimento é reduzido pois a vazão de clientes que percorrem os caixas é maior quando tem mais caixas disponíveis.

**3. Varie σ (ex.: 0,25, 1,0, 2,0) e observe como a variabilidade impacta os resultados médios.**

Resultado com desvio padrão = 0,25:

```txt
--- Simulador de Caixa de Supermercado ---
Parâmetros atuais:
  - Tempo médio de atendimento: 5,00
  - Desvio padrão: 0,25
  - Número de caixas: 3
  - Número de clientes: 100

Escolha uma opção:
1. Rodar simulação
2. Editar tempo médio de atendimento
3. Editar desvio padrão
4. Editar número de caixas
5. Editar número de clientes
0. Sair
Opção: 1

Iniciando simulação com os parâmetros atuais...

--- Resultados da Simulação ---
Média dos tempos totais de atendimento (1000 simulações): 366,424 min
Desvio-padrão das médias: 3,686 min
```

Resultado com desvio padrão = 1,0:

```txt
--- Simulador de Caixa de Supermercado ---
Parâmetros atuais:
  - Tempo médio de atendimento: 5,00
  - Desvio padrão: 1,00
  - Número de caixas: 3
  - Número de clientes: 100

Escolha uma opção:
1. Rodar simulação
2. Editar tempo médio de atendimento
3. Editar desvio padrão
4. Editar número de caixas
5. Editar número de clientes
0. Sair
Opção: 1

Iniciando simulação com os parâmetros atuais...

--- Resultados da Simulação ---
Média dos tempos totais de atendimento (1000 simulações): 366,348 min
Desvio-padrão das médias: 7,054 min
```

Resultado com desvio padrão = 2,0:

```txt
--- Simulador de Caixa de Supermercado ---
Parâmetros atuais:
  - Tempo médio de atendimento: 5,00
  - Desvio padrão: 2,00
  - Número de caixas: 3
  - Número de clientes: 100

Escolha uma opção:
1. Rodar simulação
2. Editar tempo médio de atendimento
3. Editar desvio padrão
4. Editar número de caixas
5. Editar número de clientes
0. Sair
Opção: 1

Iniciando simulação com os parâmetros atuais...

--- Resultados da Simulação ---
Média dos tempos totais de atendimento (1000 simulações): 366,875 min
Desvio-padrão das médias: 13,374 min
```

Não há impacto significativo nos resultados médios.

**4. Escreva um parágrafo explicando por que este simulador é considerado estocástico e como isso representa situações reais.**

O simulador é estocástico especialmente por conta das linhas `SimulacaoCaixaSupermercado.java:13` e `SimulacaoCaixaSupermercado.java:28-32`. Isso porque na linha 13 é definido um objeto do tipo `java.util.Random`, usado para inserir um elemento pseudo-aleatório no sistema, que depois é usado pelas linhas 28-32, onde um método gera um valor aleatório em uma distribuição gaussiana para ser usado na geração de "tempos de atendimento" que, apesar de aleatórios, estarão normalmente distribuidos.

## Como usar?

Para rodar o simulador, basta compilar o código e executar o Main.java

Compilando:

```bash
javac Main.java
```

Executando:

```bash
java Main.java
```

> ### Importante!
> Não tente executar o programa dessa forma:
> ```bash
> javac Main.java | java Main.java
> ```
> Isso é um problema porque o canal de comunicação da linha de comando é encerrado e o `Scanner` não consegue recuperar a próxima linha para o pegar o comando do usuário

Com o código rodando, basta editar as variáveis que quiser e rodar a simulação.

O menu foi feito com inteligência artificial.