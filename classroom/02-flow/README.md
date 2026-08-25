# Prática em sala — controle de fluxo

Resolva os problemas abaixo para praticar estruturas de **seleção** e **iteração** em Java.

## Orientações

- Crie uma solução Java para cada problema.
- Use nomes de variáveis que expressem seu significado.
- Mantenha as chaves `{}` mesmo quando o bloco possuir somente uma instrução.
- Trate as entradas inválidas indicadas no enunciado.
- Execute também os casos de fronteira dos intervalos.
- Não use recursos que substituam o controle de fluxo solicitado, como operações prontas de ordenação ou geração de sequências.

## Parte I — estruturas de seleção

### 1. Positivo, negativo ou zero

Dados um número inteiro, classifique-o como:

- `POSITIVO`;
- `NEGATIVO`;
- `ZERO`.

**Estrutura principal:** `if-else if-else`.

Exemplos:

```text
Entrada: 8
Saída: POSITIVO

Entrada: -3
Saída: NEGATIVO
```

[Solução em vídeo](https://tecnologiaidp-my.sharepoint.com/:v:/g/personal/830279_idp_edu_br/IQD3Gn4NjvS0SLWrEKBVn-7nAcCnovcX8_jGvYKgaY8bQGM?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=TwPCCN)

### 2. Aprovação do estudante

Dadas duas notas entre `0` e `10`, calcule a média aritmética e apresente:

- `APROVADO`, para média maior ou igual a `7`;
- `RECUPERACAO`, para média maior ou igual a `5` e menor que `7`;
- `REPROVADO`, para média menor que `5`.

Se alguma nota estiver fora do intervalo, apresente `NOTA INVALIDA`.

**Estrutura principal:** `if-else if-else` com condições compostas.

```text
Entrada: 8.0 6.0
Saída: Média: 7.0 — APROVADO
```

[Solução em vídeo](https://tecnologiaidp-my.sharepoint.com/:v:/g/personal/830279_idp_edu_br/IQCPgWlQFGyHR6CaK9HERGu0AZqM4q2TsyeqqIOBKBRYImM?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=Ri5sZh)

### 3. Maior entre três números

Dados três números inteiros, apresente o maior. Se o maior valor aparecer mais de uma vez, apresente também `EMPATE NO MAIOR VALOR`.

**Estrutura principal:** `if` e operadores relacionais e lógicos.

```text
Entrada: 9 4 9
Saída: Maior: 9 — EMPATE NO MAIOR VALOR
```

[Solução em vídeo](https://tecnologiaidp-my.sharepoint.com/:v:/g/personal/830279_idp_edu_br/IQCi6WNzDUb5Sri0qU8jbCNXAdT4w0p2-5QG7uzwF1QWU8U?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=efdr1j)

### 4. Calculadora simples

Dados dois números reais e um operador (`+`, `-`, `*` ou `/`), calcule o resultado correspondente.

Regras:

- rejeite divisão por zero;
- apresente `OPERADOR INVALIDO` para qualquer outro caractere.

**Estrutura principal:** expressão `switch`.

```text
Entrada: 20 / 4
Saída: 5.0
```

[Solução em vídeo](https://tecnologiaidp-my.sharepoint.com/:v:/g/personal/830279_idp_edu_br/IQAJucmEUCUrTLtnoH-SBKEDAYiNobMEPJKzYnzqQg9KYFE?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=CjfNvO)

### 5. Quantidade de dias do mês

Dados o número de um mês e um ano, apresente a quantidade de dias daquele mês.

- meses `1`, `3`, `5`, `7`, `8`, `10` e `12` possuem 31 dias;
- meses `4`, `6`, `9` e `11` possuem 30 dias;
- fevereiro possui 28 ou 29 dias;
- um ano é bissexto quando é divisível por 400 ou quando é divisível por 4, mas não por 100;
- meses fora do intervalo de `1` a `12` são inválidos.

**Estruturas principais:** expressão `switch`, casos agrupados e `if`.

```text
Entrada: 2 2024
Saída: 29 dias
```

[Solução em vídeo](https://tecnologiaidp-my.sharepoint.com/:v:/g/personal/830279_idp_edu_br/IQARDlO7IvBOTJF61eHij3ZRAb1qB-OkeZz1J1jgcXYPZHs?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=UpdDZc)

## Parte II — estruturas de iteração

### 6. Soma de `1` até `N`

Dado um inteiro positivo `N`, calcule a soma de todos os números de `1` até `N`.

Se `N` não for positivo, apresente `VALOR INVALIDO`.

**Estrutura principal:** `for`.

```text
Entrada: 5
Saída: 15
```

[Solução em vídeo](https://tecnologiaidp-my.sharepoint.com/:v:/g/personal/830279_idp_edu_br/IQCKU4uSBkkxQoJxqUf1LLntAXc6cvXiVA4nCMPcJcCQJ3c?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=IJUO4G)

### 7. Tabuada

Dado um número inteiro, apresente sua tabuada de `1` a `10`.

**Estrutura principal:** `for`.

```text
Entrada: 3
Saída:
3 x 1 = 3
3 x 2 = 6
...
3 x 10 = 30
```

[Solução em vídeo](https://tecnologiaidp-my.sharepoint.com/:v:/g/personal/830279_idp_edu_br/IQAjxdo48nR2QK2KJjtowYVKAVjg4IcWDVTP2vPVxExjtE0?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=eiu3ka)

### 8. Contagem regressiva

Dado um inteiro positivo, apresente uma contagem regressiva até zero e, ao final, a mensagem `FIM`.

**Estrutura principal:** `while`.

```text
Entrada: 4
Saída: 4 3 2 1 0 FIM
```

[Solução em vídeo](https://tecnologiaidp-my.sharepoint.com/:v:/g/personal/830279_idp_edu_br/IQAlDFAd61tbQ71UKzHoLEQOAXadBMroBBgDbCjWTU6zmC0?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=zBsXPy)

### 9. Análise dos algarismos

Dado um inteiro não negativo, determine:

- a quantidade de algarismos;
- a soma dos algarismos.

Use divisão inteira por `10` para remover o último algarismo e `% 10` para obtê-lo. Considere que o número `0` possui um algarismo.

**Estrutura principal:** `while`.

```text
Entrada: 5724
Saída: Algarismos: 4 — Soma: 18
```

[Solução em vídeo](https://tecnologiaidp-my.sharepoint.com/:v:/g/personal/830279_idp_edu_br/IQBjPEEmCXvDQpFR6E-sKfRSAbeMyAjuLFkDS2UQA1wJaWU?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=EGfEg1)

### 10. Número primo

Dado um inteiro, informe se ele é primo. Um número primo é maior que `1` e possui exatamente dois divisores positivos: `1` e ele mesmo.

Não é necessário testar divisores maiores que a raiz quadrada do número. A verificação pode continuar enquanto `divisor <= numero / divisor`.

**Estruturas principais:** `for`, `if` e `break`.

```text
Entrada: 29
Saída: PRIMO

Entrada: 21
Saída: NAO PRIMO
```

[Solução em vídeo](https://tecnologiaidp-my.sharepoint.com/:v:/g/personal/830279_idp_edu_br/IQBtwKgHlSLPQoVJrNRFafgmATvCCnm7R3YWU5sNWHBDR3U?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=1421Ge)

### 11. Sequência de Fibonacci

Dada uma quantidade positiva `N`, apresente os primeiros `N` termos da sequência de Fibonacci, iniciada por `0` e `1`.

Cada termo seguinte é a soma dos dois anteriores.

**Estrutura principal:** `for`.

```text
Entrada: 7
Saída: 0 1 1 2 3 5 8
```
[Solução em vídeo](https://tecnologiaidp-my.sharepoint.com/:v:/g/personal/830279_idp_edu_br/IQA59nLDsKptQ7ozdi6aYjvrAWUQyHTn--qszXB7xDgF15c?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=t8bMBb)

## Parte III — seleção e iteração combinadas

### 12. Estatísticas de uma turma

Dada uma sequência de notas inteiras, percorra os valores e produza um resumo.

Regras:

- notas válidas estão entre `0` e `10`;
- ignore notas inválidas usando `continue`;
- classifique notas válidas em:
  - `A`: 9 ou 10;
  - `B`: 7 ou 8;
  - `C`: 5 ou 6;
  - `D`: 0 a 4;
- apresente a quantidade de cada conceito;
- apresente a média das notas válidas;
- apresente quantos valores inválidos foram ignorados.

Use inicialmente este conjunto:

```java
int[] notas = {10, 8, -1, 6, 4, 11, 7};
```

**Estruturas principais:** `for-each`, `if-else`, `continue` e `switch`.

Saída esperada:

```text
Válidas: 5
Inválidas: 2
Média: 7.00
A: 1
B: 2
C: 1
D: 1
```

### 13. Padrão retangular

Dados uma quantidade de linhas e uma quantidade de colunas, desenhe um retângulo usando `*`.

Rejeite dimensões menores ou iguais a zero.

**Estruturas principais:** `if` e laços `for` aninhados.

```text
Entrada: 3 5
Saída:
* * * * *
* * * * *
* * * * *
```
[Solução em vídeo](https://tecnologiaidp-my.sharepoint.com/:v:/g/personal/830279_idp_edu_br/IQCzGPW1o0FARpuBT7gJSWaPAdpVS1-r327R868NWIQzXVY?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=A6CfC4)
