System magazynowy (WMS)

Temat
Konsolowa aplikacja w Javie modelująca magazyn produktów. Wybrałem ten temat, ponieważ
pracuję w logistyce. Program przechowuje produkty różnego typu (spożywcze, elektroniczne)
w określonych miejscach magazynu i ilościach. Umożliwia przyjmowanie i wydawanie towaru,
obliczanie wartości magazynu z uwzględnieniem różnych stawek VAT oraz kontrolę dat
ważności produktów spożywczych.

Klasy
Product (abstrakcyjna) - opisuje dowolny produkt i definiuje wspólny kontrakt.
Pola: sku, name, netPrice. Metody: category(), vatRate() (abstrakcyjne), grossPrice(), changePrice().

FoodProduct - produkt spożywczy z datą ważności. Pole: expiryDate. Metody: category(), vatRate(), isExpired().

ElectronicProduct - produkt elektroniczny z gwarancją. Pole: warrantyMonths. Metody: category(), vatRate().

Location - miejsce składowania. Pola: zone, rack, shelf.

StockItem - pozycja magazynowa łącząca produkt, lokalizację i stan. Pola: product, location, quantity.
Metody: receive(), release(), grossValue().

Warehouse - zarządza listą pozycji magazynowych. Pola: name, items. Metody: addItem(), findBySku(),
receive(), release(), totalValue().

Main - uruchomienie i demonstracja działania.

Identyfikator: Product posiada pole sku (np. SP-001), po którym magazyn odnajduje pozycje.

Relacje między klasami
Warehouse jest w relacji z wieloma pozycjami StockItem - kolekcja (lista).
StockItem jest w relacji z Product - agregacja (produkt istnieje niezależnie i jest przekazywany z zewnątrz).
StockItem jest w relacji z Location - kompozycja (lokalizacja należy do konkretnej pozycji).
Produkt i lokalizacja są przekazywane do StockItem przez parametr konstruktora.
FoodProduct i ElectronicProduct dziedziczą po Product - dziedziczenie (relacja "jest rodzajem").
Dziedziczenia świadomie nie zastosowano dla relacji "ma" - pozycja ma lokalizację i produkt,
więc są one polami, a nie klasami bazowymi.

Cztery zasady OOP
Enkapsulacja - pola w Product i StockItem są prywatne. Nie można ustawić ceny ujemnej,
a stanu magazynowego nie da się zmienić bezpośrednio - służą do tego metody receive()
i release() z walidacją.
Dziedziczenie - FoodProduct i ElectronicProduct dziedziczą po abstrakcyjnej klasie Product.
Polimorfizm - metody category() i vatRate() są nadpisane w podklasach. Metoda totalValue()
oraz pętla w Main wywołują te same metody na produktach różnych typów, a każdy typ realizuje
je po swojemu (żywność 5%, elektronika 23%).
Abstrakcja - Product jest klasą abstrakcyjną z metodami abstrakcyjnymi. Określa, co produkt
musi potrafić, bez narzucania, w jaki sposób.

Użycie AI
Z pomocy AI skorzystałem przy projektowaniu struktury klas, doborze relacji oraz debugowaniu.
