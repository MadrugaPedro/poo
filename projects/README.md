# Projeto Autoral de Programação Orientada a Objetos

## Objetivo

Desenvolver, individualmente, uma aplicação Java para resolver um problema de um domínio de negócio de sua escolha. 

Para isso, você deve definir o problema, identificar suas regras de negócio, tomar decisões de modelagem orientada a objetos e implementar o programa.

O domínio é livre. Alguns exemplos são: biblioteca, clínica, oficina, escola, eventos, entregas, comércio, hotelaria, esportes ou finanças pessoais. Escolha um problema que possua diferentes entidades, comportamentos e regras. Não é permitido apenas trocar os nomes das classes de um exemplo apresentado em aula.

> O objetivo não é construir um sistema completo ou uma interface sofisticada. A avaliação se concentra na qualidade da modelagem, no comportamento dos objetos e na aplicação consciente dos conceitos estudados.

## Definição do problema

Antes da implementação, crie um arquivo `PROJETO.md` contendo:

1. nome e breve descrição do domínio escolhido;
2. problema que a aplicação pretende resolver;
3. público ou usuário interessado na solução;
4. pelo menos **três casos de uso** oferecidos pela aplicação;
5. pelo menos **cinco regras de negócio**;
6. diagrama de classes com atributos, métodos e relacionamentos principais;
7. decisões de modelagem, explicando onde e por que foram empregados conceitos de orientação a objetos como abstração, encapsulamento, herança e polimorfismo.

Exemplo de regra de negócio: “um empréstimo não pode ser realizado quando o exemplar estiver indisponível”. Evite descrever como regra apenas uma operação genérica, como “o sistema deve cadastrar clientes”.

## Requisitos obrigatórios

### 1. Estrutura da aplicação

- Utilizar Java 21.
- Criar pelo menos **quatro classes de domínio**, além da classe que contém o método `main`.
- Criar uma classe como ponto de entrada da aplicação, com o método `public static void main(String[] args)`.
- Organizar cada classe pública em seu próprio arquivo `.java`.
- Manter as regras de negócio nas classes responsáveis pelo domínio. A classe principal deve coordenar a demonstração da aplicação, sem concentrar toda a lógica.
- Implementar e demonstrar os três casos de uso descritos no `PROJETO.md`.

### 2. Modelagem orientada a objetos

A solução deve demonstrar os quatro pilares da orientação a objetos:

- **Abstração:** representar conceitos relevantes do domínio por meio de classes e métodos com responsabilidades claras. Utilizar ao menos uma classe abstrata ou interface que defina um contrato significativo para o problema.
- **Encapsulamento:** manter atributos de instância privados e proteger o estado dos objetos. Alterações devem ocorrer por métodos que validem e preservem as regras de negócio. Não crie métodos `set` indiscriminadamente.
- **Herança:** criar pelo menos uma superclasse e duas subclasses que representem uma relação legítima do tipo “é um”. As subclasses devem especializar estado ou comportamento; não basta que estejam vazias.
- **Polimorfismo:** sobrescrever pelo menos um método e demonstrar, durante a execução, a chamada desse método por uma referência do tipo da superclasse ou interface, produzindo comportamentos diferentes conforme o objeto concreto.

Também é obrigatório:

- utilizar construtores para criar objetos em estados válidos;
- modelar pelo menos um relacionamento entre objetos, por associação, agregação ou composição;
- sobrescrever `toString()` em pelo menos duas classes de domínio;
- utilizar ao menos um **membro de classe** (`static`) com finalidade coerente, como gerar identificadores, armazenar uma constante compartilhada ou contabilizar instâncias. O método `main` não satisfaz este requisito sozinho.

### 3. Controle de fluxo e dados

- Utilizar pelo menos **duas estruturas de seleção diferentes** entre `if/else`, `switch` e operador condicional `?:`. Cada uma deve participar de uma decisão relevante da aplicação.
- Utilizar pelo menos **duas estruturas de repetição diferentes** entre `for`, `for-each`, `while` e `do-while`. Cada uma deve possuir uma finalidade clara.
- Utilizar pelo menos uma coleção genérica, como `ArrayList`, `HashSet` ou `HashMap`, para armazenar objetos do domínio.
- Percorrer uma coleção polimórfica, tipada pela superclasse ou interface, e executar um comportamento sobrescrito.
- Realizar ao menos uma operação de busca, filtro, totalização ou consolidação sobre os objetos armazenados.

Repetições ou decisões artificiais, duplicadas apenas para alcançar a quantidade mínima, não serão consideradas.

### 4. Validação e tratamento de erros

- Validar os dados que possam violar as regras de negócio.
- Lançar e tratar pelo menos uma exceção em uma situação de erro prevista pela aplicação.
- Exibir mensagens claras quando uma operação não puder ser concluída.
- Demonstrar no programa pelo menos um cenário válido, um cenário inválido e um caso de fronteira.

### 5. Execução

A aplicação deve executar pelo terminal e permitir que todos os requisitos sejam verificados. A interação pode ocorrer por um menu de texto ou por uma sequência de demonstração preparada no método `main`.

A saída deve identificar claramente:

- os casos de uso executados;
- os dados utilizados;
- o resultado de cada operação;
- os erros tratados sem encerramento inesperado do programa.

Interface gráfica, banco de dados e bibliotecas externas são opcionais e não concedem pontuação por si sós.

## Organização e entrega

Crie sua solução na estrutura abaixo:

```text
projects/
└── submissions/
    └── nome-sobrenome/
        ├── PROJETO.md
        └── src/
            ├── NomeDaAplicacao.java
            └── ...
```

O arquivo `PROJETO.md` também deve apresentar uma matriz que indique onde cada requisito pode ser encontrado:

| Requisito | Classe/arquivo | Método ou linha | Justificativa breve |
|---|---|---|---|
| Polimorfismo | `Exemplo.java` | `processar()` | A chamada usa o tipo abstrato e varia conforme a subclasse. |

Antes da entrega:

1. compile todo o código da submissão;
2. execute a aplicação e verifique todos os cenários;
3. faça commit das alterações no seu repositório;
4. abra um pull request para o repositório principal;
5. envie o link do pull request no ambiente virtual.

Exemplo de compilação e execução, substituindo os nomes quando necessário:

```bash
cd projects/submissions/nome-sobrenome
mkdir -p bin
javac -d bin src/*.java
java -cp bin NomeDaAplicacao
```

Não envie arquivos compilados (`.class`) nem inclua senhas, tokens ou outros dados pessoais no repositório.

## Critérios de avaliação

| Critério | Valor | Evidências esperadas |
|---|---:|---|
| Definição do problema e regras de negócio | 1,0 | Problema compreensível, três casos de uso e cinco regras coerentes. |
| Modelagem e responsabilidades | 2,0 | Classes de domínio relevantes, relacionamentos adequados e lógica distribuída de forma coerente. |
| Abstração, herança e polimorfismo | 2,0 | Hierarquia justificável, contrato abstrato, sobrescrita e chamada polimórfica em execução. |
| Encapsulamento e estado válido | 1,5 | Atributos privados, construtores e métodos que protegem invariantes do domínio. |
| Controle de fluxo, coleções e membro de classe | 1,5 | Seleções e repetições variadas, coleção de objetos, processamento de dados e uso coerente de `static`. |
| Validação e tratamento de erros | 1,0 | Cenários inválidos previstos, exceção lançada/tratada e mensagens claras. |
| Funcionamento, organização e documentação | 1,0 | Código compilável, casos demonstráveis, nomes claros, diagrama e matriz de rastreabilidade. |
| **Total** | **10,0** | |

O simples uso de uma construção da linguagem não garante a pontuação correspondente. Ela será considerada quando contribuir de modo coerente para a solução do problema definido.

## Restrições

- O trabalho deve ser autoral e o estudante deve ser capaz de explicar qualquer trecho entregue.
- O domínio, as regras e a modelagem não podem ser cópias de atividades, provas ou exemplos do repositório.
- Não serão aceitas soluções que implementem todos os comportamentos diretamente no `main`.
- Código que não compilar terá sua avaliação limitada aos elementos que puderem ser inspecionados de forma estática.

## Roteiro para apresentação

Durante a apresentação, o estudante deverá:

1. explicar o problema e as regras de negócio escolhidas;
2. apresentar o diagrama e as responsabilidades das classes;
3. executar os três casos de uso;
4. localizar no código as evidências indicadas na matriz de requisitos;
5. justificar as escolhas de herança, polimorfismo e membro de classe.
