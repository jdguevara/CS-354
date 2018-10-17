"gst SavingsAccount.st"
"Smalltalk savings account class"
"author - Jaime Guevara"

Account subclass: SavingsAccount [

    |interest| interest:=0.0.

    SavingsAccount class [
        new: n customer:c balance:b [
            ^super new init: n customer:c balance:b
        ]
    ]

    init: n customer: c balance: b [
        number:=n.
        customer:=c.
        balance:=b
    ]

    accrue: rate [
        balance:=balance+(balance*rate).
        interest:=interest+(balance*rate).
    ]

]
