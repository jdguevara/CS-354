:- include('data.pl').

main :- (meetone(Person,slot(time(8,30),time(8,45))); halt),
	write(Person),
        nl,
        halt.

:- initialization(main).
