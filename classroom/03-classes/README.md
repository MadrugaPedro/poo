# Prática em sala — classes e objetos

Resolva os exercícios para praticar **abstração**, **classes**, **objetos** e **encapsulamento** em Java.

## Orientações

- Crie um arquivo para cada classe pública indicada.
- Mantenha os atributos de instância `private` e use construtores para estabelecer estados válidos.
- Coloque validações e regras de negócio na classe do domínio, não na classe `App`.
- Crie getters somente para informações consultadas e setters apenas quando a alteração direta fizer sentido.
- Em cada exercício, crie a classe `App` indicada e teste casos válidos, inválidos e de fronteira.

## Parte I — classes, atributos e objetos

### 1. Iluminação de uma loja

Uma loja controla separadamente a iluminação de seus setores. Crie `StoreLight` com `sector` (`String`), `powerInWatts` (`double`) e `on` (`boolean`). O construtor adota `"Setor não informado"` para setor vazio e `10.0` para potência não positiva. Toda iluminação começa desligada. Implemente `turnOn()`, `turnOff()`, `isOn()` e os getters necessários.

Em `StoreLightApp`, crie as iluminações da vitrine e do estoque, ligue somente a vitrine e apresente o estado de ambas.

**Conceitos principais:** classe, objeto, construtor, estado próprio e métodos de instância.

```text
Vitrine: LIGADA
Estoque: DESLIGADA
```

### 2. Orçamento de piso

Uma empresa precisa estimar o piso de ambientes retangulares. Crie `FlooringQuote` com `length`, `width` e `pricePerSquareMeter` (`double`). O construtor adota `1.0` para dimensões não positivas e lança `IllegalArgumentException` para preço não positivo. Implemente getters, `calculateArea()`, `calculateBaseboardLength()` e `calculateTotalPrice()`, mas não setters.

Em `FlooringQuoteApp`, apresente área, metragem de rodapé e preço de um cômodo de `5.0 m × 3.0 m`, com piso a `R$ 80.00/m²`. Demonstre também uma dimensão inválida.

**Conceitos principais:** normalização de argumentos e métodos com retorno.

### 3. Expositor refrigerado

Um mercado monitora expositores que devem permanecer entre `2.0 °C` e `8.0 °C`. Crie `RefrigeratedDisplay` com `temperature` (`double`). Ofereça um construtor sem parâmetros, que inicia em `4.0 °C`, e outro com a temperatura inicial. O primeiro delega ao segundo com `this(...)`. Implemente `setTemperature()`, `getTemperature()` e `isWithinSafeRange()`. Valores inferiores a `-273.15 °C` são ignorados e o estado anterior é mantido.

Em `RefrigeratedDisplayApp`, teste os dois construtores, uma leitura segura, outra fora da faixa e uma alteração fisicamente inválida.

**Conceitos principais:** sobrecarga, delegação com `this(...)` e preservação do estado.

## Parte II — encapsulamento e regras de negócio

### 4. Produto em estoque

Crie `Product` com `name` (`String`), `unitPrice` (`double`) e `quantity` (`int`). Nome vazio, preço ou quantidade inicial negativos provocam `IllegalArgumentException`.

- `addStock(int amount)` acrescenta somente quantidades positivas.
- `removeStock(int amount)` retira somente uma quantidade positiva disponível e informa sucesso com `boolean`.
- `getStockValue()` devolve `unitPrice × quantity`.
- Permita consultas, mas não crie `setQuantity`.

Em `ProductApp`, teste entrada, retirada válida e retirada maior que o estoque.

**Conceitos principais:** encapsulamento, exceção e invariante `quantity >= 0`.

### 5. Ingresso de cinema

Crie `MovieTicket` com `movieTitle` (`String`), `fullPrice` (`double`) e `sold` (`boolean`). Título vazio e preço não positivo provocam `IllegalArgumentException`. Todo ingresso começa disponível. `sell(boolean halfPrice)` vende apenas se disponível e devolve o preço inteiro ou sua metade; se já vendido, devolve `0.0`. Implemente `isSold()`.

Em `MovieTicketApp`, venda um ingresso de meia-entrada e tente vendê-lo novamente.

**Conceitos principais:** abstração, transição de estado e regra protegida pelo objeto.

### 6. Elevador

Crie `Elevator` com `currentFloor`, `topFloor`, `capacity` e `people` (`int`). O construtor recebe último andar e capacidade positivos ou lança `IllegalArgumentException`. O elevador começa vazio no térreo (`0`).

- `enter(int amount)` respeita quantidade positiva e capacidade.
- `exit(int amount)` respeita quantidade positiva e ocupação.
- `goUp()` não ultrapassa o último andar; `goDown()` não passa do térreo.
- Os quatro métodos informam sucesso ou recusa com `boolean`.

Em `ElevatorApp`, demonstre todos os limites, usando laços quando apropriado.

**Conceitos principais:** invariantes, controle de estado, seleção e iteração.

### 7. Programa de fidelidade

Uma empresa oferece pontos aos clientes cadastrados. Crie `LoyaltyCustomer` com `name` (`String`), `points` (`int`) e `active` (`boolean`). Normalize nome vazio para `"Cliente não identificado"`. Todo cliente começa sem pontos e ativo. `earnPoints(int amount)` adiciona pontos positivos a um cadastro ativo. `redeemPoints(int amount)` resgata somente uma quantidade positiva disponível e informa sucesso com `boolean`. `deactivate()` desativa o cadastro; depois disso, não é possível acumular nem resgatar pontos.

Em `LoyaltyCustomerApp`, crie dois clientes, registre pontos, realize um resgate válido, tente um resgate sem saldo e demonstre uma operação após a desativação.

**Conceitos principais:** identidade, independência entre objetos e comportamento condicionado ao estado.

## Parte III — referências e colaboração

### 8. Carteira e transferência

Crie `Wallet` com `owner` (`String`) e `balance` (`double`). Normalize proprietário vazio para `"Sem nome"` e saldo negativo para `0.0`. `addMoney(double amount)` aceita valores positivos; `spend(double amount)` gasta apenas um valor disponível; `transferTo(Wallet destination, double amount)` transfere somente se o destino não é `null`, não é `this` e há saldo. Os dois últimos informam sucesso com `boolean`. Não crie `setBalance`.

Em `WalletApp`, demonstre uma transferência válida, outra sem saldo e outra para `null`.

**Conceitos principais:** colaboração, parâmetro de tipo por referência, `this` e encapsulamento.

### 9. Duas referências, um objeto

Use `LoyaltyCustomer` do exercício 7. Em `LoyaltyCustomerReferenceApp`: guarde um cliente em `original`; atribua-o a `alias`; credite pontos por `alias` e consulte-os por `original`; crie `static void grantPromotionalBonus(LoyaltyCustomer customer, int points)`; em outro método, atribua `new LoyaltyCustomer(...)` ao parâmetro e observe se `original` muda. Explique os resultados em um comentário.

**Conceitos principais:** aliases e passagem por valor de uma referência.

```text
Pontos creditados por alias: 100
Pontos após bônus promocional: 150
Nome após reatribuir o parâmetro: Lara
```

### 10. Máquina de vendas

Crie `VendingMachine` para um item, com `productName` (`String`), `unitPrice` (`double`), `stock` (`int`) e `credit` (`double`). Nome vazio, preço não positivo ou estoque negativo provocam `IllegalArgumentException`. `insertMoney(double amount)` aceita valores positivos; `buy()` compra somente com estoque e crédito suficientes e informa sucesso com `boolean`; `cancel()` devolve o crédito e o zera. Não ofereça setters para estoque ou crédito.

Em `VendingMachineApp`, use `Scanner`, `switch` e um laço com opções para inserir dinheiro, comprar, cancelar e encerrar. Ao encerrar, devolva o crédito restante. Teste compras sem crédito e sem estoque.

**Conceitos principais:** modelagem completa, encapsulamento, invariantes, seleção e iteração.
