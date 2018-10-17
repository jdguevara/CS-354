"gst CheckingAccount.st"
"Smalltalk Checking Account class"
"author - Jaime Guevara"

Account subclass: CheckingAccount [
    |number|
    |customer|
    |balance|

    CheckingAccount class [
        new: n customer:c balance:b [
            ^super new init: n customer:c balance:b
        ]
    ]

    init: n customer: c balance: b [
	    number:=n.
	    customer:=c.
	    balance:=b
    ]

    accrue: rate[]

]

