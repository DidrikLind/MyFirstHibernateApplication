# MyFirstHibernateApplication
<h1>Hibernate Application tryout with MVC.  -  ORM</h1>


<h2>Du jobbar på ett företag som använder JDBC och MySQL. Chefen vill att er arbetsgrupp utvärderar om företaget ska byta till något ORM-ramverk som Hibernate. Ni behöver i gruppen då orientera er i följande frågor/områden:</h2>

<h3>Vad är ORM?</h3>
<p>En programmeringsteknik för att omvandla/mappa data mellan relationsdatabaser ochi objektorienterade programspråk. Tabeller översätts tills klasser, tabellrader till objekt, och tabell-celler till objekt-attribut.</p>

<h3>Vad är Hibernate ORM?</h3>
<p>Hibernate ORM är Java-specificerad, open-source ramverk som använder JDBC-tekniken. </p>

<h3>Det finns något "mismatch"-problem, vad är det chefen har hört talas om?</h3>
<p>Objektorienterad kod översätts inte bra direkt till RDBMS. Hur man inom OOP kommer åt objekt, använder pekare till dem, kontrollerar likhet (equals, ==), och ärver, skiljer sig fundamentalt från RDBMS. Dessutom bör antal klasser stämma överens med antal tabeller.</p>

<h3>Vilka andra teknologier liknar Hibernate? Finns det något bättre alternativ än Hibernate?</h3>
<p>Det finns andra alternativ, såsom MyBatis, jOOQ eller Sormula. Dock är Hibernate väldigt populärt, och används inom Spring-ramverket.</p>

<h3>Vilka andra teknologier är Hibernate beroende av (eller använder sig av)?
Behöver man kunna något mer än Hibernate?</h3>
<p>Hibernate använder sig av JDBC för att komminucera med databasen</p>
<p>Kan vara bra att kunna SQL tänket eftersom man lär sig använda jar filer vad det gäller drivrutiner till ens databas, tex Oracle, Sqlite osv. Dessutom om man är van vid HTML, då man skriver konfigurations-filerna i XML-format, så är det en fördel.</p>

<h3>Kan ni skriva ett exempel med en klass som mappas till en databas med Hibernate? (hitta ngn tutorial/material till hjälp!)</h3>
<p>Se kod i detta GitHub-repot, jag har testat och använda Hibernate (utan Spring) för första gången! </p>
