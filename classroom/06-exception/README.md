# Prática em sala — tratamento de exceções

Resolva os exercícios para praticar **`try`**, **`catch`**, **`finally`**, **`throw`**, **`throws`** e a criação de exceções específicas em Java.

## Orientações

- Crie uma classe Java com `main` para cada exercício; use métodos auxiliares quando o enunciado pedir.
- Use apenas classes, métodos, condicionais, laços, `Scanner` e os tipos de exceção indicados nos exercícios.
- Uma entrada inválida deve produzir uma mensagem compreensível e não encerrar o programa antes da hora indicada.
- Capture a exceção mais específica possível. Não use `catch (Exception)` para esconder qualquer erro sem necessidade.
- Não use exceções para substituir validações simples que podem ser feitas antes da operação.
- Demonstre pelo menos um caso válido e os casos inválidos solicitados.
- Não é necessário usar coleções, arrays, streams, arquivos, JDBC ou interfaces.

## Parte I — capturando exceções

### 1. Divisão segura

Crie `DivisaoApp` para ler dois números inteiros e apresentar o resultado da divisão inteira. Coloque a operação em um bloco `try` e trate uma divisão por zero com `ArithmeticException`.

Para denominador zero, apresente `DENOMINADOR INVALIDO` e mantenha o programa funcionando até terminar a execução. Teste também uma divisão válida.

**Conceitos principais:** `try`, `catch`, `ArithmeticException` e fluxo após uma exceção.

### 2. Leitura de inteiros

Crie `LeituraInteirosApp` para solicitar um número inteiro usando `Scanner`. Trate `InputMismatchException` quando o usuário digitar texto ou número decimal.

Depois de uma entrada inválida, descarte o valor incorreto e solicite novamente até receber um inteiro. Ao final, apresente o valor lido. Não capture uma exceção genérica para resolver esse caso.

**Conceitos principais:** `InputMismatchException`, repetição, `Scanner.nextLine()` e recuperação após erro.

### 3. Calculadora com múltiplos erros

Crie `CalculadoraExcecoesApp` para ler dois números inteiros e um operador (`+`, `-`, `*` ou `/`). Use um único `try` e blocos `catch` separados para:

- `InputMismatchException`, quando um número não for inteiro;
- `ArithmeticException`, quando houver divisão por zero.

Apresente `OPERADOR INVALIDO` para qualquer operador diferente dos quatro previstos. Organize os `catch` na ordem correta e explique em um comentário por que um `catch (Exception)` não deve vir antes dos específicos.

**Conceitos principais:** múltiplos `catch`, exceções específicas, ordem dos blocos e `switch`.

## Parte II — lançando e propagando exceções

### 4. Validação de idade

Crie o método `static void validarIdade(int idade)`. Ele deve lançar `IllegalArgumentException` com uma mensagem adequada quando a idade for negativa. Para valores válidos, não deve lançar exceção.

Em `IdadeApp`, chame o método com uma idade válida e outra inválida. Capture a exceção no `main` e apresente `IDADE INVALIDA`, sem exibir o stack trace para o usuário.

**Conceitos principais:** `throw`, `IllegalArgumentException`, pré-condição e tratamento no chamador.

### 5. Método que declara a possibilidade de falha

Crie `ConversorApp` com o método `static int converter(String texto) throws NumberFormatException`. Use `Integer.parseInt` para converter o texto.

No `main`, teste um texto numérico e um texto inválido. Deixe o método apenas declarar a possibilidade de erro e faça o `catch` no `main`, apresentando `NUMERO INVALIDO`.

Em um comentário, explique a diferença entre `throw`, que lança uma exceção, e `throws`, que declara uma exceção na assinatura do método.

**Conceitos principais:** `throws`, propagação de exceções e `NumberFormatException`.

### 6. Repetir até concluir uma operação

Crie `CadastroNotaApp` para ler uma nota entre `0` e `10`. O método `static double lerNota(Scanner scanner) throws InputMismatchException` deve realizar a leitura e devolver a nota, mas deve lançar `IllegalArgumentException` quando o número estiver fora do intervalo.

No `main`, use um laço para tentar novamente quando ocorrer `InputMismatchException` ou `IllegalArgumentException`. Ao aceitar a nota, apresente `NOTA REGISTRADA`.

Não altere o estado de uma nota já registrada quando uma tentativa inválida ocorrer.

**Conceitos principais:** combinação de `throw` e `throws`, múltiplos `catch`, laço de recuperação e validação.

## Parte III — garantindo comportamentos e limpeza

### 7. `finally` sempre executado

Crie `ProcessamentoApp` com um método que receba dois inteiros, tente dividi-los e apresente três mensagens: `INICIO`, o resultado quando possível e `FIM DO PROCESSAMENTO`.

O `FIM DO PROCESSAMENTO` deve ficar em um bloco `finally`, para ser exibido tanto em uma divisão válida quanto após uma divisão por zero. Capture `ArithmeticException` e apresente uma mensagem amigável.

Teste os dois caminhos e observe que o `finally` é executado depois do `try` ou do `catch`.

**Conceitos principais:** `finally`, ordem de execução e limpeza de um fluxo de operação.

### 8. Operação de carteira

Crie uma classe `Carteira` com titular e saldo. O saldo inicial negativo deve ser normalizado para zero. Implemente `depositar(double valor)` e `sacar(double valor)`.

Regras:

- depósito e saque exigem valor positivo;
- o saque não pode superar o saldo;
- uma operação recusada não pode alterar o saldo.

Use `IllegalArgumentException` para valor não positivo e crie `SaldoInsuficienteException`, derivada de `Exception`, para saldo insuficiente. Em `CarteiraApp`, trate as duas situações separadamente e apresente o saldo final.

**Conceitos principais:** exceção personalizada, `extends Exception`, invariantes, `throw` e `throws`.

## Parte IV — aplicação integrada

### 9. Menu de operações

Crie `MenuOperacoesApp` com um menu repetido por laço:

```text
1 - Dividir dois números
2 - Converter texto em inteiro
0 - Sair
```

Cada opção deve chamar um método próprio. Trate `InputMismatchException` quando a opção ou os números não forem inteiros, `ArithmeticException` na divisão por zero e `NumberFormatException` na conversão de texto.

Após qualquer erro, mostre uma mensagem, descarte a entrada inválida quando necessário e volte ao menu. O programa deve encerrar somente quando o usuário escolher `0`.

**Conceitos principais:** menu, métodos, laços, exceções específicas e recuperação do fluxo.

### 10. Reserva de sala

Crie uma classe `ReservaSala` com sala, horário inicial e horário final. Uma reserva deve rejeitar:

- sala não informada;
- horário inicial ou final negativo;
- horário final menor ou igual ao inicial;
- tentativa de reservar uma sala que já está ocupada.

Crie `ReservaInvalidaException`, derivada de `Exception`, para regras de reserva e faça os métodos declararem `throws` quando necessário. Em `ReservaSalaApp`, tente criar uma reserva válida, uma com horário inválido e outra para uma sala já ocupada.

Cada falha deve ser tratada sem apagar a reserva válida já criada. Ao final, apresente a reserva confirmada e uma mensagem para cada tentativa recusada.

**Conceitos principais:** exceção de domínio, estado do objeto, propagação, tratamento no ponto adequado e preservação de estado.
