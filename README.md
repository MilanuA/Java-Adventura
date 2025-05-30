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
Popis: Stará kamenná brána se třemi otvory. <br>
Potřebuješ 3 klíče: ledový, dřevěný, zlatý <br>
Postava: Starý duch Strážce hradu – dá nápovědu. <br>

### 2. Orava
Popis: Vesnice u lesa. V dálce je podezřelý pařez. <br>
Postava: Dřevorubec – dá ti sekeru, když mu doneseš rybu z Dunaje.<br>
Výsledek: Po získání sekery můžeš rozseknout pařez v lese a získat Dřevěný klíč.

### 3. Tatry
Popis: Zamrzlé jezero. Na dně je něco lesklého. <br>
Podmínka: Použij zrcadlo (získáš v Košicích), rozmrazíš jezero. <br>
Výsledek: Najdeš Ledový klíč.

### 4. Bratislava
Popis: Velké město. Muzeum má zavřený trezor.<br>
Podmínka: Najdi mapu Slovenska (v Zřícenině). Pod stromem je jablko, které je potřeba donést Poutnikovi v Zřícenině. <br>
Postava: Správce muzea – pustí tě do trezoru, pokud máš mapu.
Výsledek: Získáš Zlatý klíč. 

### 5. Košice
Popis: Městský trh.<br>
Postava: Kupkyně – vymění zrcadlo za stříbrný prsten. (v Zřícenině) <br>
Výsledek: Získáš zrcadlo.

### 6. Zřícenina
Popis: Zbytky staré tvrze. Nachází se tu truhla (je potřeba páčidlo). <br>
Postava: Poutník – dá ti páčidlo, pokud ho zasytíš (dáš mu jablko z Bratislavy). <br>
Výsledek: Otevři truhlu → získáš prsten a mapu Slovenska.

### 7. Dunaj
Popis: Řeka. Zde můžeš chytit rybu. <br>
Předmět: Rybářský prut (leží na břehu, volně k sebrání). <br>
Výsledek: Použij prut → získej rybu → dones do Oravy.

## Předměty a využití:
| Příkaz               | Popis                                                          | Příklad použití     |
|----------------------|----------------------------------------------------------------|---------------------|
| jdi <místo>          | Přesun do jiné lokace, pokud cesta existuje.                   | jdi orava           |
| nápověda             | Vypíše seznam dostupných příkazů.                              | nápověda            |
| zkontroluj           | Zkontroluje, zda má hráč všechny 3 klíče.                      | zkontroluj          |
| konec                | Ukončí hru.                                                    | konec               |
| seber <věc>          | Vezme předmět z aktuální místnosti.                            | seber prut          |
| použij <věc>         | Použije konkrétní předmět (např. sekera,prut…). | použij zrcadlo      |
| mluv <postava>       | Zahájí rozhovor s postavou v místnosti.                        | mluv dřevorubec     |
| další                | Posune se na další větu v rozhovoru.                           | další               |
| dej <věc> <postava\> | Předá předmět postavě (např. dáš rybu dřevorubci).             | dej ryba dřevorubec |
| odemkni              | Ve Spišském hradě – použije 3 klíče a ukončí hru vítězstvím.   | odemkni             |


## Závěr hry
Jakmile má hráč všechny 3 klíče:
- Dřevěný klíč
- Ledový klíč
- Zlatý klíč

→ Vratí se na Spišský hrad → Použije příkaz `odemkni branu` → hra končí vítězstvím.


## Předměty:
| Předmět          | Kde získat                    | Použití                                               |
|------------------|-------------------------------|--------------------------------------------------------|
| Sekera           | Orava (od dřevorubce)         | Rozseknutí pařezu → Dřevěný klíč                       |
| Zrcadlo          | Košice (výměna za prsten)     | Rozmrazení jezera v Tatrách → Ledový klíč             |
| Mapa Slovenska   | Zřícenina (v truhle)          | Přístup do trezoru v Bratislavě                        |
| Stříbrný prsten  | Zřícenina (v truhle)          | Výměna za zrcadlo v Košicích                           |
| Páčidlo          | Zřícenina (od poutníka)       | Otevření truhly ve Zřícenině                           |
| Jablko           | Bratislava (pod stromem)      | Dá se poutníkovi ve Zřícenině                          |
| Prázdná peněženka | Bratislava (válí se po ceste)         | Nedělá nic                 |
| Rybářský prut    | Dunaj (leží na břehu)         | Chytání ryby                                           |
| Rybářský klobouk | Dunaj (leží na břehu)         | Nedělá nic                 |
| Ryba             | Dunaj (pomocí prutu)          | Dáš dřevorubci v Oravě → získáš sekeru                 |



