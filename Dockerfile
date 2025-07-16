# Imagem base com Java 21
FROM eclipse-temurin:21-jdk-alpine

# Diretório de trabalho no container
WORKDIR /app

# Copia os arquivos necessários
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw

# Baixa as dependências
RUN ./mvnw dependency:go-offline

# Copia o restante do código
COPY src ./src

# Compila e empacota
RUN ./mvnw package -DskipTests

# Expõe a porta da aplicação
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "target/docgen-0.0.1-SNAPSHOT.jar"]
