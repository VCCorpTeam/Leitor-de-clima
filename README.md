<img src= "https://github.com/VCCorpTeam/Leitor-de-clima/assets/119015786/44e1f9c1-8c06-4124-8ac7-385e77cc95d6"/>

<p align="center">
   <a href="#sobre-o-projeto">Sobre o projeto</a> • 
   <a href="#calendario-sprints">Calendário Sprints</a> • 
   <a href="#product-backlog">Product Backlog</a> •
   <a href="#user-stories">User Stories</a> •
   <a href="#tecnologias">Tecnologias</a> •
   <a href="#ferramentas">Ferramentas</a> •
   <a href="#integrantes">Integrantes</a>
</p>

<span id="Sobre nós">

## :dart: Sobre nós 

<i>"Na Fatec - SJC, um grupo de estudantes se uniu para o projeto integrador e se autodenominou Vira-lata Caramelo Corp! Por quê? Como todo nome, há profundidade nos significados:
<br>1º.Para estampar no peito o orgulho de ser brasileiro! (E o cão tão querido representa isso perfeitamente.) </br>
<br>2º.Pois a tecnologia tem limitações, e nem sempre as condições estão a nosso favor, é preciso saber se virar!"</br></i>

# <h2>Sobre o projeto 💬</h2>
Esse projeto o qual estamos dispostos a fazer se trata de, através da linguagem Java e o uso de Banco de Dados SQL, criar um sistema que leia e interprete arquivos CSV com dados climáticos de certas cidades e regiões do estado de São Paulo e elaborar relatórios em texto sobre as médias das temperaturas, umidades, quantidade de chuva, etc... Além disso, serão feitos gráficos boxplot desses relatórios finais para uma abordagem mais visual dos dados.

# <h2>Calendário Sprints 🗓️</h2>

| Sprints | Tempo de entrega               |
|---------|-------------------------------|
| 1       | 25/03/2024 a 14/04/2024       |
| 2       | 15/04/2024 a 05/05/2024       |
| 3       | 06/05/2024 a 26/05/2024       |
| 4       | 27/05/2024 a 16/06/2024       |

<span id="backlog--entregas">
   
## :pushpin: Product Backlog

<details>
  <summary>BACKLOG DO PRODUTO</summary>

| Prioridade | Função                                             | Descrição                                                                                                          |
|------------|----------------------------------------------------|--------------------------------------------------------------------------------------------------------------------| 
| 1          | Leitura de Arquivos CSV  | Elaborar o diagrama de classes para representar a estrutura do sistema e as relações entre as entidades.            | 
| 2          | Criar Diagrama de Classes  | Desenvolver a lógica para carregar e validar arquivos CSV contendo dados climáticos. Identificar e armazenar os registros suspeitos para revisão manual.             | 
| 3        | Gerenciamento de Estações, Cidades e Unidades de Medida  | Desenvolver a funcionalidade para visualizar, adicionar, modificar e excluir informações sobre estações meteorológicas, cidades e unidades de medida.       | 
| 4          |  Modelar Banco de Dados | Desenvolver a interface de usuário visual para facilitar a interação do usuário com o sistema.                      | 
| 5          | Criar Interface de Usuário (UI) | Modelar o banco de dados para armazenar os dados climáticos de forma eficiente e organizada.                       | 
| 6          | Identificação de Cidades  | Extrair o nome da cidade a partir do nome do arquivo CSV. Associar cada arquivo à sua respectiva cidade.             | 
| 7          | Unificação dos Dados                              | Desenvolver a estrutura de dados para armazenar os dados unificados das cidades. Implementar a lógica para unificar os dados das estações meteorológicas.          |
| 8          | Implementar Banco de Dados MySQL                  | Configurar e implementar o banco de dados MySQL para armazenar os dados climáticos conforme o modelo definido.      | 
| 9          | Tratamento de Registros Suspeitos                 | Implementar uma interface para revisão e correção de registros suspeitos. Permitir a exclusão ou revisão dos registros suspeitos e sua adição à base de dados principal. | 
| 10          | Relatório de Médias por Cidade e Período          | Desenvolver a funcionalidade para gerar relatórios de médias das variáveis climáticas por cidade e período de tempo selecionados pelo usuário.                        |  
| 11          | Preparação para Plotagem de Gráficos Boxplot      | Implementar a lógica para calcular os elementos necessários para plotagem de gráficos boxplot com base nos dados de uma estação em uma determinada data.               | 
| 12         | Ajustes e Melhorias                               | Realizar ajustes finais e melhorias de usabilidade com base no feedback do usuário.                                 |
| 13         | Documentação                                      | Preparar a documentação do sistema, incluindo manuais de usuário e desenvolvedor.                                   |

</details>

<span id="user-stories">

<details>
  <summary>O QUE ENTREGAREMOS NA SPRINT 3</summary>

1. Relatório Situacional

Problema:
A necessidade de um relatório que apresente os valores médios das últimas medidas para cada cidade, facilitando o monitoramento e a comparação das condições climáticas em diferentes localidades.

Requisito:
Relatório que apresente os valores médios das últimas medidas para cada cidade, ajudando na visualização e comparação das condições climáticas.

Descrição no formato:
Como pesquisador, desejo um relatório de situação que apresente os valores médios das últimas medidas para cada cidade, para que eu possa monitorar e comparar facilmente as condições climáticas em diferentes localidades.

Checklist para concluir a demanda:

O relatório deve apresentar os valores médios das últimas medidas para cada cidade.
A interface do usuário deve permitir a seleção fácil de cidades para visualização do relatório.
O relatório deve ser atualizado regularmente com as últimas medidas disponíveis



2 - relatorio boxplot
    Titulo: Relatório de elementos bloxplot

• Problema: A falta de um relatório que calcule os elementos para plotar um gráfico boxplot impede uma análise estatística detalhada das variáveis climáticas de uma estação em uma determinada data. Isso limita a compreensão das distribuições e variações dos dados climáticos, essenciais para estudos aprofundados e decisões baseadas em dados.

• Requisito: Relatório que calcule os elementos para se plotar um gráfico boxplot com base nos dados de uma estação em uma determinada data.

• Descrição no formato: Como pesquisador, desejo um relatório que calcule os elementos necessários para plotar um gráfico boxplot com base nos dados de uma estação em uma determinada data. Isso permitirá uma análise estatística detalhada das distribuições e variações das variáveis climáticas, facilitando a compreensão dos dados e a tomada de decisões informadas.

• Checklist para concluir demanda
  - Os relatórios permitem a seleção de uma estação específica e uma data específica para análise.
  - Os relatórios calculam e apresentam os elementos necessários para plotar um gráfico boxplot (mínimo, primeiro quartil, mediana, terceiro quartil e máximo).
  - A interface do usuário permite a seleção fácil de estações e datas para visualização dos relatórios de boxplot.

3 - tela de definiçao de parametros E 4 - tela de dados suspeitos:

• Problema: Atualmente, os dados sobre o clima em uma mesma cidade são armazenados em diversos arquivos, um para cada estação de monitoramento. Esses arquivos podem ter formatos diferentes e conter valores incorretos devido a enganos humanos ou problemas na coleta automática, por tanto é preciso uma maneira de lidar com registros suspeitos.

• Requisito: "Tratamento de registros suspeitos, que permita exclusão ou revisão. Deve ser possível 
alterar os valores e passá-los à base de dados principal ou excluí-los. [...] . Registros suspeitos (exemplo: registro com temperatura acima de 60 graus Celsius ou inferior a -20  graus Celsius) devem ser armazenados a parte para revisão manual."


• Descrição no formato: Como pesquisador, quero ter a capacidade de corrigir ou excluir informações suspeitas nos registros de dados climáticos. Isso garantirá que tenhamos informações precisas sobre o clima em nossa região de estudo, facilitando nossa análise e tomada de decisões.

• Checklist para concluir demanda
   - Os registros suspeitos são facilmente identificados e acessíveis para o pesquisador.
   - O sistema permite que o pesquisador revise e corrija os registros suspeitos conforme necessário.
   - As alterações feitas nos registros suspeitos são devidamente salvas, assegurando a precisão dos dados.
----

• Problema: Atualmente, os dados sobre o clima em uma mesma cidade são armazenados em diversos arquivos, um para cada estação de monitoramento. Esses arquivos podem ter formatos diferentes e conter valores incorretos devido a enganos humanos ou problemas na coleta automática, por tanto é preciso uma maneira de lidar com registros suspeitos.

• Requisito: "Tratamento de registros suspeitos, que permita exclusão ou revisão. Deve ser possível 
alterar os valores e passá-los à base de dados principal ou excluí-los. [...] . Registros suspeitos (exemplo: registro com temperatura acima de 60 graus Celsius ou inferior a -20  graus Celsius) devem ser armazenados a parte para revisão manual."

• Descrição no formato: Como pesquisador, quero ter a capacidade de corrigir ou excluir informações suspeitas nos registros de dados climáticos. Isso garantirá que tenhamos informações precisas sobre o clima em nossa região de estudo, facilitando nossa análise e tomada de decisões.

• Checklist para concluir demanda
   - Os registros suspeitos são facilmente identificados e acessíveis para o pesquisador.
   - O sistema permite que o pesquisador revise e corrija os registros suspeitos conforme necessário.
   - As alterações feitas nos registros suspeitos são devidamente salvas, assegurando a precisão dos dados.

5 - exportaçao csv no situacional e boxplot
Problema:
A falta de uma funcionalidade que permita a exportação de relatórios em formato CSV dificulta a análise e o compartilhamento dos dados climáticos para estudos e apresentações mais aprofundadas.

Requisito:
Funcionalidade que permita a exportação de relatórios em formato CSV, facilitando a análise e o compartilhamento dos dados climáticos.

Descrição no formato:
Como pesquisador, desejo uma funcionalidade que permita a exportação dos relatórios em formato CSV, para que eu possa analisar e compartilhar os dados climáticos de forma mais eficiente e detalhada.

Checklist para concluir a demanda:

A interface do usuário deve permitir a exportação de relatórios em formato CSV.
Os relatórios exportados em CSV devem conter todos os dados apresentados no relatório original.
A funcionalidade de exportação deve ser fácil de usar e acessível a partir da visualização dos relatórios.


</details>


<details>
  <summary>O QUE ENTREGAREMOS NA SPRINT 4</summary>

1 - Relatório de Valor Médio das Variáveis Climáticas por Cidade
Problema:
A ausência de um relatório detalhado de valor médio das variáveis climáticas por cidade, com periodicidade horária, dificulta a análise precisa das condições climáticas ao longo do tempo.

Requisito:
Relatório de valor médio das variáveis climáticas por cidade, que permita escolher uma cidade e um período de tempo específico, apresentando dados com periodicidade horária (um registro a cada hora).

Descrição no formato:
Como pesquisador, desejo um relatório de valor médio das variáveis climáticas por cidade, que permita a escolha de uma cidade e de um período de tempo específico, com dados apresentados a cada hora. Isso permitirá uma análise detalhada e precisa das condições climáticas ao longo do tempo, facilitando estudos e tomadas de decisão.

Checklist para concluir a demanda:

O relatório deve permitir a escolha de uma cidade específica.
O relatório deve permitir a seleção de um período de tempo específico.
O relatório deve apresentar dados climáticos médios com periodicidade horária (um registro a cada hora).
A interface do usuário deve ser intuitiva e permitir a seleção fácil de cidades e períodos de tempo.

2 - Manual do Usuário
Problema:
A ausência de um manual do usuário detalhado dificulta a compreensão e utilização das funcionalidades do sistema pelos usuários finais.

Requisito:
Manual do usuário que descreva detalhadamente todas as funcionalidades do sistema, incluindo instruções de uso e exemplos práticos.

Descrição no formato:
Como usuário, desejo um manual detalhado que explique todas as funcionalidades do sistema, para que eu possa utilizar o sistema de forma eficiente e aproveitar ao máximo suas capacidades.

Checklist para concluir a demanda:

O manual deve cobrir todas as funcionalidades do sistema.
O manual deve incluir instruções claras e exemplos práticos.
O manual deve ser fácil de acessar e navegar.


3 - Diagrama Entidade-Relacionamento
Problema:
A falta de um diagrama entidade-relacionamento claro dificulta a compreensão da estrutura e das relações do banco de dados.

Requisito:
Diagrama entidade-relacionamento que represente claramente a estrutura e as relações do banco de dados.

Descrição no formato:
Como desenvolvedor, desejo um diagrama entidade-relacionamento que represente claramente a estrutura e as relações do banco de dados, para que eu possa entender melhor a arquitetura do sistema e realizar manutenções e expansões de forma eficiente.

Checklist para concluir a demanda:

O diagrama deve representar todas as entidades e suas relações.
O diagrama deve ser claro e fácil de entender.
O diagrama deve estar atualizado com a versão atual do banco de dados.
Instruções de Instalação
Problema:
A ausência de instruções de instalação claras dificulta a configuração e implementação do sistema por novos usuários e administradores.

Requisito:
Instruções de instalação que detalhem passo a passo o processo de configuração e implementação do sistema.

Descrição no formato:
Como administrador, desejo instruções de instalação claras e detalhadas, para que eu possa configurar e implementar o sistema sem dificuldades.

Checklist para concluir a demanda:

As instruções devem cobrir todos os passos necessários para a instalação do sistema.
As instruções devem incluir pré-requisitos e possíveis soluções para problemas comuns.
As instruções devem ser fáceis de seguir e entender.




</details>


## 🖥️Tecnologias:
 * <p>
   <img align="left" title="git-logo" height="30px" src="https://skillicons.dev/icons?i=git"/>
   Git
 </p>
 
* <p>
   <img align="left" title="java-logo" height="30px" src="https://skillicons.dev/icons?i=java"/>
   Java
 </p>

* <p>
   <img align="left" title="javafx-logo" height="30px" src="https://github.com/nininhosam/nininhosam/assets/76211125/5b22e9b0-5474-4366-8742-2b6545952951"/>
   JavaFX
 </p>
 
* <p>
   <img align="left" title="mysql-logo" height="30px" src="https://skillicons.dev/icons?i=mysql"/>
   MySQL
 </p>




## 🛠️ Ferramentas:
* <p>
   <img align="left" title="discord-logo" height="30px" src="https://skillicons.dev/icons?i=discord"/>
   Discord
 </p>
 
* <p>
   <img align="left" title="github-dark" height="30px" src="https://user-images.githubusercontent.com/76211125/227561942-1503fb74-eb8e-41d1-936e-bf22bc2d70eb.png#gh-dark-mode-only"/>
   <img align="left" title="github-light" height="30px" src="https://user-images.githubusercontent.com/76211125/227561896-a90cea71-7431-4908-ac8d-71fc02603eeb.png#gh-light-mode-only"/>
   GitHub
 </p>
 
* <p>
   <img align="left" title="intellij-logo" height="30px" src="https://skillicons.dev/icons?i=idea"/>
   IntelliJ
 </p>


# <h2>INTEGRANTES👨‍💻👩‍💻</h2>
| Nome                                    | Função          | Fotos                                                                                                     | GitHub e LinkedIn                                        |
|-----------------------------------------|-----------------|-----------------------------------------------------------------------------------------------------------|----------------------------------------------------------|
| Eduardo da Silva Lima | Product Owner   | <img src="https://github.com/YanYamim/VCCorp/assets/119015786/24de5e7d-c40f-4d88-a9b6-48ee56f76ec8" width="150px"/> | [GitHub](https://github.com/PortifoliodoEdu) [Linkedln](https://www.linkedin.com/in/edu-datamarketing) |
| Yan Costa Yamim | Scrum Master    | <img src="https://github.com/YanYamim/VCCorp/assets/119015786/f3a0006b-3a5b-45ef-9108-aaf8c2634d98" width="150px"/> | [GitHub](https://github.com/yancostayamim) [Linkedln](https://www.linkedin.com/in/yan-yamim-185220278/) |
| Cristiane Lima Alvares  | Desenvolvedora  | <img src="https://github.com/YanYamim/VCCorp/assets/119015786/c2d64b75-d1f6-4abf-bdfc-ec996563ba5f" width="150px"/> | [GitHub](https://github.com/hstcris) [Linkedln](https://www.linkedin.com/in/cristiane-alvares/) |
| Daniel Moreira Santos Lima  | Desenvolvedor  | <img src="https://github.com/YanYamim/VCCorp/assets/119015786/da3b8d2b-ec18-405c-b2be-7bedff43a27c" width="150px"/> | [GitHub](https://github.com/DanielLimaCpy) [Linkedln](https://www.linkedin.com/in/daniel-lima-637648179?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app) |
| Gabriel Alves de Souza   | Desenvolvedor   | <img src="https://github.com/YanYamim/VCCorp/assets/119015786/e5cc312c-c170-4d27-906d-d49e4b985e6d" width="150px"/> |[GitHub](https://github.com/gabriel15asouza) [Linkedln](https://www.linkedin.com/in/gabriel-alves-de-souza-5b7747267/) |
| Guilherme Bezerra Junqueira | Desenvolvedor | <img src="https://github.com/YanYamim/VCCorp/assets/119015786/2bd4f098-fbf3-46c9-bcf1-696c1e396c44" width="150px"/> | [GitHub](https://github.com/GuilhermebJunqueira) [Linkedln](https://www.linkedin.com/in/guilherme-bezerra-a01035170/) |
| Pablo Henrique Gregório da Silva| Desenvolvedor | <img src="https://github.com/YanYamim/VCCorp/assets/119015786/f32214ff-67c2-4fd8-98bd-47d2fd9ca690" width="150px"/> | [GitHub](https://github.com/pablohgs05) [Linkedln](https://www.linkedin.com/in/pablo-henrique05/) |
| Pedro Henrique Lopes de Souza | Desenvolvedor   | <img src="https://github.com/YanYamim/VCCorp/assets/119015786/ad8a9b5a-c699-4dfd-b2ca-2eee1476d103" width="150px"/> | [GitHub](https://github.com/pelopinho) [Linkedln](https://www.linkedin.com/in/pelopes7/)|
