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

Druhou možnosťou výpisu do konzoly je prostredníctvom `povidz`, ktorý je ekvivalentný s `ciskaj`.
```
meňak neskutočné numeralio pejc = 5
povidz pejc
meňak slovo servus = "servus"
povidz servus
```

### Komentáre
Začínajú vždy `//` a môžu sa objaviť na začiatku riadku a zaberú celý riadok, alebo za výrazom
```
meňak neskutočné numeralio pejc = 5
// toto je komentár
ciskaj pejc
meňak slovo servus = "servus" // pekný pozdrav
ciskaj servus
```

### Konštanty
Okrem `meňak`ov, ktorých hodnotu vieme zmeniť, poznáme ešte `furt`y, ktorým priradíme na začiatku vždy jedinú hodnotu. Pri jej zmene dostaneme chybu.
```
meňak neskutočné numeralio cislo = 5
meňak slovo servus          // môže byť aj "prázdne" (neinicializované)
// meňakom je možné zmeniť hodnotu
cislo = 6
servus = "hello"
```
```
furt neskutočné numeralio nemenne_cislo = 5
furt slovo jedine_servus = "servus"

// nebude fungovať, hodnotu furt nevieme zmeniť

// nemenne_cislo = 6
// jedine_servus = "hello"
```

### Dátové typy
Podporuje momentálne dátové typy - `neskutočné numeralio`, `slovo`, `logický`, `písmeno`, `skutočné numeralio`.

`neskutočné numeralio` predstavuje celé čísla. Ich podporovaný rozsah na platforme JVM je v intervale [-9223372036854775808; 9223372036854775807] alebo [-2<sup>63</sup>; 2<sup>63</sup>-1].

`skutočné numeralio` sú reálne čísla, vyjadrené desatinným číslom v rozsahu približne
2<sup>-1074</sup>&nbsp;<=&nbsp;x&nbsp;<=&nbsp;(2-2<sup>-52</sup>)&nbsp;&times;&nbsp;2<sup>1023</sup>.

Typ `písmeno` je jeden znak, písmeno, číslo, písmeno s diakritikou, tabulátor, nový riadok, a pod. Vyjadrený je medzi apostrofmi.

`slovo` vyjadruje sekvenciu znakov (typu `písmeno`). <code>slovo</code> je ohraničené dvoma dvojitými úvodzovkami.

Typ `logický` predstavuje bool/kleene hodnoty - `pravda`, `skoroošaľ`, `ošaľ`.

```
meňak neskutočné numeralio pejc = 5
meňak slovo dupa = "dupa"
meňak logický p = pravda
meňak logický o = ošaľ
meňak logický so = skoroošaľ
meňak skutočné numeralio cislo = 1.2
meňak písmeno pis = 'a'
meňak neskutočné numeralio veľo = 5000000000
```

#### Polia
Polia vytvoríme kľúčovým slovom `funduš`. Každé pole musí byť vytvorené s určením, koľko prvkov bude obsahovať. Vytváranie funguje pre všetky podporované [dátové typy](#dátové-typy).
```
furt neskutočné numeralio n = 10
funduš logický l[n]
funduš skutočné numeralio sn[n * n]
funduš neskutočné numeralio nn[n]

// môže byť použité aj s kľúčovým slovom 'dimenzion' pred 'funduš'
dimenzionfunduš písmeno p[n]
dimenzion funduš slovo s[n]
```
Prvky polí sú na začiatku inicializované na hodnoty, ktoré predpisuje aj JVM (`neskutočné numeralio` - `0`, `skutočné numeralio` - `0.0`, `logický` - `ošaľ`, `písmeno` - ` ` (prázdny znak/medzera), `slovo` - (java) `null`)

##### Prvky poľa
K prvkom poľa pristupujeme cez hranaté zátvory, v ktorých určíme index prvku. Prvky polí sú číslované od `0` po `dĺžka poľa - 1`
```
l[1] = pravda
l[2] = skoroošaľ
l[3] = ošaľ

nn[0] = 1
nn[1] = 2
nn[2] = 3
nn[3] = 4

p[0] = 'A'
s[0] = "aa"

ciskaj n

ciskaj p[0]
ciskaj sn[0]
ciskaj nn[0]
ciskaj s[0]

ciskaj l[0]
ciskaj l[1]
ciskaj l[2]
ciskaj l[3]

```

##### Pole znakov v type `slovo`
Typ `slovo` má v jazyku Šaral špeciálne postavenie. Môžme ho tiež používať ako pole znakov (typ `funduš písmeno`). Tzn. že vieme pristúpiť k znaku na určitom indexe v reťazci a taktiež môžeme zameniť ľubovoľný znak v premennej typu `slovo`. 
(Pristupovať a meniť jednotlivé prvky dokážeme meniť aj v konštante - `furt slovo`. Princíp je rovnaký ako pri poliach. Meníme len znak nie celú hodnotu).

```
furt slovo test = "test"
ciskaj test[1]          // 'e'

test[1] = 'a'
ciskaj test             // "tast"
``` 

### Operácie
#### Aritmetické operácie
Podporované sú matematické operácie medzi celými, reálnymi číslami a znakmi (typ `neskutočné numeralio`, `skutočné numeralio`, `písmeno`). Je dodržaná matematická prednosť operácií a zátvoriek.
- násobenie `*`
- delenie `/` alebo `:`
- ščítanie `+`
- odčítanie `-`
- zvyšok po delení (modulo) `%` (neplatí pre typ `skutočné numeralio`)
- negácia `-` (unárna operácia, neplatí pre typ `písmeno`)

```
bar neskutočné numeralio vracimDaco()
    meňak neskutočné numeralio pejc = 5
    vrac pejc
    
meňak neskutočné numeralio aa = 1 + 1
meňak neskutočné numeralio b = 2 * 10
meňak neskutočné numeralio c = 10 - (vrac mi z baru vracimDaco())
meňak neskutočné numeralio d = (1 + 1) * 3
meňak neskutočné numeralio e = (10 / 2)
meňak neskutočné numeralio f = (10 : 2)
meňak neskutočné numeralio g = 11 % 2
meňak neskutočné numeralio h = -aa
meňak skutočné numeralio i = 1.0
meňak skutočné numeralio j = -i
meňak skutočné numeralio l = 1 + 1.0

furt písmeno znak1 = 'A' - 'A'
furt písmeno znak2 = 'A' + 1
furt písmeno znak3 = 'A' + 'A'
furt písmeno znak4 = '.' * 2
furt písmeno znak5 = 'a' / 2
furt písmeno znak6 = 'c' % 2
```

#### Spájanie reťazcov
Operácia `+` má v jazyku Šaral aj druhý význam - spájanie reťazcov (typ `slovo`).
```
furt slovo s1 = "hello"
furt slovo s2 = " world"
furt slovo s3 = s1 + s2
ciskaj s3       // "hello world"
```
Stačí, ak je aspoň jedna strana výrazu typu `slovo`.
```
furt neskutočné numeralio num = 1
furt slovo s4 = s1 + num
ciskaj s4       // "hello 1"
```

#### Porovnávanie
Funguje porovnávanie výrazov, kde obidve strany výrazu sú rovnakého typu (typ `neskutočné numeralio`, alebo `skutočné numeralio`): 
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
meňak logický nee = 4 <> 4
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
meňak logický e3 = 4 == 4.0
meňak logický l4 = 4 < 4.1
```

#### Logické operácie
V jazyku Šaral poznáme 3 logické hodnoty, ktoré zodpovedajú hodnotám [Kleeneho logiky](https://en.wikipedia.org/wiki/Three-valued_logic) - 
`pravda` (`true`), `ošaľ` (`false`), `skoroošaľ` (`undefined`)

Tomu zodpovedajú aj podporované logické operácie:
- `ne` - negácia
- `a` - logická operácia `and`
- `abo` - logická operácia `or`

Výsledky kombinácie logických operácii a hodnôt zobrazujú tabuľky

##### Operácia `ne`
|a| `ne` a |  
|:-:|:------:|
|ošaľ|pravda|
|skoroošaľ|skoroošaľ|
|pravda|ošaľ|

##### Operácia `abo`
|abo| ošaľ | skoroošaľ | pravda | 
|:-:|:------:|:-----------:|:--------:|
|**ošaľ**|ošaľ|skoroošaľ|pravda|
|**skoroošaľ**|skoroošaľ|skoroošaľ|pravda|
|**pravda**|pravda|pravda|pravda|

##### Operácia `a`
|a| ošaľ | skoroošaľ | pravda | 
|:-:|:------:|:-----------:|:--------:|
|**ošaľ**|ošaľ|ošaľ|ošaľ|
|**skoroošaľ**|ošaľ|skoroošaľ|skoroošaľ|
|**pravda**|ošaľ|skoroošaľ|pravda|

```
meňak logický p = pravda
meňak logický o = ošaľ
meňak logický so = skoroošaľ

ciskaj p
ciskaj o
ciskaj so

meňak logický pap = p a p
meňak logický pao = p a o
meňak logický paso = p a so

meňak logický oap = o a p
meňak logický oao = o a o
meňak logický oaso = o a so

meňak logický soap = so a p
meňak logický soao = so a o
meňak logický soaso = so a so

ciskaj pap      // pravda
ciskaj pao      // ošaľ
ciskaj paso     // skoroošaľ
ciskaj oap      // ošaľ
ciskaj oao      // ošaľ
ciskaj oaso     // ošaľ
ciskaj soap     // skorošaľ
ciskaj soao     // ošaľ
ciskaj soaso    // skoroošaľ

meňak logický pabop = p abo p
meňak logický paboo = p abo o
meňak logický paboso = p abo so

meňak logický oabop = o abo p
meňak logický oaboo = o abo o
meňak logický oaboso = o abo so

meňak logický soabop = so abo p
meňak logický soaboo = so abo o
meňak logický soaboso = so abo so

ciskaj pabop    // pravda
ciskaj paboo    // pravda
ciskaj paboso   // pravda
ciskaj oabop    // pravda
ciskaj oaboo    // ošaľ
ciskaj oaboso   // skoroošaľ
ciskaj soabop   // pravda
ciskaj soaboo   // skoroošaľ
ciskaj soaboso  // skoroošaľ

meňak logický nep = ne p
meňak logický neo = ne o
meňak logický neso = ne so

ciskaj nep      // ošaľ
ciskaj neo      // pravda
ciskaj neso     // skoroošaľ
```

### Procedúry
Opakuje sa nám rovnaký kód a chceme ho prepoužiť? Nevadí, môžme si vytvoriť procedúru.
```
bar robim()
   meňak neskutočné numeralio tri = 3
   ciskaj tri
```

`bar` nám vraví, že máme procedúru, ktorá ma meno `robim` a nemá žiadne parametre. 

Nie je problém pridať parametre podporovaných dátových typov a polí.
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
Opakuje sa nám rovnaký kód a chceme vrátiť nejakú hodnotu výpočtu? Môžme si vytvoriť funkciu. Hodnotu funkcie vrátime prostredníctvom `vrac`, ktorý musí byť vždy na poslednom riadku funkcie.
```
bar neskutočné numeralio vracimDaco()
    meňak neskutočné numeralio pejc = 5
    vrac pejc
```
Samozrejme aj s ľubovoľným počtom parametrov podporovaných dátových typov a polí.
```
bar slovo vracimSlovo(slovo x)
    vrac x
```

Vytvorenú funkcie zavoláme prostredníctvom `vrac mi z baru`
```
vrac mi z baru vracimDaco()

meňak slovo dupa = "dupa"
vrac mi z baru vracimSlovo(dupa)

```

Dajte si pozor, pretože každý argument volanej funkcie musí byť inicializovaný na nejakú hodnotu. Rovnaké pravidlo platí aj pre volanie [procedúry](#procedúry)
```
meňak slovo dupa
vrac mi z baru vracimSlovo(dupa) // vráti chybu, lebo meňak dupa nie je inicializovaný
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
   
### Ohraničné opakovanie kódu
Ak chceme vykonať časť kódu istý počet krát, použijeme konštrukciu `zrob s meňakom <meňak> od <hodnota/premenná> do <hodnota/premenná>` (tzv. *kolečko*). Horné ohraničenie sa vždy ráta aj vrátanie.
```
zrob s meňakom x od 4 do 10
    ciskaj x
```
alebo
```
meňak neskutočné numeralio d = 4
meňak neskutočné numeralio h = 10
zrob s meňakom x od d do h
    ciskaj x
```
Môžme definovať kolečko aj s klesajúcimi hranicami
```
zrob s meňakom y od 10 do 1
    meňak neskutočné numeralio x = y * y
    ciskaj x
```

### Podmienené opakovanie kódu
Ak netušíme koľko krát, chceme vykonať určitú časť kódu, ale poznáme ohraničujúcu podmienku, použijeme *while-loop*. Cyklus sa vykonáva, kým je podmienka vyhodnotená na `pravda`.
```
meňak neskutočné numeralio x = 4
kým x <= 10 rob
    ciskaj x
    x = x + 1
```
```
meňak neskutočné numeralio y = 1
kým y <= 10 rob
    meňak neskutočné numeralio z = y * y
    ciskaj z
    y = y + 1
```

Zložitejšie bloky kódu (cykly a podmienky) môžme ľubovoľne vnárať a kombinovať.
```
zrob s meňakom i od 1 do 10
    keď i % 2 == 0 potom
        meňak neskutočné numeralio x = i
        kým x <= 10 rob
            ciskaj x
            x = x + 1
    inak
        zrob s meňakom j od i do 10
            ciskaj j
```
```
zrob s meňakom y od 1 do 10
    zrob s meňakom x od 1 do 10
        meňak neskutočné numeralio z = y * x
        ciskaj z
```

### Čítanie zo štardarného vstupu (konzoly)
V prípade, že potrebujeme komunikovať s počítačom a načítať z vstupy napísané v konzole, využijeme ekvivalentné príkazy `vežmi` alebo `sluchaj`.
```
meňak neskutočné numeralio nn
vežmi nn
// sluchaj nn
```
Tieto príkazy reagujú na typ premennej, do ktorej chceme čítať zo vstupu:
- `neskutočné numeralio`, vstup nesmie obsahovať žiaden iný znak okrem čísel a tiež nesmie prekročiť hodnotu maximálneho povoleného čísla [-2<sup>63</sup>; 2<sup>63</sup>-1].
- `skutočné numeralio`, číslo musí zodpovedať desatinnému formátu. Ak je vstup vo forme `neskutočné numeralio`, je automatický konvertovaný na `skutočné numeralio`.
- `logický`, hodnota `pravda` alebo `skoroošaľ` je načítaná iba vtedy, ak je na vstupe `"pravda"` alebo `"skoroošaľ"`, inak je vždy načítaná hodnota `ošaľ`.
- `písmeno`, načítaná je hodnota 1. znaku, bezohľadu na dĺžku vstupu.
- `slovo`, načítané bezo zmeny.

Podobne môžme získať hodnotu a priradiť ju do prvku definovaného poľa zodpovedajúceho typu
```
funduš neskutočné numeralio pole[2]
vežmi pole[0]
```
```
funduš slovo pole2[2]
vežmi pole2[0]
```
### Odsadenie
Jazyk Šaral oddeľuje bloky kódu pomocou medzier alebo tabulátorov na novom riadku (podobne ako [Python](https://www.python.org/)).


### Falda
Preprocessor podporuje vkladanie skladov (pomocou kľúčového slova `falda`). Sklad si môžeme predstaviť `.srl` súbor a funkcie v ňom, ktoré referencujeme a voláme v inom `.srl` súbore. Nielen z aktuálneho adresára, ale aj z adresára, ktorý dostane ako parameter (štandardne je to adresár `include`)

```
// falda "slova.srl"
bar slovo vracA()
    meňak slovo hodnota = "A"
    vrac hodnota
    
bar vypisA()
    meňak slovo hodnota = "A"
    ciskaj hodnota
```
```
// vloženie "falda" a zavolanie jednej z procedúr
meňak neskutočné numeralio pejc=5
ciskaj pejc

falda slova

paľ do baru vypisA()
```