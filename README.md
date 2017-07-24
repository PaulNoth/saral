## ŠARAL 2.0 - ŠARIŠ ALGORITMIK LENGVIDŽ 2.0

[English](README-en.md)

>Chceme Vás teraz zoznámiť so špicou pokroku a evolúcie v spracovaní informácií. S problémovo orientovamým vedecko-technickým programovacím jazykom Šaral.
Už od prvých pokusov šarišsko-americkej firmy IBM tu bola potreba spraviť taký jazyk, ktorému by rozumel ako počítač tak človek.

*Odporúčam vypočuť si celý [zvukový záznam](https://www.youtube.com/watch?v=-VNgsKEl4sA) alebo [prepis](https://www.trsek.com/pascal/%C5%A0aral_-_nov%C3%BD_programovac%C3%AD_jazyk) prezentácie od autora Šaralu*.


*Nie sú ešte podporované všetky funkcie jazyka. Kompletná špecifikácia [tu](https://github.com/laciKE/saral/blob/master/specifikacia.md)*


### Kompilátor
Na spustenie Šaral kompilátora potrebujeme mať nainštalovaný [`maven`](https://maven.apache.org/).

A vygenerovať súbory parsera a lexera, ktoré vzniknú z `ANTLR` gramatiky - `Saral.g4`. (Odporúčam stiahnuť knižnicu [`antlr4`](https://mvnrepository.com/artifact/org.antlr/antlr4/4.5.3) a nakopírovať do projektu).
```
./generate.sh
```
Šaral zdrojové súbory majú príponu `srl` a prostredníctvom kompilátora ich preložíme do bajtkódu JVM, kde nám vznikne `.class` súbor. 

`java com.pidanic.saral.Compiler <saral_source_file.srl>`

Potom stačí spustiť prekompilovaný program. 

`java <saral_source_file.class>`

### Program
Programovancí jazyk je určený pre JVM, napriek tomu nepotrebuje žiadne triedy ako v Jave. Deklarujeme si pár premenných ako `meňak` a výpíšeme ich do konzoly pomocou `ciskaj`.
```
meňak neskutočné numeralio pejc = 5
ciskaj pejc
meňak slovo servus = "servus"
ciskaj servus
```

### Dátové typy
Podporuje momentálne dátové typy - `neskutočné numeralio` (celé čísla), `slovo` (reťazce znakov) `logický` (bool/kleene hodnoty - `pravda`, `skoroošaľ`, `ošaľ`), `písmeno` (znak), `skutočné numeralio` (reálne čísla).
```
meňak neskutočné numeralio pejc = 5
meňak slovo dupa= "dupa"
meňak logický p = pravda
meňak logický o = ošaľ
meňak logický so = skoroošaľ
meňak skutočné numeralio cislo = 1.2
meňak písmeno pis = 'a'
meňak neskutočné numeralio veľo = 5000000000
```
### Operácie
#### Aritmetické operácie
Podporované sú matematické operácie medzi celými a reálnymi číslami (typ `neskutočné numeralio`, `skutočné numeralio`). Je dodržaná matematická prednosť operácií a zátvoriek.
- násobenie `*`
- delenie `/` alebo `:`
- ščítanie `+`
- odčítanie `-`
- zvyšok po delení (modulo) `%` (len pre typ `neskutočné numeralio`)

```
bar neskutočné numeralio vracimDaco()
    meňak neskutočné numeralio pejc = 5
    vrac pejc
    
meňak neskutočné numeralio a = 1 + 1
meňak neskutočné numeralio b = 2 * 10
meňak neskutočné numeralio c = 10 - (vrac z baru vracimDaco())
meňak neskutočné numeralio d = (1 + 1) * 3
meňak neskutočné numeralio e = (10 / 2)
meňak neskutočné numeralio f = 10 : 2
meňak neskutočné numeralio g = 11 % 2
```

#### Porovnávanie
Funguje porovnávanie celých čísel (typ `neskutočné numeralio`): 
- rovnosť `==`
- nerovnosť `<>`
- väčší `>`
- väčší alebo rovný `>=`
- menší `<`
- menší alebo rovný `<=`

Výsledok bude hodnoty `pravda`, ak je podmienka pravdivá a `ošaľ`, ak je nepravdivá.
```
meňak logický e = 4 == 4
meňak logický e2 = 4 == 3
meňak logický ne = 4 <> 4
meňak logický ne2 = 4 <> 3
meňak logický ge = 4 >= 4
meňak logický ge2 = 4 >= 3
meňak logický ge3 = 3 >= 4
meňak logický le = 4 <= 4
meňak logický le2 = 4 <= 3
meňak logický le3 = 3 <= 4
meňak logický g = 4 > 4
meňak logický g2 = 4 > 3
meňak logický g3 = 3 > 4
meňak logický l = 4 < 4
meňak logický l2 = 4 < 3
meňak logický l3 = 3 < 4
```

### Procedúry
Opakuje sa nám rovnaký kód? Nevadí, môžme si vytvoriť procedúru.
```
bar robim()
   meňak neskutočné numeralio tri = 3
   ciskaj tri
```

`bar` nám vraví, že máme procedúru, ktorá ma meno `robim` a nemá žiadne parametre. 

Nie je problém pridať parametre podporovaných dátových typov.
```
bar tiezRobim(neskutočné numeralio x)
    ciskaj x
```

Vytvorenú procedúru zavoláme prostredníctvom `paľ do baru`
```
paľ do baru robim()

meňak neskutočné numeralio pejc = 5
paľ do baru tiezRobim(pejc)

```

### Funkcie
Opakuje sa nám rovnaký kód a chceme vrátiť nejakú hodnotu výpočtu? Môžme si vytvoriť funkciu.
```
bar neskutočné numeralio vracimDaco()
    meňak neskutočné numeralio pejc = 5
    vrac pejc
```
Samozrejme aj s ľubovoľným počtom parametrov.
```
bar slovo vracimSlovo(slovo x)
    vrac x
```

Vytvorenú funkcie zavoláme prostredníctvom `vrac z baru`
```
vrac z baru vracimDaco()

meňak slovo dupa = "dupa"
vrac z baru vracimSlovo(dupa)

```

### Podmienené vykonanie časti kódu
Ako všetky problémovo orientované jazyky aj jazyk Šaral podporuje podmienené vykonanie, tzv `if-then-else`. V terminológii Šaralu `keď-potom-inak`

```
keď 1 > 0 potom
    paľ do baru robim()
inak
    paľ do baru tiezRobim(pejc)
```

Časť `inak` je nepovinná
```
keď 2 > 0 potom
    meňak neskutočné numeralio dva = 2
    ciskaj dva
```
   
### Odsadenie
Jazyk Šaral oddeľuje bloky kódu pomocou medzier alebo tabulátorov na novom riadku (podobne ako [Python](https://www.python.org/)).
