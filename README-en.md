## ŠARAL 2.0 - ŠARIŠ ALGORITMIK LENGVIDŽ 2.0

[Slovensky](README.md)

> I would like to introduce you with newest top level evolution in information crunching. It is a problem-science-tech-oriented programming language Šaral. The famous [šariš](https://en.wikipedia.org/wiki/%C5%A0ari%C5%A1)-american company IBM have always been trying to create a language, which a computer would understand as good as human understands

*Not all features all currently supported. Full specification [here](specification.md)*

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
It is for JVM, but you do not need to have `class`es. We declare few variables with `meňak` and print them to the console with `ciskaj`-
```
meňak neskutočné numeralio five = 5
ciskaj five
meňak slovo hello = "hello"
ciskaj hello
```

### Data Types
There are data types supported - `neskutočné numeralio` (integer), `slovo` (string) `logický` (boolean/kleene - `pravda`, `skoroošaľ`, `ošaľ`), `písmeno` (character), `skutočné numeralio` (floats).

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

### Operations
#### Arithmetic operations
There are supported mathematical operation between integers (type `neskutočné numeralio`) with precedence of parentheses and operations.
- multiplication `*`
- division `/` or `:`
- addition `+`
- substraction `-`
- remainder (modulo) `%`

```
bar neskutočné numeralio returnSomething()
    meňak neskutočné numeralio five = 5
    vrac five
    
meňak neskutočné numeralio a = 1 + 1
meňak neskutočné numeralio b = 2 * 10
meňak neskutočné numeralio c = 10 - (vrac z baru vracimDaco())
meňak neskutočné numeralio d = (1 + 1) * 3
meňak neskutočné numeralio e = (10 / 2)
meňak neskutočné numeralio f = 10 : 2
meňak neskutočné numeralio g = 11 % 2
```

#### Comparisons
One can compare integer values (type `neskutočné numeralio`): 
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

### Procedures
Do we repeat same code? No problem, we have procedures.
```
bar iDoSomething()
   meňak neskutočné numeralio three = 3
   ciskaj three
```

With `bar`, we declare procedure with name `iDoSomething`. It is without parameters. 

We can add parameters. They need to be in supported data types.
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
Do we repeat same code? Do we want to return a calculated value? We have functions.
```
bar neskutočné numeralio returnSomething()
    meňak neskutočné numeralio five = 5
    vrac five
```

Function arguments are supported.
```
bar slovo returnString(slovo x)
    vrac x
```

We call the function with `vrac z baru`
```
vrac z baru returnSomething()

meňak slovo hello = "hello"
vrac z baru returnString(hello)

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

### Indentation
The Šaral language separates blocks of code with spaces or tabs on a new line (similar as [Python](https://www.python.org/)).
