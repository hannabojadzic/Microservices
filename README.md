# Microservices

Najprije je potrebno pokrenuti sve servise

### Pokretanje Inventory, Inventory_mobile i Payment_v2 servisa

Pokretanje Spring Boot aplikacija u STS-u: https://www.javatpoint.com/run-spring-boot-application

Pokretanje Spring Boot aplikacija u IntelliJ-u: https://www.geeksforgeeks.org/how-to-run-your-first-spring-boot-application-in-intellij-idea/

### Pokretanje chatboxAApp servisa

Preduslov: Python 3.6

Instalacija paketa: pip install -r requirements.txt

Download spacy-a: python -m spacy download en_core_web_sm

Riješenje problema sa spacy-em na Windows OS-u: https://stackoverflow.com/a/66087946

Pokretanje aplikacije: python api.py

### Pokretanje clientApp-TechWebPage aplikacije

- npm install
- npm start

### Nginx server

Korištena je distribucija OpenResty servera za Windows.

Za više informacija: https://openresty.org/en/

Download ovog servera: https://openresty.org/en/download.html

Bitni folderi koje je potrebno prenijeti ako se koristi neka druga distribucija:
- \openresty-1.21.4.1-win64\lualib
- cert folder
- Nginx konfiguracija: \openresty-1.21.4.1-win64\conf
