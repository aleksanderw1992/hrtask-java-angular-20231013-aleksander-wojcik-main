# Astec HR Task - Java Components (Java EE, Angular)

Aplikacja do utrzymywania listy komponentów.

<h2>Opis</h2>
<p>Celem zadania jest stworzenie uproszczonej aplikacji do utrzymywania listy komponentów.</p>
<ul>
<li>Backend w postaci REST-API opartego na JavaEE</li>
<li>Frontend z wykorzystaniem Angular i komponentów PrimeNG</li>
</ul>

<h2>Przypadki użycia</h2>
<ul>
<li>Dodanie komponentu</li>
<li>Usunięcie komponentu</li>
<li>Lista komponentów</li>
</ul>

<h2>Obiekt komponent</h2>
<ul>
<li>logo - zapis orginału, skalowanie dla UI do 300x300px z zachowaniem proporcji</li>
<li>nazwa - tekst, maksymalna długość 100 znaków</li>
<li>opis - tekst, maksymalna długość 3000 znaków</li>
</ul>

<h2>Założenia</h2>
<ul>
<li>Konfiguracja dla 4 środowisk: DEV - lokalne środowisko developerskie, TEST - środowisko testowe, INT - środowisko integracyjne, PROD - produkcja</li>
<li>DB: lokalnie - H2, pozostałe - Oracle</li>
<li>Pliki (logo) należy trzymać w osobnym schemacie</li>
<li>AS: Payara 5</li>
<li>Java: 11</li>
<li>Pokrycie testami</li>
<li>Definicja API pozwalająca na automatyczne wygenerowanie klienta dla frontend</li>
<li>Deployment: automatyczny drop & create schema, create test data - możliwość konfiguracji dla każdego środowiska</li>
<li>Angular - wersja minimum 9</li>
<li>i18n - DE/EN</li>
</ul>
