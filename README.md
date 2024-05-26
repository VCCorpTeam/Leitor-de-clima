# <h1 align="center"> VCCorp 🐕​ </h1>

<h2 align="center"> Sumário </h2>
  <p align="center">
     <a href ="#sobre-o-projeto">Sobre o projeto</a>  • 
     <a href ="#calendario-sprints">Calendário Sprints</a>  • 
     <a href ="#product-backlog">Product Backlog</a>  •
     <a href ="#user-stories">User Stories</a>  •
     <a href ="#tecnologias">Tecnologias</a>  •
     <a href ="#ferramentas">Ferramentas</a>  •
     <a href ="#integrantes">Integrantes</a>
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


## :pushpin: 📖 User Stories SPRINT 2
<details>

| Titulo da funcionalidade | Descrição | Critérios de conclusão (DOT) | Critérios de aceitação (DOR) |
|---------------------------|-----------|-----------------------------|-------------------------------|
| Gerenciamento das estações de coleta | Esta funcionalidade visa facilitar o gerenciamento das estações de coleta de dados climáticos. Cada arquivo CSV contém um código que identifica a estação de coleta e a cidade correspondente. A funcionalidade garantirá que o sistema reconheça automaticamente de qual estação é cada arquivo, permitindo uma organização eficiente dos dados e simplificando a análise subsequente. | O sistema reconhece automaticamente o código da estação de coleta de cada arquivo CSV carregado. As informações sobre a estação de coleta são exibidas corretamente na interface do usuário. Caso o código da estação de coleta não seja reconhecido automaticamente, o sistema fornece uma indicação clara ao usuário e permite a correção manual. A funcionalidade foi revisada e aprovada para liberação. A documentação do usuário foi atualizada para incluir instruções sobre como o sistema reconhece e gerencia as estações de coleta automaticamente. | A equipe de desenvolvimento compreende claramente o formato dos nomes dos arquivos CSV e como eles identificam as estações de coleta. Foram identificados os padrões nos nomes dos arquivos que indicam a estação de coleta e a cidade correspondente. A funcionalidade de reconhecimento automático da estação de coleta foi priorizada no backlog do produto. As interfaces de usuário necessárias para visualizar e gerenciar as estações de coleta estão disponíveis para desenvolvimento. Foram estabelecidos procedimentos para lidar com casos em que o código da estação de coleta não é reconhecido automaticamente pelo sistema. |
| Gerenciamento da cidades | Esta funcionalidade visa facilitar o gerenciamento das cidades relacionadas aos dados climáticos. Além de reconhecer automaticamente a cidade de cada arquivo CSV, o sistema permitirá a associação de nomes por extenso às siglas das cidades. Isso garantirá que as cidades sejam identificadas corretamente durante a geração de relatórios e análise dos dados, proporcionando uma experiência mais completa e precisa para o usuário. | O sistema reconhece automaticamente a cidade de cada arquivo CSV carregado. As informações sobre a cidade são exibidas corretamente na interface do usuário. Caso o nome da cidade não seja reconhecido automaticamente, o sistema fornece uma indicação clara ao usuário e permite a associação manual. A funcionalidade foi revisada e aprovada para liberação. A documentação do usuário foi atualizada para incluir instruções sobre como o sistema reconhece e associa nomes de cidades automaticamente. | A equipe de desenvolvimento compreende claramente como as cidades estão relacionadas aos arquivos CSV e como elas são identificadas. Foram identificados os padrões nos nomes dos arquivos que indicam as cidades correspondentes. A funcionalidade de reconhecimento automático da cidade e associação de nomes por extenso foi priorizada no backlog do produto. As interfaces de usuário necessárias para configurar a associação de nomes por extenso às siglas das cidades estão disponíveis para desenvolvimento. Foram estabelecidos procedimentos para lidar com casos em que o nome da cidade não é reconhecido automaticamente pelo sistema. |
| Exportação de relatório em PDF | Esta funcionalidade permite aos usuários exportar os relatórios gerados pelo sistema em formato PDF. Com a exportação em PDF, os usuários podem compartilhar e distribuir facilmente os relatórios com outras partes interessadas. Isso garante que as informações sejam acessíveis e portáteis, permitindo uma comunicação eficaz e uma colaboração mais fácil entre os usuários. | A funcionalidade permite exportar os relatórios em formato PDF de forma eficiente. Os relatórios exportados em PDF incluem todas as informações relevantes e são formatados corretamente. A exportação de relatórios em PDF foi testada em diferentes cenários e aprovada para liberação. A funcionalidade foi revisada e aprovada para liberação. A documentação do usuário foi atualizada para incluir instruções sobre como exportar os relatórios em formato PDF. | A equipe de desenvolvimento compreende claramente os tipos de relatórios que podem ser exportados em formato PDF. Foram identificadas as informações e formatações que devem ser incluídas nos relatórios em PDF. A funcionalidade de exportação de relatórios em PDF foi priorizada no backlog do produto. As interfaces de usuário necessárias para configurar e executar a exportação de relatórios estão disponíveis para desenvolvimento. Foram estabelecidos procedimentos para lidar com casos em que a exportação de relatórios em PDF não é bem-sucedida devido a problemas de formatação ou compatibilidade. |
| Persistencia: Através do uso do banco, manter dados salvos para uso posteriormente ao religar programa | Esta funcionalidade visa garantir a persistência dos dados armazenados por meio do uso de um banco de dados. Independentemente de o programa ser encerrado e posteriormente religado, os dados permanecerão salvos, garantindo sua integridade e disponibilidade para uso contínuo. Isso assegura que as informações coletadas e processadas não sejam perdidas entre sessões de uso do programa, proporcionando continuidade e consistência nos dados para os usuários. | Os dados são armazenados com sucesso no banco de dados durante o uso do programa. Os dados persistidos são recuperados de forma correta e consistente ao religar o programa. A funcionalidade foi testada em diferentes cenários de persistência e recuperação de dados. A funcionalidade foi revisada e aprovada para liberação. A documentação do usuário foi atualizada para incluir informações sobre a persistência de dados e sua importância para a continuidade das informações entre sessões de uso do programa. | A equipe de desenvolvimento compreende claramente os tipos de dados que precisam ser persistentes. Foram identificados os requisitos de armazenamento e recuperação de dados utilizando um banco de dados. A funcionalidade de persistência de dados foi priorizada no backlog do produto. As interfaces de comunicação com o banco de dados estão disponíveis para desenvolvimento. Foram estabelecidos procedimentos para lidar com casos de falha na persistência ou recuperação de dados. |

</details>

## :pushpin: 📖 User Stories SPRINT 3

<details>

| Titulo da funcionalidade | Descrição | Critérios de conclusão (DOT) | Critérios de aceitação (DOR) |
|---------------------------|-----------|-----------------------------|-------------------------------|
| União de dados dos arquivos redundantes, tirando a média das variaveis climáticas | Esta funcionalidade tem como objetivo unir dados de arquivos redundantes que contenham informações de variáveis climáticas e calcular a média dessas variáveis. Quando múltiplos arquivos contêm dados semelhantes, a funcionalidade irá combinar esses dados e calcular a média das variáveis climáticas correspondentes. Isso ajuda a evitar a redundância de dados e simplifica a análise posterior dos dados climáticos. | A funcionalidade de união de dados e cálculo da média foi implementada e testada com sucesso em ambiente de desenvolvimento. Os arquivos redundantes foram processados corretamente, e a média das variáveis climáticas foi calculada de forma precisa. As operações de união e cálculo da média foram otimizadas para desempenho e eficiência. A funcionalidade foi revisada e aprovada para liberação. A documentação do usuário foi atualizada para incluir instruções sobre como utilizar a funcionalidade de união e cálculo da média. | A equipe de desenvolvimento compreende claramente os tipos de variáveis climáticas que serão consideradas para a média. Foram identificados os arquivos redundantes que contêm dados semelhantes e precisam ser unidos. A funcionalidade de união de dados e cálculo da média foi priorizada no backlog do produto. As interfaces de usuário necessárias para configurar a operação de união e cálculo da média estão disponíveis para desenvolvimento. Foram estabelecidos procedimentos para lidar com casos em que os dados dos arquivos redundantes são inconsistentes ou incompletos. |
| Tratamento de registros suspeitos, isolando arquivos | Esta funcionalidade possibilita o tratamento de registros suspeitos nos arquivos CSV, isolando esses registros para revisão posterior. Quando um registro é identificado como suspeito, ele será separado dos demais para que os usuários possam revisá-lo e corrigi-lo, garantindo a integridade e a qualidade dos dados. Isso permite que problemas potenciais nos registros sejam identificados e resolvidos antes de serem incluídos na análise ou nos relatórios, evitando assim a distorção ou a interpretação incorreta dos dados. | A funcionalidade permite isolar e tratar registros suspeitos nos arquivos CSV de forma eficiente. Os registros suspeitos são isolados corretamente e estão disponíveis para revisão pelos usuários. Os procedimentos de tratamento de registros suspeitos foram testados em diferentes cenários e aprovados para liberação. A funcionalidade foi revisada e aprovada para liberação. A documentação do usuário foi atualizada para incluir instruções sobre como isolar e tratar registros suspeitos nos arquivos CSV. | A equipe de desenvolvimento compreende claramente os critérios que determinam se um registro é suspeito. Foram identificados os procedimentos e critérios para isolar e tratar registros suspeitos nos arquivos CSV. A funcionalidade de tratamento de registros suspeitos foi priorizada no backlog do produto. As interfaces de usuário necessárias para isolar e tratar registros suspeitos estão disponíveis para desenvolvimento. Foram estabelecidos procedimentos para lidar com casos em que os registros suspeitos não são identificados corretamente pelo sistema. |
| Permitir configuração para determinar o que é um registro suspeito | Esta funcionalidade possibilita aos usuários configurar os critérios para determinar o que é considerado um registro suspeito nos arquivos CSV. Os usuários terão a capacidade de personalizar os critérios com base em suas necessidades específicas e nos requisitos do projeto. Isso proporciona flexibilidade e adaptabilidade ao sistema, permitindo que os usuários definam regras personalizadas para identificar registros suspeitos de acordo com os padrões e as exigências do contexto em que estão trabalhando. | A funcionalidade permite aos usuários configurar os critérios para determinar o que é um registro suspeito nos arquivos CSV. As configurações dos critérios são aplicadas corretamente durante o processamento dos dados. Os critérios configurados foram testados em diferentes cenários e aprovados para liberação. A funcionalidade foi revisada e aprovada para liberação. A documentação do usuário foi atualizada para incluir instruções sobre como configurar os critérios para determinar registros suspeitos nos arquivos CSV. | A equipe de desenvolvimento compreende claramente os tipos de critérios que podem ser configurados para determinar um registro suspeito. Foram identificados os parâmetros e variáveis que podem ser utilizados na configuração dos critérios. A funcionalidade de configuração para determinar o que é um registro suspeito foi priorizada no backlog do produto. As interfaces de usuário necessárias para configurar os critérios estão disponíveis para desenvolvimento. Foram estabelecidos procedimentos para lidar com casos em que os critérios configurados não estão produzindo os resultados esperados. |
| Geração de relatórios personalizados com base em critérios selecionados pelo usuário | Esta funcionalidade oferece aos usuários a capacidade de gerar relatórios personalizados com base em critérios selecionados por eles mesmos. Os usuários podem especificar quais dados desejam incluir nos relatórios, aplicar filtros para limitar os resultados e agrupar informações conforme necessário. Isso permite uma análise mais precisa e direcionada dos dados, atendendo às necessidades específicas de cada usuário. | A funcionalidade permite aos usuários selecionar os critérios desejados para personalizar os relatórios. Os relatórios personalizados são gerados corretamente de acordo com os critérios selecionados pelos usuários. Os filtros e agrupamentos aplicados aos dados nos relatórios funcionam conforme esperado. A funcionalidade foi testada em diferentes cenários de personalização de relatórios e aprovada para liberação. A documentação do usuário foi atualizada para incluir instruções sobre como selecionar os critérios e gerar relatórios personalizados. | A equipe de desenvolvimento compreende claramente os critérios que podem ser selecionados pelos usuários para personalizar os relatórios. Foram identificados os tipos de filtros e agrupamentos que podem ser aplicados aos dados nos relatórios personalizados. A funcionalidade de geração de relatórios personalizados foi priorizada no backlog do produto. As interfaces de usuário necessárias para selecionar os critérios e configurar os relatórios estão disponíveis para desenvolvimento. Foram estabelecidos procedimentos para lidar com casos em que os critérios selecionados pelos usuários resultam em relatórios vazios ou incompletos. |

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
