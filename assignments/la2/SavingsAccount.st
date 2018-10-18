"gst SavingsAccount.st"
"Smalltalk savings account class"
"author - Jaime Guevara"

Account subclass: SavingsAccount [
    |interest|

    init: n customer: c balance: b [
        number:=n.
        customer:=c.
        balance:=b.
		interest:=0.0
    ]

    accrue: rate [
        balance:=balance+(balance*rate).
        interest:=interest+(interest*rate).
    ]

]
