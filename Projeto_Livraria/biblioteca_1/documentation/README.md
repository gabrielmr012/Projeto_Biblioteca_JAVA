# 📚 Projeto Biblioteca ---->

- Criação de uma Biblioteca com um Banco de Dados funcional
- Entidades: Categoria e Livros

## Tecnologias Utilizadas ---->

- Banco de Dados PostgresSQL
- Java
- Hibernate

## 🗃️ Estrutura do Banco de Dados ---->

A estrutura do Banco de Dados consiste em 2 tabelas que se relacionam da seguinte forma:

- Tabela Categoria possui 2 Campos:

**NOME VARCHAR(100) PRIMARY KEY**
**DESCRICAO TEXT**

- CÓDIGO DE CRIAÇÃO DA TABELA CATEGORIA:

    **_CREATE TABLE categoria(nome VARCHAR(100)PRIMARY KEY, descricao TEXT);_**

- CÓDIGO DE CRIAÇAO DA TABELA LIVROS:

    **_CREATE TABLE livros(titulo VARCHAR(700), autor VARCHAR(700), sinopse TEXT, isbn TEXT, ano-de-lancamento INTEGER, categoria VARCHAR(100), FOREIGN KEY (categoria) REFERENCES categoria(nome));_**

- Como funciona a Relação entre as tabelas: 

    **UMA TABELA POSSUI VÁRIOS LIVROS, MAS A TABELA LIVROS SÓ PODE PERTENCER À UMA CÁTEGORIA**




## Estruturando o Projeto ---->

- MODELANDO AS ENTIDADES: 
    [ENTIDADE CATEGORIA](../src/main/java/com/biblioteca/modelo/Categoria.java)
    [ENTIDADE LIVRO](../src/main/java/com/biblioteca/modelo/Livro.java)

- OBJETOS DAO: 
   - [ENTIDADE CATEGORIA DAO](../src/main/java/dao/CategoriaDAO.java)

    #### Como funciona ---->
        - ✅ Criado uma interface com os métodos que serão implementados.
        - ✅ CRUD Básico + Método para listar todas as Categorias por Nome e Todos os Livor por Categoria.

    [ENTIDADE LIVRO DAO](../src/main/java/dao/LivroDAO.java)

    #### Como funciona ---->
        - ✅ Criado uma outra interface para implementar os métodos para manipular os dados de Livro
        - ✅ CRUD básico + Listar Livros por nome e Listar Livros por Categoria

- CATEGORIA DAOImpl: 
    #### private EntityManager em;

        - Cria um atributo do tipo EntityManager

    #### public CategoriaDAOImpl(){ this.em = JPAUtil.getEntityManager(); }

        - Chama um EntityManager e armazena no atributo 'em' pra poder manipular os dados 
    
    ####  return em.createQuery("SELECT * FROM categoria", Categoria.class).getResultList();

        - Usado no método de listarCategorias() 
        - Cria uma Query, mas não usa nomes da tabela, mas usa os nomes das entidades no criadas no java, e retorna uma lista com os resultados 
    
    #### O método de Listar Livros por categoria 

        return em.createQuery("SELECT l FROM livro l WHERE l.categoria.nome = :noceCategoria", Livro.class)

        - Essa Query seleciona de livros os livros que possuem "nomecategoria" igual ao parametro "nomecategoria" que será informado pelo usuário.

        - Pra isso uso: 
            - .setParameter(name: "nomecategoria", nomecategoria)

    #### public void deletarCategoria(String nomecategoria){}

        - O Método de Deletar tem uma verifição padrão pra se houver livros cadastrados não será permitido excluir a categoria
        - Para que não seja possível apagar uma Categoria caso haja Livros Cadastrados

- LIVRO DAOImpl:
    ### Usados as mesmas Lógicas de Categoria, só renomeei alguns parâmetros


----- CLASSES SERVICE -----

- CATEGORIA SERVICE: 
    [CATEGORIA SERVICE](../src/main/java/com/biblioteca/services/CategoriaService.java)

    - ### novaCategoria() ---->
        - Método padrão de receber Dados e enviar como nova Categoria para o Banco atravéz da DAO

            - Diferencial: Foi usado uma Validação no método:

                if(nome == null || nome.trim.empty){
                    Syso.("Categoria não pode conter o nome vazio!")
                    return;
                }
                    - Usei o .trim pra desconsiderar o Barra de Espaço e o .empty, caso nome esteja vazio
                    - Porque o Nome da categoria, foi usado como Primary Key, logo Não pode ser Nullo nem vazio
                    - Colocado um Return pra Voltar ao início do programa sem dar continuidade ao método.
        
    - ### buscarCategoriaPorNome() ----->
        - Recebe o nome que o usuario informa
        - [categoriadaoimpl.buscarCategoriaPorNome(nome)] - pega o parametro nome e atribui o valor para um objeto categoria do tipo Categoria
        - se categoria não for nulo, imprime o resultado categoria, que possui um toString.
        - se for nulo imprime ["Categoria não encontrada!"]
    
    - ### listarCategorias() ---->
        - instancia de um Lista com objeto do tipo Categoria que recebe o resultado do método 
           - [categoriadaoimpl.listarCategorias()] - retorna todas as categorias em uma lista 
        - usa um For(Categoria categoria : categorias){Syso.(categoria)}
        - pra cada objeto da lista ele imprime, já formatado por conta do toString da entidade categoria

    - ### atualizaCategoria() ---->
        - recebe uma categoria
        - recebe os novas descrições
        - e atualiza no banco de dados
        - não é permitido trocar o nome da categoria porque ela foi definida como chave primaria
        - será preciso melhorar essa lógica futuramente

- LIVRO SERVICE: 
    [LIVRO SERVICE](../src/main/java/com/biblioteca/services/LivroService.java)


    ver pq deu erro pra listar todas as categorias
    ver o pq de livro não ter se juntado com a tabela livro