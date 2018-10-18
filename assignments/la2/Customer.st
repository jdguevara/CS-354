"gst Customer.st"
"Smalltalk Customer class"
"author - Jaime Guevara"

Object subclass: Customer [

    |name|

    Customer class [
        new: n [
            ^self new init:n
        ]
    ]

    init: n [
        name:=n
    ]

    asString [
	    ^name
    ]

]
