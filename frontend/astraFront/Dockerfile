# 1) Image de base avec Node
FROM node:22-alpine

# 2) Répertoire de travail dans le conteneur
WORKDIR /app

# 3) Copier uniquement les fichiers de dépendances d'abord (meilleur cache)
COPY package*.json ./

# 4) Installer les dépendances
RUN npm install

# 5) Copier le reste du projet
COPY . .

# 6) (important) Pour que le serveur écoute sur toutes les interfaces
ENV HOST=0.0.0.0

# 7) Port utilisé par React (npm start = 3000 par défaut)
EXPOSE 5173

# 8) Commande lancée au démarrage du conteneur
CMD ["npm", "run", "dev"]
