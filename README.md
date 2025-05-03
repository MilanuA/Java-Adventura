# Tajemství Spišského pokladu

```
                [Tatry]
                   |
             [Zřícenina] - [Košice] - [Dunaj]
                   |
  [Orava] - [Spišský hrad] - [Bratislava]
```


## Průběh hry:
### 1. Spišský hrad (startovací místo)
Popis: Stará kamenná brána se třemi otvory. Potřebuješ 3 klíče: ledový, dřevěný, zlatý.
Postava: Starý duch Strážce hradu – dá nápovědu:

„Klíče jsou roztroušené po zemi Slovenské. Pouze čisté úmysly odemknou bránu času.”

### 2. Orava
Popis: Vesnice u lesa. Les je neprostupný. V dálce je podezřelý pařez.
Postava: Dřevorubec – dá ti sekeru, když mu doneseš rybu z Dunaje.
Předmět: Po získání sekery můžeš rozseknout pařez v lese a získat Dřevěný klíč.

### 3. Tatry
Popis: Zamrzlé jezero. Na dně je něco lesklého.
Podmínka: Použij zrcadlo (získáš v Košicích), rozmrazíš jezero.
Výsledek: Najdeš Ledový klíč.

### 4. Bratislava
Popis: Velké město. Muzeum má zavřený trezor.
Předmět: Najdi mapu Slovenska (v Zřícenině). Pod stromem je jablko, které je potřeba donést Poutnikovi v Zřícenině.
Postava: Správce muzea – pustí tě do trezoru, pokud máš mapu.
Výsledek: Získáš Zlatý klíč.

### 5. Košice
Popis: Městský trh. Směna předmětů.
Postava: Kupkyně – vymění zrcadlo za stříbrný prsten.
Získání prstenu: Najdeš ho v Zřícenině (v truhle).
Akce: Máš zrcadlo → jdi do Tater a rozmraz jezero.

### 6. Zřícenina
Popis: Zbytky staré tvrze. Nachází se tu truhla (je potřeba páčidlo).
Postava: Poutník – dá ti páčidlo, pokud ho zasytíš (dáš mu jablko z Bratislavy).
Výsledek: Otevři truhlu → získáš prsten a mapu Slovenska.

### 7. Dunaj
Popis: Řeka. Zde můžeš chytit rybu.
Předmět: Rybářský prut (leží na břehu, volně k sebrání).
Akce: Použij prut → získej rybu → dones do Oravy.

## Předměty a využití:
| Příkaz               | Popis                                                           | Příklad použití         |
|----------------------|-----------------------------------------------------------------|-------------------------|
| jdi <místo>       ✅  | Přesun do jiné lokace, pokud cesta existuje.                    | jdi orava               |
| napoveda     ✅       | Vypíše seznam dostupných příkazů.                               | napoveda                |
| zkontroluj       ✅   | Zkontroluje, zda má hráč všechny 3 klíče.                       | zkontroluj              |
| konec          ✅     | Ukončí hru.                                                     | konec                   |
| seber <věc>       ✅  | Vezme předmět z aktuální místnosti.                             | seber prut              |
| pouzij <věc>         | Použije konkrétní předmět (např. sekera, mapa, zrcadlo, prut…). | pouzij zrcadlo          |
| mluv <postava>       | Zahájí rozhovor s postavou v místnosti.                         | mluv dřevorubec         |
| dalsi                | Posune se na další větu v rozhovoru.                            | dalsi                   |
| dej <věc> <postava>  | Předá předmět postavě (např. dáš rybu dřevorubci).              | dej ryba dřevorubec     |
| prozkoumej <objekt>  | Prozkoumá objekt v lokaci (např. truhlu, pařez, jezero).        | prozkoumej parez        |
| odemkni branu        | Ve Spišském hradě – použije 3 klíče a ukončí hru vítězstvím.    | odemkni branu           |


## Závěr hry
Jakmile máš:
- Dřevěný klíč
- Ledový klíč
- Zlatý klíč

→ Vrať se na Spišský hrad → Použij příkaz `odemkni branu` → hra končí vítězstvím.


## Předměty:
| Předmět          | Kde získat                    | Použití                                               |
|------------------|-------------------------------|--------------------------------------------------------|
| Sekera           | Orava (od dřevorubce)         | Rozseknutí pařezu → Dřevěný klíč                       |
| Zrcadlo          | Košice (výměna za prsten)     | Rozmrazení jezera v Tatrách → Ledový klíč             |
| Mapa Slovenska   | Zřícenina (v truhle)          | Přístup do trezoru v Bratislavě                        |
| Stříbrný prsten  | Zřícenina (v truhle)          | Výměna za zrcadlo v Košicích                           |
| Páčidlo          | Zřícenina (od poutníka)       | Otevření truhly ve Zřícenině                           |
| Jablko           | Bratislava (pod stromem)      | Dá se poutníkovi ve Zřícenině                          |
| Rybářský prut    | Dunaj (leží na břehu)         | Chytání ryby                                           |
| Ryba             | Dunaj (pomocí prutu)          | Dáš dřevorubci v Oravě → získáš sekeru                 |



