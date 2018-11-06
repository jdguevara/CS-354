:- include('data.pl').

meet(Person, slot(time(U,V),time(X,Y))) :-
	free(Person,slot(time(A,B),time(D,E))),
	J is U+(V/100), K is X+(Y/100),
	L is A+(B/100), M is D+(E/100),
	L=<J,
	M>=K.

main :- meet(Person,slot(time(8,30),time(8,45))),write(Person),nl,halt.

:- initialization(main).
