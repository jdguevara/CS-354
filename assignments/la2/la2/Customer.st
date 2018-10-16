"gst Customer.st"
"Smalltalk Customer class"
"author - Jaime Guevara"

Object subclass: Customer [

    |name|

    Customer class [
        new [
            ^super new init
        ]
    ]

    init: name [
        self name:=name

    toString [
	    ^self name
    ]

]
