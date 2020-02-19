program firstFortran
        implicit none

        INTEGER :: n, Lunkers, Loonters, Little, Pooney
	
	Character(LEN = 8) :: DateINFO
	Character(LEN = 10) :: TimeINFO
	character(Len = 4) :: Year, Month*2, Day*2
	character(Len = 2) :: Hour, Minute

	
	call date_and_time(DateINFO, TimeINFO)
	
	Year = DateINFO(1:4)
	Month = DateINFO(5:6)
	Day = DateINFO(7:8)
	
	Hour = TimeINFO(1:2)
	Minute = TimeINFO(3:4)

	print*, Month, "-", Day, "-", Year, ", ", Hour, ":", Minute

	do
        print*, "How much to convert?"
        READ(*,*)  n
        if (n.GT.1.AND.n.LT.99) exit
        PRINT*, "Need 1-99"
        end do

       	Lunkers =  MakeChange(n, 30)
	Loonters = MakeChange(n - (Lunkers * 30), 15)
	Little = MakeChange(n - (Lunkers * 30) - (Loonters * 15),5)
	Pooney = MakeChange(n - (Lunkers * 30) - (Loonters *15) - (Little * 5),1)
	

        if (Lunkers.GT.0)then
       	call printStuff(Lunkers, "Lunkers")
        end if

	if (Loonters.GT.0)then
	call printStuff(Loonters, "Loonters")
	end if
	
        if (Little.GT.0)then
        call printStuff(Little, "Little")
        end if

        if (Pooney.GT.0)then
        call printStuff(Pooney, "Pooney")
        end if
			
contains

Integer function  MakeChange(money, coinValue) 
        IMPLICIT NONE
        INTEGER, INTENT(IN) ::money, coinValue
        INTEGER :: m, c, i

	MakeChange = 0	

	m = money

	c = coinValue

	do i=c,m,c
	m = m - c
	MakeChange = MakeChange + 1
	end do
		
	return 


end function MakeChange
subroutine printStuff(coinAmnt, coinType)
	Integer, intent(IN) :: coinAmnt
	character (len = *) :: coinType

	!print*, coinAmnt

	write(*,'(i9,a9)', advance = 'no')coinAmnt,coinType
	!write(*,"(3f8.3)", advance = 'no') coinAmnt,coinType 


end subroutine printStuff
end program firstFortran
