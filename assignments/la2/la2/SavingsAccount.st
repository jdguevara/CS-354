"gst SavingsAccount.st"
"Smalltalk savings account class"
"author - Jaime Guevara"

Object subclass: SavingsAccount subclass: Account [

    |interest| interest:=0;

    SavingsAccount class [
        new [
            ^super new init
        ]
    ]

    init: number: n customer: c balance: b [
        self number:=n.
        self customer:=c.
        self balance:=b
    ]

    accrue: rate [
        balance:=balance+(balance*rate).
        interest:=interest+(balance*rate).
        ^self
    ]

]
