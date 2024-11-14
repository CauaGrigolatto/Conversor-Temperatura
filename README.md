# Conversor de Temperatura

Este projeto é um aplicativo de conversão de temperatura desenvolvido em Kotlin. Ele permite ao usuário converter temperaturas entre graus Celsius, Fahrenheit e Kelvin. O aplicativo utiliza os padrões de design Singleton e Strategy e organiza seu código em pacotes `model` e `view` para melhor divisão de responsabilidades. O layout foi desenvolvido utilizando o `ConstraintLayout`.

## Funcionalidades

- Conversão entre Celsius, Fahrenheit e Kelvin
- Interface intuitiva e simples para facilitar a interação do usuário

## Estrutura do Projeto

O projeto está organizado em pacotes para separar as responsabilidades:

- **model**: contém a lógica de conversão de temperatura e a implementação dos padrões de design.
- **view**: contém o código relacionado à interface do usuário e às atividades do aplicativo.

## Design Patterns Utilizados

### Singleton

O padrão Singleton é utilizado para garantir que haja uma única instância da lógica de conversão de temperatura, assegurando consistência e melhor uso de recursos.

### Strategy

O padrão Strategy é utilizado para definir diferentes estratégias de conversão (Celsius para Fahrenheit, Fahrenheit para Celsius, Celsius para Kelvin, etc.), permitindo a troca fácil entre métodos de conversão.

## Tecnologias e Ferramentas

- **Linguagem**: Kotlin
- **Design Pattern**: Singleton, Strategy
- **Layout**: ConstraintLayout
