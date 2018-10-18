"gst CheckingAccount.st"
"Smalltalk Checking Account class"
"author - Jaime Guevara"

Account subclass: CheckingAccount [
    init: n customer: c balance: b [
	    number:=n.
	    customer:=c.
	    balance:=b
    ]

    accrue: rate[]

]

