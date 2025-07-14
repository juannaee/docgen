
# 📝 Docgen

Sistema **pessoal** de automação de geração de **documentos e relatórios Word**, com backend robusto em **Spring Boot**, autenticação de usuários e validação avançada de dados.  
O projeto nasceu em ambiente corporativo, mas foi continuado e expandido integralmente como propriedade **100% minha**.

> 📌 Todo o histórico inicial está disponível no [repositório `docgen-mirror`](https://github.com/juannaee/docgen-mirror), mostrando o progresso desde a época em que eu desenvolvia as primeiras APIs.

---

## 🚀 Tecnologias Utilizadas

- ☕ **Java 21**
- ⚙️ **Spring Boot**
- 🔐 **Spring Security + BCrypt**
- 🛠 **Spring Data JPA + Hibernate**
- 🗄 **MySQL** (via XAMPP para desenvolvimento local)
- 📏 **Hibernate Validator + Stella CPF Validator**
- 🌐 **HTML/CSS/JavaScript** (futuro frontend acoplado)

---

## ⚙️ Funcionalidades já Implementadas

- ✅ **Gestão completa de usuários**
  - Cadastro com validação de:
    - **Email único**
    - **Senha criptografada** (BCrypt)
    - **Telefone**, **CPF válido** (via Stella) e **data de nascimento**
  - Autenticação via e-mail e senha (HTTP Basic)
  - Atualização parcial de dados (nome e telefone) via DTO
  - Busca individual por ID
  - Inserção em **lote**, retornando sucesso e falha individual de cada usuário
- 🔄 **Perfis e permissões**
  - Controle via enum `UserRole` (ADMIN / USER)
  - Endpoints restritos por role (ex: apenas ADMIN)
- 🧹 **Ferramenta de limpeza segura**
  - Endpoint para remover usuários de teste em ambiente `dev` com token
- 🛠 **Tratamento global de erros**
  - Erros de validação em JSON estruturado (campo → mensagem)
  - Mensagens customizadas para CPFs inválidos e datas malformadas
- 🔒 **Arquitetura segura e expansível**
  - `SecurityFilterChain` com roles
  - `PasswordEncoder` centralizado via `AppConfig`

---

## 🚀 Funcionalidades futuras

- 📄 **Geração automática de documentos** `.docx` (modelos Word preenchidos com dados dos usuários ou dados externos)
- 🖥️ **Dashboard web interativo** para gerenciar documentos e relatórios
- ✉️ **Envio automatizado por e-mail** dos documentos gerados

---

## 🏁 Como Executar Localmente

### 1️⃣ Clone o repositório

```bash
git clone https://github.com/juannaee/docgen.git
cd docgen
```

### 2️⃣ Configure seu banco de dados (via XAMPP)

- Crie um banco chamado:

```
docgen
```

- E ajuste as credenciais em `src/main/resources/application.properties`:

```properties
spring.application.name=docgen
spring.profiles.active=test
# MySQL Config
spring.datasource.url=jdbc:mysql://localhost:3306/docgen?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

### 3️⃣ Rode o projeto

```bash
./mvnw spring-boot:run
```

O backend subirá em `http://localhost:8080`.

---

## 📖 Histórico e transparência

- Todo o progresso inicial (quando o projeto ainda estava vinculado à empresa), commits técnicos detalhados e migração para repositório pessoal estão documentados no [repo mirror](https://github.com/juannaee/docgen-mirror).  
- Ali você encontra:
  - Implementação de DTOs, validação manual de CPF, CPFValidator
  - Inserção em lote com `MULTI_STATUS`
  - Segurança com roles e criptografia
  - Evolução das exceções personalizadas
  - Cada feature isolada em commits semânticos.

---

## 👨‍💻 Autor

Desenvolvido e mantido por:

**Juan Guilherme Silva Lemos**  
📧 [juangsilvalemos@gmail.com](mailto:juangsilvalemos@gmail.com)  
💼 [LinkedIn](https://www.linkedin.com/in/juan-guilherme-silva-lemos-40b516244/)

---

✅ **Este é um projeto pessoal, completamente independente, com evolução constante.**  
Sinta-se à vontade para dar uma olhada no código, sugerir melhorias ou abrir issues!
