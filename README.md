#Cloner et lancer l'application en local

# 1. Clone le dépôt
git clone https://github.com/stshauke/jo_paris_2024.git
cd jo_paris_2024

# 2. Compile et package l'application
./mvnw clean install    # ou ./gradlew build

# 3. Lance l'application sur windows
mvnw.cmd spring-boot:run  # ou java -jar target/mon-appli-0.0.1-SNAPSHOT.jar