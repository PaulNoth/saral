## ŠARAL 2.0 - ŠARIŠ ALGORITHMIC LANGUAGE 2.0

[Slovensky](README.md)

> I would like to introduce you with newest top level evolution in information crunching. It is a problem-science-tech-oriented programming language Šaral. The famous [šariš](https://en.wikipedia.org/wiki/%C5%A0ari%C5%A1)-american company IBM have always been trying to create a language, which a computer would understand as good as human understands

*Not all features all currently supported. Full specification [here](specification.md)*

### Java a Javac compatibility
Compiles to Java 10 bytecode.

### Compiler
We need to have [`maven`](https://maven.apache.org/) installed.

Then to generate a parser and a lexer files from `ANTLR` grammar - `Saral.g4`. (I recommend to download the [`antlr4`](https://mvnrepository.com/artifact/org.antlr/antlr4/4.5.3) lib and copy it to the project folder).
```
./generate.sh
```
Šaral source files have `srl` extension and we can compile it to JVM bytecode. It outputs `class` file. 

`java com.pidanic.saral.Compiler <saral_source_file.srl>`

Then run compiled program. 

`java <saral_source_file.class>`

### Program
It is for JVM, but you do not need to have `class`es. We declare few variables with `meňak` and print them to the console with `ciskaj`.
```
meňak neskutočné numeralio five = 5
ciskaj five
meňak slovo hello = "hello"
ciskaj hello
```

Second option to print something to the console is to use `povidz`. It is equivalent to `ciskaj`.
```
meňak neskutočné numeralio five = 5
povidz five
meňak slovo hello = "hello"
povidz hello
```

### Comments
They start with `//` and can appear at the beginning of a line and they will take whole line or at the end of a statement
```
meňak neskutočné numeralio five = 5
// this is a comment
ciskaj five
meňak slovo hello = "hello" // nice greeting
ciskaj hello
```

### Variables and constants
There is one type of variables (`meňak`), which value might be changed. But there exist a *constant* (`furt`), which values can not be changed.
```
meňak neskutočné numeralio number = 5
meňak slovo hello          // might be "empty" (not initialized)
// meňak value might be changed
number = 6
hello = "hello"
```
```
furt neskutočné numeralio same_number = 5
furt slovo only_hello = "servus"

// will not work, furt can not be changed

// same_number = 6
// only_hello = "hello"
```

### Data Types
There are data types supported - `neskutočné numeralio`, `slovo`, `logický`, `písmeno`, `skutočné numeralio`.

`neskutočné numeralio` represents integers. Using JVM platform, one could use them with following range [-9223372036854775808; 9223372036854775807] or [-2<sup>63</sup>; 2<sup>63</sup>-1].

`skutočné numeralio` are for real numbers, expressed as decimals in range approximately
2<sup>-1074</sup>&nbsp;<=&nbsp;x&nbsp;<=&nbsp;(2-2<sup>-52</sup>)&nbsp;&times;&nbsp;2<sup>1023</sup>.

Type `písmeno` is a single character, that is a letter, a digit, a punctuation mark, a tab, a space or something similar. A char literal is a single one character enclosed in single quote marks (apostrophes).

`slovo` is sequence of characters enclosed in double quotes.

Type `logický` represents boolean/kleene values - `pravda` (`true`), `skoroošaľ` (`undefined`), `ošaľ` (`false`).


```
meňak neskutočné numeralio five = 5
meňak slovo hello = "hello"
meňak logický p = pravda
meňak logický o = ošaľ
meňak logický so = skoroošaľ
meňak skutočné numeralio number = 1.2
meňak písmeno ch = 'a'
meňak neskutočné numeralio bigNumber = 5000000000
```

#### Arrays
The array are created using the keyword `funduš`. Each array have to be initialized with its length. Each [data type](#data-types) can be used in array.
```
furt neskutočné numeralio n = 10
funduš logický l[n]
funduš skutočné numeralio sn[n * n]
funduš neskutočné numeralio nn[n]

// there is optional 'dimenzion' keyword before 'funduš'
dimenzionfunduš písmeno p[n]
dimenzion funduš slovo s[n]
```
Šaral initialize each element of a array similar way JVM does (`neskutočné numeralio` - `0`, `skutočné numeralio` - `0.0`, `logický` - `ošaľ`, `písmeno` - ` ` (empty space), `slovo` - (java) `null`)

##### Array elements
To access individual elements in arrays, we use bracket with element index inside them. Index of an element is referenced from `0` to `array length - 1`.
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

##### Type `slovo` as array of `písmeno`
The type `slovo` has a special meaning in Šaral programming language. We could use it as array of characters (type `funduš písmeno`).
We could access an index or change it to the value we want on a given index.
(It is possible to change characters in constants - `furt slovo`. It works same as in arrays, because we change only the characters not the whole value).

```
furt slovo test = "test"
ciskaj test[1]          // 'e'

test[1] = 'a'
ciskaj test             // "tast"
``` 

In case we access the index of character that is greater than string length, the output is *null character* (`\0`, `\u0000`) in Šaral.
```
ciskaj test[6]          // '\u0000'
```

### Operations
#### Arithmetic operations
There are supported mathematical operation between integers, floats and characters (type `neskutočné numeralio`, `skutočné numeralio`, `písmeno`) with precedence of parentheses and operations.
- multiplication `*`
- division `/` or `:`
- addition `+`
- substraction `-`
- remainder (modulo) `%` (does not work for type `skutočné numeralio`)
- negation `-` (unary minus, does not work for `písmeno`)

```
bar neskutočné numeralio returnSomething()
    meňak neskutočné numeralio five = 5
    vrac five
    
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

furt písmeno char1 = 'A' - 'A'
furt písmeno char2 = 'A' + 1
furt písmeno char3 = 'A' + 'A'
furt písmeno char4 = '.' * 2
furt písmeno char5 = 'a' / 2
furt písmeno char6 = 'c' % 2

```

#### String concatenation
`+` operation has a second meaning in Šaral language - string concatenation (`slovo` type).
```
furt slovo s1 = "hello"
furt slovo s2 = " world"
furt slovo s3 = s1 + s2
ciskaj s3       // "hello world"
```
It is enough, that one of both expression is type of `slovo`.
```
furt neskutočné numeralio num = 1
furt slovo s4 = s1 + num
ciskaj s4       // "hello 1"
```

#### Comparisons
One can compare expressions with same type on both sides (type `neskutočné numeralio` or `skutočné numeralio`): 
- equal `==`
- not equal `<>`
- greater than `>`
- greater or equal `>=`
- less than `<`
- less or equal `<=`

A result will be `pravda` (true) value or `ošaľ` (false) value.
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

#### Logical operations
There are 3 supported logic values in Šaral. They are equivalent to [Kleene logic](https://en.wikipedia.org/wiki/Three-valued_logic) - 
`pravda` (`true`), `ošaľ` (`false`), `skoroošaľ` (`undefined`)

There are 3 corresponding logic operations
- `ne` - negation
- `a` - operation `and`
- `abo` - operation `or`

These tables show all combinations of operations and values with their results

##### `ne` operation
|a| `ne` a |  
|:-:|:------:|
|ošaľ|pravda|
|skoroošaľ|skoroošaľ|
|pravda|ošaľ|

##### `abo` operation
|`abo`| ošaľ | skoroošaľ | pravda | 
|:-:|:------:|:-----------:|:--------:|
|**ošaľ**|ošaľ|skoroošaľ|pravda|
|**skoroošaľ**|skoroošaľ|skoroošaľ|pravda|
|**pravda**|pravda|pravda|pravda|

##### `a` operation
|`a`| ošaľ | skoroošaľ | pravda | 
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

### Procedures
Do we repeat same code and we want to reuse it? No problem, we have procedures.
```
bar iDoSomething()
   meňak neskutočné numeralio three = 3
   ciskaj three
```

With `bar`, we declare procedure with name `iDoSomething`. It is without parameters. 

We can add parameters. They need to be in supported data types and arrays.
```
bar iDoSomethingElse(neskutočné numeralio x)
    ciskaj x
```

We call the procedure with `paľ do baru`
```
paľ do baru iDoSomething()

meňak neskutočné numeralio five = 5
paľ do baru iDoSomethingElse(five)

```

### Functions
Do we repeat same code? Do we want to return a calculated value? We have functions. Value is returned with `vrac`, which have to be on last line of the function.
```
bar neskutočné numeralio returnSomething()
    meňak neskutočné numeralio five = 5
    vrac five
```

Function arguments are supported in supported data types and arrays.
```
bar slovo returnString(slovo x)
    vrac x
```

We call the function with `vrac mi z baru`
```
vrac mi z baru returnSomething()

meňak slovo hello = "hello"
vrac mi z baru returnString(hello)

```

Be aware, that you have to initialize every function argument to a value. The same principle holds for [procedures](#procedures)
```
meňak slovo word
vrac mi z baru vracimSlovo(word) // error, meňak word is not initialized
```

### For-loops
One can execute a part of the code with defined range with `zrob s meňakom <variable> od <value/variable> do <value/variable>` (so called. *for-loop*). The upper bound is always **included**.
```
zrob s meňakom x od 4 do 10
    ciskaj x
```
or
```
meňak neskutočné numeralio l = 4
meňak neskutočné numeralio u = 10
zrob s meňakom x od l do u
    ciskaj x
```
Decremented for loop is possible as well
```
zrob s meňakom y od 10 do 1
    meňak neskutočné numeralio x = y * y
    ciskaj x
```
### While loops
Loops with conditional execution (*while-loops*) are created with following construct. The loop is executed only when the loop condition has `pravda` value.
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


### Conditional statements
Šaral language support conditional code execution as other problem-oriented programming languages, so called `if-then-else`. In Šaral terminology `keď-potom-inak`

```
keď 1 > 0 potom
    paľ do baru iDoSomething()
inak
    paľ do baru iDoSomethingElse(five)
```

The `inak` part is optionial
```
keď 2 > 0 potom
    meňak neskutočné numeralio two = 2
    ciskaj two
``` 

We can combine blocks of code (loops and condition) within themselfs.
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

### Reading from standard input (console)
In case we want to communicate with computer, we can use 2 commands `sluchaj` or `vežmi` to read input written in the console.
```
meňak neskutočné numeralio nn
vežmi nn
// sluchaj nn
```
They behave based on the variable type, we want to read to:
- `neskutočné numeralio`, input is not allowed to contain character or to exceed maximum integer value [-2<sup>63</sup>; 2<sup>63</sup>-1].
- `skutočné numeralio`, needs to be in decimal format. If the input is in `neskutočné numeralio` format, it is autoamtically converted.
- `logický`, the value `pravda` or `skoroošaľ` is read only if there is `"pravda"` or `"skoroošaľ"` as an input, otherwise `ošaľ` value is set.
- `písmeno`, always reads 1st character regardless input length.
- `slovo`, read without change, as is typed.

Similar way we can read a value and assign it to an element of an array of corresponding type.
```
funduš neskutočné numeralio array[2]
vežmi array[0]
```
```
funduš slovo array2[2]
vežmi array2[0]
```

### Indentation
The Šaral language separates blocks of code with spaces or tabs on a new line (similar as [Python](https://www.python.org/)).
