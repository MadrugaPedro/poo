# Projeto Autoral de Programação Orientada a Objetos

## Objetivo

Desenvolver, individualmente, uma aplicação Java para resolver um problema de um domínio de negócio de sua escolha.

Alguns exemplos são: biblioteca, clínica, oficina, escola, eventos, entregas, comércio, hotelaria, esportes ou finanças pessoais. Não é permitido apenas trocar os nomes das classes de um exemplo apresentado em aula.

> Não é necessário construir uma interface sofisticada ou um sistema completo.

## Definição do projeto

Antes da implementação, crie um arquivo `README.md` contendo:

1. nome e breve descrição do domínio;
2. pelo menos **três casos de uso** da aplicação;
3. pelo menos **cinco regras de negócio**;
4. diagrama de classes com atributos, métodos e relacionamentos com uma ferramenta de sua escolha.

A imagem do diagrama deve ser salva em `doc/diagrama-classes.png` e incorporada ao `README.md`:

```markdown
![Diagrama de classes](doc/diagrama-classes.png)
```

Exemplo de regra de negócio: “um empréstimo não pode ser realizado quando o exemplar estiver indisponível”. Operações genéricas, como “cadastrar clientes”, não são consideradas regras de negócio.

## Requisitos obrigatórios

### Estrutura e modelagem

- Utilizar Java 21.
- Criar pelo menos **quatro classes de domínio**, além da classe que contém o método `main`.
- Organizar cada classe pública em seu próprio arquivo `.java`.
- Implementar e demonstrar os três casos de uso descritos no `README.md`.
- Manter os atributos de instância privados e proteger o estado dos objetos por meio de construtores e métodos adequados.
- Manter as regras de negócio nas classes do domínio, sem concentrar toda a lógica no `main`.
- Modelar pelo menos um relacionamento entre objetos por associação, agregação ou composição.
- Sobrescrever `toString()` em pelo menos duas classes de domínio.
- Utilizar pelo menos um membro de classe (`static`) com finalidade coerente. O método `main` não satisfaz este requisito sozinho.

### Herança e polimorfismo

- Criar uma superclasse e pelo menos duas subclasses que representem uma relação legítima do tipo “é um”.
- Fazer com que as subclasses especializem estado ou comportamento da superclasse.
- Sobrescrever pelo menos um método nas subclasses.
- Demonstrar uma chamada polimórfica por meio de uma referência do tipo da superclasse.
- Utilizar classe abstrata ou interface apenas quando essa escolha for coerente com o domínio.

### Controle de fluxo e dados

- Utilizar pelo menos **duas estruturas de seleção diferentes** entre `if/else`, `switch` e operador condicional `?:`.
- Utilizar pelo menos **duas estruturas de repetição diferentes** entre `for`, `for-each`, `while` e `do-while`.
- Utilizar pelo menos um array para armazenar objetos do domínio.
- Percorrer um array tipado pela superclasse e executar um comportamento sobrescrito.
- Realizar pelo menos uma operação de busca, filtro, totalização ou consolidação dos dados.

As estruturas devem participar de decisões e operações relevantes. Código repetido ou artificial, criado apenas para alcançar a quantidade mínima, não será considerado.

### Validação e execução

- Validar dados que possam violar as regras de negócio.
- Impedir operações inválidas e exibir mensagens claras para o usuário.
- Demonstrar pelo menos um cenário válido, um inválido e um caso de fronteira.
- Executar a aplicação pelo terminal, por meio de um menu de texto ou de uma sequência de demonstração no `main`.

Interface gráfica, banco de dados e bibliotecas externas são opcionais e não concedem pontuação por si sós.

## Organização e entrega

Crie sua solução na estrutura abaixo:

```text
projects/
└── submissions/
    └── nome-sobrenome/
        ├── README.md
        ├── doc/
        │   └── diagrama-classes.png
        └── src/
            ├── NomeDaAplicacao.java
            └── ...
```

Antes da entrega, compile e execute todo o código da submissão:

```bash
cd projects/submissions/nome-sobrenome
mkdir -p bin
javac -d bin src/*.java
java -cp bin NomeDaAplicacao
```

Depois, faça commit das alterações, abra um pull request para o repositório principal e envie o link no ambiente virtual.

Não envie arquivos compilados (`.class`) nem inclua senhas, tokens ou dados pessoais no repositório.

## Critérios de avaliação

| Critério | Valor | Evidências esperadas |
|---|---:|---|
| Problema e regras de negócio | 0,30 | Domínio compreensível, três casos de uso e cinco regras coerentes. |
| Modelagem e responsabilidades | 0,60 | Classes relevantes, relacionamentos adequados e responsabilidades bem distribuídas. |
| Herança e polimorfismo | 0,60 | Hierarquia coerente, sobrescrita e chamada polimórfica em execução. |
| Encapsulamento e estado válido | 0,45 | Atributos privados, construtores e métodos que protegem as regras do domínio. |
| Controle de fluxo, arrays e membro de classe | 0,45 | Seleções e repetições variadas, processamento de objetos em array e uso coerente de `static`. |
| Validação | 0,30 | Cenários inválidos previstos e mensagens claras. |
| Funcionamento, organização e documentação | 0,30 | Código compilável, casos demonstráveis, nomes claros e diagrama coerente. |
| **Total** | **3,00** | |

## Apresentação

O estudante deverá explicar o problema e a modelagem, executar os três casos de uso e localizar no código os principais requisitos. Também deverá ser capaz de justificar qualquer trecho entregue.
