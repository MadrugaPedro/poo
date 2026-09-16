# Prática em sala — arrays em Java

Resolva os exercícios para praticar **criação**, **acesso**, **percorrer arrays**, **arrays de objetos**, **arrays bidimensionais**, **varargs** e a classe `Arrays`.

## Orientações

- Crie uma classe Java com `main` para cada exercício; use métodos auxiliares quando o enunciado pedir.
- Comece com os dados indicados. Depois teste outros valores, inclusive os casos de fronteira.
- Use somente arrays, laços, condicionais, métodos e classes já estudados. Não use coleções nem streams.
- Verifique `length` antes de acessar um índice ou calcular uma média. Não capture exceções para substituir uma validação simples.
- Quando o objetivo for praticar um algoritmo, não o substitua por um método pronto de `java.util.Arrays`.
- Compare sua saída com os exemplos; a apresentação pode variar, desde que os resultados estejam corretos.

## Parte I — criação e como percorrer arrays

### 1. Índices e valores

Crie `int[] valores = {32, 27, 64, 18, 95}`. Apresente cada índice e seu valor usando um `for` com índice. Depois apresente o primeiro e o último valor sem escrever o índice final como número fixo.

Teste também um array com apenas um elemento. Explique por que tentar acessar `valores[valores.length]` é inválido.

**Conceitos principais:** índice inicial zero, `length` e limite `length - 1`.

### 2. Soma e média de notas

Percorra `int[] notas = {8, 6, 10, 7, 9}` e apresente soma e média com duas casas decimais. Passe pelos elementos novamente com `for-each` e compare os resultados. Se o array estiver vazio, apresente `SEM NOTAS` em vez de dividir por zero.

```text
Soma: 40
Média: 8.00
```

**Conceitos principais:** acumulação, `for-each`, array vazio e divisão real.

### 3. Maior, menor e suas posições

Para `int[] temperaturas = {23, 18, 26, 18, 21}`, encontre o maior e o menor valor e o índice da **primeira ocorrência** de cada um. Não use `Arrays.sort`. Para um array vazio, apresente `SEM TEMPERATURAS`.

```text
Maior: 26 (índice 2)
Menor: 18 (índice 1)
```

**Conceitos principais:** percorrer o array por índice e inicialização a partir do primeiro elemento.

### 4. Busca sem ultrapassar o limite

Crie um método `static int buscar(int[] valores, int alvo)` que devolva o índice da primeira ocorrência do alvo ou `-1` se ele não aparecer. Verifique o resultado para o array `{4, 7, 4, 9}` com os alvos `4`, `9` e `5`.

Antes de acessar uma posição solicitada pelo usuário, confirme que ela está entre `0` e `length - 1`; para posição inválida, apresente `INDICE INVALIDO`.

**Conceitos principais:** busca linear, sentinela `-1` e validação de índice.

### 5. Frequência e gráfico de barras

O array `int[] resultados = {1, 3, 2, 1, 6, 3, 1}` contém resultados de lançamentos de dado. Crie um array de seis contadores e contabilize quantas vezes saiu cada face. Imprima uma linha por face usando `*` para representar a frequência.

```text
1: ***
2: *
3: **
4:
5:
6: *
```

Teste também um resultado inválido, como `0` ou `7`: ignore-o e conte quantos registros foram ignorados.

**Conceitos principais:** array de frequências, mapeamento `face - 1` e validação.

## Parte II — cópias, métodos e objetos

### 6. Inversão sem modificar o original

Escreva `static int[] inverter(int[] origem)` que crie **outro** array com os elementos na ordem inversa. Para `{2, 4, 6, 8}`, o resultado deve ser `{8, 6, 4, 2}`, enquanto `origem` permanece `{2, 4, 6, 8}`. Teste arrays de tamanho zero e um.

**Conceitos principais:** tamanho fixo, criação de array e independência da cópia.

### 7. Alteração por parâmetro

Escreva `static void dobrarPrimeiro(int[] numeros)` que dobre o primeiro elemento somente se o array não estiver vazio. No `main`, mostre o array antes e depois da chamada. Em outro método, atribua `numeros = new int[] {99}` e observe se essa atribuição troca a referência mantida pelo `main`.

Explique, em um comentário, a diferença entre **alterar um elemento** e **reatribuir o parâmetro**.

**Conceitos principais:** referências de arrays e passagem por valor da referência.

### 8. Produtos em um array de objetos

Crie uma classe `Produto` com nome e preço não negativo, construtor e métodos de consulta. No `main`, guarde três produtos em `Produto[]`; percorra o array para exibir seus nomes e calcular a soma dos preços. Em uma segunda execução, deixe uma posição sem objeto e trate `null` antes de acessar seus métodos.

Não use `ArrayList`. Diferencie, em um comentário, a posição do array do objeto armazenado nessa posição.

**Conceitos principais:** array de referências, criação de objetos e posição `null`.

## Parte III — duas dimensões e API

### 9. Vendas por loja e dia

Considere `int[][] vendas = {{10, 12, 8}, {7, 9, 11}}`, em que cada linha representa uma loja e cada coluna, um dia. Apresente o total de cada loja, o total de cada dia e o total geral. Use `vendas.length` para linhas e `vendas[linha].length` para colunas.

```text
Loja 1: 30
Loja 2: 27
Dia 1: 17
Dia 2: 21
Dia 3: 19
Total geral: 57
```

**Conceitos principais:** índices linha/coluna e laços aninhados.

### 10. Linhas de tamanhos diferentes

Considere `int[][] respostas = {{1, 0, 1}, {0}, {1, 1}}`. Apresente, para cada linha, a quantidade de respostas e a soma de seus valores. Acrescente uma linha vazia e mantenha o programa funcionando. Não suponha que todas as linhas tenham o tamanho da primeira.

**Conceitos principais:** array de arrays e linhas irregulares.

### 11. Quantidade variável de argumentos

Escreva `static double media(double... valores)`. A chamada `media(4, 6, 8)` deve devolver `6.0`; `media(10)`, `10.0`. Defina e documente um comportamento para `media()` antes de implementar — por exemplo, lançar `IllegalArgumentException` — e teste esse caso.

**Conceitos principais:** varargs, array recebido pelo método e pré-condição.

### 12. Utilitários de `java.util.Arrays`

Comece com `int[] numeros = {4, 1, 3, 2}`. Use `Arrays.toString` para exibir, `Arrays.copyOf` para criar uma cópia com seis posições, `Arrays.sort` para ordenar o original e `Arrays.binarySearch` para localizar `3` **após** a ordenação. Use `Arrays.equals` para comparar com `{1, 2, 3, 4}` e `Arrays.fill` para preencher a cópia com `7`.

Apresente os arrays depois de cada operação e responda: por que `numeros == new int[] {1, 2, 3, 4}` não compara seus elementos?

**Conceitos principais:** operações prontas, cópia, ordenação e igualdade de conteúdo.
