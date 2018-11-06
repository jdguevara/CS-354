:- include('data.pl').

people([ann,bob,carla]).

main :- (setof(Slot,meet(Slot),Slots); halt),
        write(Slots),
        nl,
        halt.

:- initialization(main).
