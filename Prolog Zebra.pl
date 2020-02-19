adjcnt(X,Y) :- X is Y+1; X is Y-1.  

rooms([bedroom(_, 1), bedroom(_, 2), bedroom(_, 3), bedroom(_, 4), bedroom(_, 5)]).

layout(X) :- rooms(X),
	
	member(bedroom(hunter, V), X),
	member(bedroom(laura, W), X),
	member(bedroom(arnie, A), X),
	member(bedroom(ramey, Y), X),
	member(bedroom(addiley, Z), X),
		
	V\=5,
	W\=1,
	A\=1,
	A\=5,
	Y@>W,
	\+adjcnt(A,W),
	\+adjcnt(A,Z).
