## ŠARAL 2.0 - ŠARIŠ ALGORITMIK LENGVIDŽ 2.0

[Slovensky](README-SK.md)

> I would like to introduce you with newest top level evolution in information crunching. It is a problem-science-tech-oriented programming language Šaral. The famous [šariš](https://en.wikipedia.org/wiki/%C5%A0ari%C5%A1)-american company IBM have always been trying to create a languge, which a computer would understand as good as human understands

*Not all features all currently supported. Full specification [here](specification.md)*

### Compiler
We need to have [`maven`](https://maven.apache.org/) installed.

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
There are 2 data types supported - `neskutočné numeralio` (integer) a `slovo` (string).


### Procedures
Do we repeat same code? No problem, we have procedures.
```
bar iDoSomething()
{
   meňak neskutočné numeralio three = 3
   ciskaj three
}
```

With `bar`, we declare procedure with name `iDoSomething`. It is without parameters. 

We can add parameters. They need to be in supported data types.
```
bar iDoSomethingElse(neskutočné numeralio x)
{
    ciskaj x
}
```

We call the procedure with `paľ do baru`
```
paľ do baru iDoSomething()

meňak neskutočné numeralio five = 5
paľ do baru iDoSomethingElse(five)

```
