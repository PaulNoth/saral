## ŠARAL 2.0 - ŠARIŠ ALGORITMIC LENGVIDŽ 2.0
*Note: This is the English translation of the [original document in Slovak](https://github.com/laciKE/saral/blob/master/specifikacia.md).*

---

My specification is based on a former [Šaral presentation](http://www.trsek.com/sr/clanky/saral) (Slovak).

Identifier are composed from lower and uppercase characters, digits and underscores. They can start with a letter or an underscore, such as `_?[:letter:]([:digit:][:letter:]_)*`.

#### Key words:
* `furt`
* `meňak`
* `parcela`
* `dimenzion`
* `pravda`
* `ošaľ`
* `skoroošaľ`
* `logický`
* `skutočné`
* `neskutočné`
* `numeralio`
* `písmeno`
* `slovo`
* `falda`
* `inakši`
* `bar`
* `paľ do baru`
* `vrac še z baru`
* `vrac`
* `stuj`
* `keď`
* `potom`
* `inak`
* `zrob s meňakom`
* `od`
* `do`
* `kým`
* `rob`
* `ciskaj`
* `vežmi`
* `sluchaj`
* `povidz`
* `a`
* `alebo`
* `ne`

Keywords `dimenzion` a `stuj` stay in Šaral 2.0 specification preserving backward compatibility with former Šaral specification.

#### Operators
* `+`, `-`, `*`, `/`, `:`, `%`
* `a`, `alebo`, `ne`
* `==`, `<`, `>`, `<=`, `>=`, `<>`
* `=`
* `[]`

#### Data types
* `skutočné numeralio`
* `neskutočné numeralio`
* `logický`
* `písmeno`
* `slovo`
* `funduš`

First 4 types are considered as primitive, first 5 as basic, type `funduš` as container type.

##### Trinary logic
Šaral uses [Three-valued logic](https://en.wikipedia.org/wiki/Three-valued_logic) with these values `pravda`, `ošaľ` & `skoroošaľ`. They represent `True`, `False` a `Unknown` in [Kleene's logic](https://en.wikipedia.org/wiki/Three-valued_logic#Kleene_and_Priest_logics). That means a condition is only true if all statement have `pravda` value.

#### Variable and constants declarations
```
<modifier> <type> <name>
<modifier> <type> <name> = <value>
```
`<modifier>` means, either identifier `<name>` is a variable (`meňak`) or a constant (`furt`). By declaring `furt` it is required to initialize to some value.

##### Examples
```
furt skutočné numeralio pi = 3.14
furt neskutočné numeralio answer = 42
meňak logický big = ošaľ
meňak slovo name
meno = "Ladislav"
meňak písmeno class = 'A'
```

#### Array declarations
```
funduš <type> <name> [dimension]
funduš <type> <name> [dimension]

dimenzion funduš <type> <name> [dimension]
dimenzion funduš <type> <name> [dimension]
```
It is recommended to use first declaration with `funduš`. Keyword `dimenzion` is supported preserving backward compatibilty with first Šaral version. Array `dimension` must be of type `neskutočné numerálio`.

##### Examples
```
funduš skutočné numeralio šč [3]
meňak neskutočné numeralio N = 42
dimenzion funduš logický fň [N]
```

#### Procedures and functions
Šaral supports functions and procedures. Looking from higher perspective they appear to be like black boxes `bar` (pub) - some things enter inside and sometimes something is returned outside.

```
bar <name>(<type> <name>, <type> <name>, ...)
	...
	decription, what is going on in a pub
	...


bar <name>(<type> <name>, <type> <name>, ...)
	...
	decription, what is going on in a pub
	...
	vrac <value>
```
First `bar` does not return anything, second bar after finishing returns a value, which has the same type as `bar`.
If we want to call services of a bar `bar`, we do it by calling `paľ do baru` as a procedure or `vrac mi z baru` as a function. As an input argument can be used `meňak` of arbitrary type, `bar` can only return arbitrary basic type. Input arguments are passed by reference.

#####External functions
We can call other `bar`s from external environments, which use different languages (types must be the same as in Šaral 2.0). If we want to taste an external `bar`, we call it by word `inakši`

```
inakši bar <name>(<type> <name>, <type> <name>, ...)

inakši <type> bar <name>(<type> <name>, <type> <name>, ...)
```


##### Examples
```
inakši bar neskutočné numeralio puts(slovo s)

bar ZámenaManželiek(neskutočné numeralio A, neskutočné numeralio B)
	A = A + B
	B = A - B
	A = A - B

bar slovo SlovakPub()
	meňak slovo food = "Bryndzove halusky";
	vrac jedlo

meňak slovo halusky
halusky = vrac mi z baru SlovakPub()

meňak neskutočné numeralio X = 500
meňak neskutočné numeralio Y = 600
paľ do baru ZámenaManželiek(X, Y)
```

#### Conditions
```
keď (furt | meňak) == (furt | meňak) potom
	...
inak
	...

keď (logický furt | meňak) potom
	...
inak
	...
```
The `inak` part is not required.

#### Loops
We declare the **for-loop** like construct as:
```
zrob s meňakom <name> od (furt | meňak) do (furt | meňak)
	...
```
*variables in loop are in interval `<from;to)`*

**While loop**:
```
kým (furt | meňak) == (furt | meňak) rob
	...

kým (logický furt | meňak) rob
	...
```

#### I/O
##### stdin/stdout
To print something on standard output we call `ciskaj <name>`, where `<name>` is a `meňak` or `furt`.
To read from input we call `vežmi <name>`, where `<name>` is a `meňak`, we want to read.
