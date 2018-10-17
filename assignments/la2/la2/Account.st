"gst Account.st"
"Smalltalk Account class"
"author - Jaime Guevara"

Object subclass: Account [

    |number|
    |customer|
    |balance|

    Account class [
        new: n customer:c balance:b [
            ^super new init: n customer:c balance:b
        ]
    ]

    init: n customer:c balance:b [
        ^self subclassResponsibility
    ]

    accrue: rate [
        ^self subclassResponsibility
    ]

    accountBalance [
	    ^balance
    ]

    deposit: amount [
	    balance:=balance+amount
    ]

    withdraw: amount [
	    balance:=balance-amount
    ]

    asString [
	    ^number:=number , ':' , customer , ':' , balance
    ]

]
