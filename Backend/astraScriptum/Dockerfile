# ───────────── STAGE 1 : BUILD (Maven + JDK 21) ─────────────
FROM maven:3.9.11-eclipse-temurin-21 AS build

# Copier le pom.xml
COPY pom.xml .

# Télécharger les dépendances (cache Docker)
RUN mvn -B dependency:go-offline

# Copier le code source
COPY src ./src

# Build de l'application (jar généré dans target/)
RUN mvn -B package -DskipTests


# # ───────────── STAGE 2 : RUN (JRE 21 léger) ─────────────
# FROM eclipse-temurin:21-jre

# # Copier uniquement le jar généré depuis le stage de build
# COPY --from=build ./target/*.jar astraScriptum-0.0.1-SNAPSHOT.jar

# Exposer le port Spring Boot
EXPOSE 8080

# Lancer automatiquement l'application quand le conteneur démarre
# ENTRYPOINT ["java", "-jar", "app.jar"]
CMD [ "mvn", "spring-boot:run" ]
