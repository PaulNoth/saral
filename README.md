## ŠARAL 2.0 - ŠARIŠ ALGORITMIK LENGVIDŽ 2.0

[English](README-en.md)

>Chceme Vás teraz zoznámiť so špicou pokroku a evolúcie v spracovaní informácií. S problémovo orientovamým vedecko-technickým programovacím jazykom Šaral.
Už od prvých pokusov šarišsko-americkej firmy IBM tu bola potreba spraviť taký jazyk, ktorému by rozumel ako počítač tak človek.

*Odporúčam vypočuť si celý [zvukový záznam](https://www.youtube.com/watch?v=-VNgsKEl4sA) alebo [prepis](https://www.trsek.com/pascal/%C5%A0aral_-_nov%C3%BD_programovac%C3%AD_jazyk) prezentácie od autora Šaralu*.


*Nie sú ešte podporované všetky funkcie jazyka. Kompletná špecifikácia [tu](https://github.com/laciKE/saral/blob/master/specifikacia.md)*


### Kompilátor
Na spustenie Šaral kompilatora potrebujeme mať nainštalovaný [`maven`](https://maven.apache.org/)

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
Podporuje momentálne 2 dátové typy - `neskutočné numeralio` (celé čísla), `slovo` (reťazce znakov) `logický` (bool/kleene hodnoty - `pravda`, `skoroošaľ`, `ošaľ`).

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

### Odsadenie
Jazyk Šaral oddeľuje bloky kódu pomocou medzier alebo tabulátorov na novom riadku (podobne ako [Python](https://www.python.org/)).
