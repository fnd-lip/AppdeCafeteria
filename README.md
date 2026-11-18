
# App de Cafeteria ☕

Aplicativo Android desenvolvido em Kotlin com Jetpack Compose para simular a experiência de compra em uma cafeteria.

O projeto apresenta um catálogo de produtos, pesquisa por nome, seleção de quantidades, gerenciamento do carrinho e visualização do valor total da compra.

## Funcionalidades

- Catálogo de cafés, cappuccinos e sobremesas.
- Pesquisa de produtos por nome.
- Seleção de quantidade de cada produto.
- Adição e remoção de produtos do carrinho.
- Atualização da quantidade de itens e do valor total.
- Navegação entre catálogo, carrinho e pagamento.
- Interface construída com Jetpack Compose e Material 3.

## Tecnologias utilizadas

| Tecnologia | Utilização |
|---|---|
| Kotlin | Linguagem de programação |
| Jetpack Compose | Construção declarativa da interface |
| Material 3 | Componentes visuais e temas |
| Navigation Compose | Navegação entre telas |
| ViewModel | Gerenciamento de estado |
| Dagger Hilt | Injeção de dependências |
| Kotlin Coroutines | Execução de operações no ViewModel |
| Gradle Kotlin DSL | Configuração do projeto |

## Arquitetura

O projeto utiliza uma organização inspirada no padrão MVVM (Model-View-ViewModel), com separação entre interface, gerenciamento de estado e acesso aos dados.

### Fluxo de dados

```text
UI (Jetpack Compose)
        |
        v
CarrinhoViewModel
        |
        v
CarrinhoRepositorio
        |
        v
DataSource
```

O ViewModel atua como intermediário entre as telas e os dados do aplicativo.

A lista de produtos é fornecida por uma fonte de dados local, enquanto o estado do carrinho é mantido no ViewModel.

### Decisões de arquitetura

**1. Jetpack Compose para a interface**

Escolhido para construir telas de maneira declarativa, com componentes reutilizáveis e atualização da interface conforme o estado.

**2. ViewModel para centralizar o estado**

O `CarrinhoViewModel` concentra as operações de adição, remoção e cálculo do total dos produtos.

Uma mesma instância do ViewModel é compartilhada entre as telas, mantendo o carrinho consistente durante a navegação.

**3. Repository para separar responsabilidades**

O `CarrinhoRepositorio` faz a intermediação entre o ViewModel e a fonte de dados.

Essa separação facilita alterações futuras na origem das informações sem concentrar o acesso aos dados na interface.

**4. Dagger Hilt para injeção de dependências**

Utilizado para fornecer automaticamente as dependências do ViewModel e do repositório.

A solução reduz o acoplamento entre componentes e evita instanciações manuais dessas dependências.

**5. Navigation Compose para navegação**

A navegação utiliza um `NavHost` com três destinos:

- `Home`: catálogo e pesquisa de produtos.
- `Carrinho`: produtos selecionados e total.
- `Pagamento`: apresentação do valor final.

**6. Dados locais para simplificar o projeto**

O catálogo é definido em `DataSource.kt`, sem depender de servidor ou API externa.

Essa abordagem mantém o foco no aprendizado de Kotlin, Compose e gerenciamento de estado.

## Estrutura do projeto

```text
com.felipe.appdecafeteria/
|
|-- datasource/
|   `-- DataSource.kt
|
|-- itemlista/
|   `-- ProdutoItem.kt
|
|-- model/
|   |-- Produto.kt
|   `-- Carrinho.kt
|
|-- repositorio/
|   `-- CarrinhoRepositorio.kt
|
|-- screens/
|   |-- Home.kt
|   |-- Carrinho.kt
|   `-- Pagamento.kt
|
|-- ui/theme/
|   |-- Color.kt
|   |-- Theme.kt
|   `-- Type.kt
|
|-- viewmodel/
|   `-- CarrinhoViewModel.kt
|
|-- App.kt
`-- MainActivity.kt
```

## Gerenciamento de estado

O carrinho utiliza estados observáveis do Jetpack Compose:

- `mutableStateListOf`: mantém a lista de produtos adicionados.
- `mutableIntStateOf`: acompanha a quantidade de itens.
- `rememberSaveable`: preserva estados locais de quantidade e preço nas condições suportadas pelo Compose.

O total é calculado a partir dos valores registrados no carrinho.

## Limitações atuais

Este é um aplicativo demonstrativo, sem integração com serviços externos.

- Os produtos são cadastrados localmente.
- O carrinho não possui persistência em banco de dados.
- A tela de pagamento apresenta somente o valor final.
- Não existe processamento de pagamentos reais.
- Os preços são representados por strings e convertidos para `Double`; uma evolução seria usar valores monetários em centavos para evitar problemas de precisão.

## Como executar

1. Clone o repositório.
2. Abra o projeto no Android Studio.
3. Aguarde a sincronização do Gradle.
4. Configure um emulador Android ou conecte um dispositivo.
5. Execute o módulo `app`.

**Requisito mínimo:** Android 7.0 (API 24).

## Objetivo do projeto

Praticar o desenvolvimento Android explorando interfaces declarativas, gerenciamento de estado, navegação, injeção de dependências e separação de responsabilidades.

O APP foi desenvolvido como um projeto de aprendizado.