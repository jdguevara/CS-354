"gst Account.st"
"Smalltalk Account class"
"author - Jaime Guevara"

Object subclass: Account [

    |number|
    |customer|
    |balance|

    accrue: rate [
        ^self
    ]

    balance [
	    ^balance
    ]

    deposit: amount [
	    balance:=balance+amount.
	    ^self
    ]

    withdraw: amount [
	    balance:=balance-amount.
	    ^self
    ]

    toString [
	    ^number:=number , ':' , customer , ':' , balance
    ]

]
