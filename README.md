<div align="center">

![](https://img.shields.io/badge/Status-Em%20Desenvolvimento-orange)
</div>

<div align="center">

# POC - Observability com Springboot e Java
Trata-se de uma aplicação de prova de conceito para aplicar Observability utilizando Spring boot e Java

![](https://img.shields.io/badge/Autor-Wesley%20Oliveira%20Santos-brightgreen)
![](https://img.shields.io/badge/Language-java-brightgreen)
![](https://img.shields.io/badge/Framework-springboot-brightgreen)

<b>Ferramentas de Observability</b>

![](https://img.shields.io/badge/Tracing%20Distribuído-Jaeger-brightgreen)
![](https://img.shields.io/badge/Monitoramento%20e%20alertas-Prometheus-brightgreen)
![](https://img.shields.io/badge/Análise%20e%20Monitoramento-Grafana-brightgreen)

</div>

## Fundamentos teóricos

- ### Jaeger
  > Jaeger é um software open source para rastreamento de transações entre serviços distribuídos. Ele é usado para monitorar e solucionar problemas em ambientes de microsserviços complexos.
- ### Prometheus
  > Prometheus é um sistema de monitoramento para serviços e aplicações. Ele coleta as métricas de seus alvos em determinados intervalos, avalia expressões de regras, exibe os resultados e também pode acionar alertas se alguma condição for observada como verdadeira.
- ### Grafana
  > Grafana é uma aplicação web de análise de código aberto multiplataforma e visualização interativa da web. Ele fornece tabelas, gráficos e alertas para a Web quando conectado a fontes de dados suportadas. É expansível através de um sistema de plug-in.
- ### Springboot
  > O Spring Boot é um projeto da Spring que veio para facilitar o processo de configuração e publicação de nossas aplicações. A intenção é ter o seu projeto rodando o mais rápido possível e sem complicação.
- ### Java
  > Java é uma linguagem de programação orientada a objetos desenvolvida na década de 90 por uma equipe de programadores chefiada por James Gosling, na empresa Sun Microsystems. Em 2008 o Java foi adquirido pela empresa Oracle Corporation.

## Tecnologias
- Java 11
- Spring Boot 2.5.0
    - spring-boot-starter-actuator
    - spring-boot-starter-web
    - spring-boot-starter-data-jpa
    - opentracing-spring-jaeger-web-starter
    - opentracing-jdbc
    - micrometer-registry-prometheus
    - spring-boot-devtools
    - mapstruct
    - flyway-core
    - postgresql
    - lombok
- Tomcat (Embedded no Spring Boot)
- Git

## Execução

- Scripts
  ### Executar docker-compose
    - 1° comando: ``` cd src/main/docker/```
    - 2° comando: ```docker-compose -f docker-compose.yml up```
  ### Executar a aplicação
    -  ```./mvnw clean compile spring-boot:run```

## Utilização

- ### Jaeger
        http://localhost:16686/
  - Na opção service podemos selecionar a o microserviço e clicar no find trances e será retornado os traces da aplicação.
    ![Jaeger](images/jaeger.png "Jaeger")
- ### Prometheus
        http://localhost:9090/
  - O Prometeus disponibiliza a funções, onde por exemplo a *http_server_requests_seconds_count* que disponibiliza a quantidade de request em um determinado recurso do microserviço, além de demonstrar em formato de tabela e gráfico.
    ![Prometeus-tabela](images/prometeus-tabela.png "Prometeus-tabela")
    ![Prometeus-grafico](images/prometeus-grafico.png "Prometeus-grafico")
    
  - O Prometeus também disponibiliza a funcão de verificar a status do microserviço a partir do menu superior status.
    ![Prometeus-status](images/prometeus-status.png "Prometeus-status")
    
- ### Grafana
        http://localhost:3000/login
        Email or username: admin
        Password: admin
  - Tela de Login
  ![Grafana-login](images/grafana-login.png "Grafana-login")
  - Tela inicial
  ![Grafana-inicio](images/grafana-inicio.png "Grafana-inicio")
  - Criação dos Data Source Jager
    - 1° Clique em Add data source
    - 2° Selecione a opção de Jaeger
    ![Grafana-jaeger-datasource](images/grafana-jaeger-datasource.PNG "Grafana-jaeger-datasource")