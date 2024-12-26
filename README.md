# Compiler Design
A multi-phase compiler implemented in Java that performs lexical analysis, parsing, and semantic analysis. The compiler supports a custom programming language with features for numeric operations, set manipulation, and boolean logic.

## Features

### Language Support
<li>Three variable types: numbers, sets, and booleans</li>
<li>Function declarations with parameters and return values</li>
<li>Control structures (if-else, for loops, while loops)</li>
<li>Set operations (union, intersection, membership testing)</li>
<li>Dynamic scoping with activation records</li>

### Core Components

#### Symbol Table Management (HLSymbTab.java)
<li>Symbol table entries for variables and functions</li>
<li>Type checking and value storage</li>
<li>Support for global and local variable scopes</li>
<li>Function declaration and parameter handling</li>

#### Activation Records (HLActivation.java)
<li>Stack-based activation record management</li>
<li>Lexical parent tracking for scope chains</li>
<li>Variable binding and lookup in current scope</li>
<li>Support for nested function calls</li>

#### Name Resolution (HLNameStack.java)
<li>Stack-based name resolution system</li>
<li>Identifier tracking across multiple scopes</li>
<li>Dynamic symbol table entry management</li>

### Language Features

#### Variables
<li>Numeric variables (lowercase identifiers)</li>
<li>Set variables (uppercase identifiers)</li>
<li>Boolean variables (# prefix)</li>
<li>Automatic type inference</li>

#### Expressions
<li>Arithmetic operations (+, -, *, /, %)</li>
<li>Set operations (union, intersection)</li>
<li>Comparison operators (<, >, <=, >=, ==, !=)</li>
<li>Boolean operators (AND, OR, NOT)</li>

#### Control Flow
<li>If-then-else statements</li>
<li>For loops with set iteration</li>
<li>While loops with boolean conditions</li>
<li>Function calls with return values</li>

## Implementation Details

### 1) Parser Generator
<li>Uses JavaCC for lexical analysis and parsing</li>
<li>Generates AST classes in dedicated directory</li>
<li>Supports operator precedence and associativity</li>

### 2) Semantic Analysis
<li>Type checking for operations and assignments</li>
<li>Scope management for variable declarations</li>
<li>Function parameter validation</li>
<li>Return value type checking</li>

## Sample Usage

```// Variable declarations
VAR x, y, Z;  // x,y are numbers, Z is a set

// Set operations
Z = {1, 2, 3};
Z = Z + {4, 5};  // Set union

// Function declaration
FUNCTION max(a, b)
    IF a > b THEN
        RETURN a;
    ELSE
        RETURN b;
    FI
END
```

## Getting Started
<li>1. Clone the repository.</li>

```
git clone https://github.com/hadi-awan/Compiler-Design.git
cd Compiler-Design
```

<li>2. Generate parser files.</li>

```
javacc HL.jjt
```

<li>3. Compile the Java files.</li>

```
javac *.java AST/*.java
```

## Running Tests
<li>1. Create a test file (e.g., test.txt) with sample code.</li>

<li>2. Run the compiler.</li>

```
java TestHL test.txt
```

## Project Structure
```HLActivation.java:``` Manages runtime activation records <br>
```HLEval.java:``` Implements the AST visitor for evaluation <br>
```HLNameStack.java:``` Handles name resolution and scoping <br>
```HLSymbTab.java:``` Symbol table implementation <br>
```TestHL.java:``` Main test driver <br>
```HL.jjt:``` JavaCC grammar specification <br>
