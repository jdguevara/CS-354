"gst Bank.st"
"Smalltalk Bank program"
"author - Jaime Guevara"

Object subclass: Bank [
    |accounts|

    Bank class [
        new [
            ^super new init
        ]
    ]

    init [
        Account := Set new
    ]

    add: account [
        accounts add: account
    ]

    accrue: rate [
        accounts do: [ :account | account accrue: rate]
    ]

    toString [
        |r| r:=''.
        accounts do: [ :each | r:=r, (Character c asString), each toString].
        ^r
    ]

    |bank| bank:=Bank new.
    |customer| customer:=Customer new init: 'Ann'.
    bank add: (((account:=CheckingAccount new number: '01001') customer: c) balance: 100.00).
    bank add: (((account:=SavingsAccount new number: '01002') customer: c) balance: 200.00).
    bank accrue: 0.02.
    bank toString
]
