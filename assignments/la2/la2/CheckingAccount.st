"gst CheckingAccount.st"
"Smalltalk Checking Account class"
"author - Jaime Guevara"

Object subclass: CheckingAccount subclass: Account [
    |number|
    |customer|
    |balance|

    CheckingAccount class [
        new [
            ^super new init
        ]
    ]

    init: number: n customer: c balance: b [
	    self number:=n.
	    self customer:=c.
	    self balance:=b
    ]

    accrue: rate[]

]

