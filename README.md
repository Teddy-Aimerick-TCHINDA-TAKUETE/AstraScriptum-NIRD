# 🌙 AstraScriptum — Simulateur NIRD  
### Projet développé dans le cadre de la Nuit de l’Info 2025

---

## 📌 Contexte

Ce projet a été réalisé durant **la Nuit de l’Info 2025**, un hackathon national organisé du 4 au 5 décembre 2025.

AstraScriptum est une plateforme web pédagogique et interactive visant à sensibiliser les établissements scolaires à la souveraineté numérique en adoptant une démarche NIRD (Numérique Inclusif, Responsable et Durable).

---

## 🎯 Objectifs pédagogiques

- 💻 Sensibiliser à la souveraineté numérique
- 🧭 Guider vers des choix informatiques responsables
- 🎮 Simulation interactive (choix → conséquences → score)
- 📈 Suivi d’évolution du score NIRD
- 🔐 Authentification & onboarding
- 📝 Recommandations & défis à débloquer

---

## 🛠 Architecture

```
+-------------------+
|      React        |
|  (Vercel Deploy)  |
+---------+---------+
          |
          | HTTPS + JWT
          |
+---------v---------+
|   Spring Boot     |
|    (Render)       |
+---------+---------+
          |
          | PostgreSQL (Render)
          |
+---------v---------+
|   Base de données |
+-------------------+
```


---

## 🧑‍🤝‍🧑 Équipe du Projet

| Nom | Rôle | LinkedIn | Github |
|-----|-----|----------|----------|
| Teddy TCHINDA | Backend (Spring Boot) | https://www.linkedin.com/in/teddy-aimerick-tchinda-takuete | https://github.com/Teddy-Aimerick-TCHINDA-TAKUETE |
| RAHOU Hind | Frontend (React) | http://linkedin.com/in/hind-rahou | https://github.com/LaHQuiCode |
| BENGONO Bruno | Frontend (React) | https://linkedin.com/in/bruno-bengono | https://github.com/Ben-Bruno |

---

## 📦 Technologies

# 🔙 Backend
- Spring Boot (Java 21)
- JPA/Hibernate
- PostgreSQL (Render)
- JWT / Spring Security
- Validation DTO
- Swagger OpenAPI

# 🔜 Frontend
- React + Vite
- AuthContext + Routing
- Responsive UI
- Vercel Hosting

# 🗄 Base de données (PostgreSQL)

- Hébergée sur Render
- Connexion sécurisée
- Auto-migration via Spring Boot

---

## 🧩 Fonctionnalités

-Authentification (login / inscription)
-Session persistante JWT
-Simulation interactive d'établissement
-Défis cybersouveraineté
-Score NIRD (progression)
-Recommandations
-Requêtes API sécurisées
-Responsive design

---

## 🚀 Déploiement

- **Backend (Render):** [Render](https://astrascriptum-nird-back.onrender.com/)
- **Frontend (Vercel):** [Vercel](https://astrascriptum-nird.vercel.app/)
- Communication sécurisée via HTTPS

---

## 📂 Structure

```
AstraScriptum-NIRD/
│
├── Backend/
│   └── astraScriptum/
│        ├── src/main/java/
│        ├── src/main/resources/
│        └── pom.xml
│
└── Frontend/
    └── astraFront/
         ├── src/
         ├── public/
         ├── vite.config.js
         └── package.json

```

---

## 🧪 Tester en local

# Backend

```
cd Backend/astraScriptum
mvn clean install
mvn spring-boot:run

```
API locale : http://localhost:8080

# Frontend

```
cd Frontend/astraFront
npm install
npm run dev
```
Front local : http://localhost:5173

---

## 📜 Licence

Projet sous licence **MIT**, conformément aux recommandations de la Nuit de l’Info.

---

## 📚 Références & Ressources NIRD

Le document du sujet renvoie explicitement au site officiel NIRD :

https://nird.forge.apps.education.fr/

Ainsi qu’à plusieurs sources multimédias (France 3, France Inter, etc.), qui ont inspiré la démarche.

---

## 🏁 Conclusion

AstraScriptum est une plateforme pédagogique, interactive et participative, réalisée en moins de 14h, en équipe, dans l’esprit du défi :
- Résister aux dépendances numériques
- Promouvoir les logiciels libres
- Engager la communauté éducative

---

## ❤️ Remerciements

Merci à toute l’équipe, aux organisateurs de la Nuit de l’Info,
et à toutes les ressources open-source ayant permis ce projet !

---

## 🌟 Merci de votre lecture, et vive un numérique libre, responsable et durable !
