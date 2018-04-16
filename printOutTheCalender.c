#include <stdio.h>
 
//char week[7][10] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
//int days[4] = {31, 30, 28, 29};
int LeapYear(int year);
int bigMonth(int mm);
int leapMonth(int mm, int yy);
int notleapMonth(int mm, int yy);
int printCalender(int ww, int mm, int yy);
int findFirstDayOfWeek(int mm, int yy);

int main()
{
	int mm, yy;
	printf("please enter the month and year(mm yyyy) : __ ____\b\b\b\b\b\b\b");
	scanf("%d %d", &mm, &yy);
	int ww = findFirstDayOfWeek(mm, yy);
	printCalender(ww, mm, yy);
}



int LeapYear(int year)
{
	if(year % 4 == 0)
	{
		if(year % 100 == 0 && year % 400 != 0)
			return 0;
		else
			return 1;
	}
	else
		return 0;
}

int bigMonth(int m)
{
	if( m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
		return 1;
	else
		return 0;
}

int leapMonth(int mm, int yy)
{
	if(mm == 2 && LeapYear(yy))
		return 1;
	else
		return 0;
}

int notleapMonth(int mm, int yy)
{
	if(mm == 2 && !LeapYear(yy))
		return 1;
	else
		return 0;
}

int printCalender(int ww, int mm, int yy)
{
	printf(" --------------------------------------- \n");//draw the frame.
	printf("|SUN | MON | TUE | WED | THU | FRI | SAT|\n");
	int dd = 1;
	int cnt = ww;
	printf("|");//draw the frame.

	while(ww != 0)
	{
		printf("    | ");//draw the frame.
		ww = ww - 1;
	}

	int limit;

	if(bigMonth(mm))
		limit = 31;
	else if(leapMonth(mm, yy))
		limit = 29;
	else if(notleapMonth(mm, yy))
		limit = 28;
	else
		limit = 30;

	ww = (7 - (cnt + limit) % 7)%7;

	while(dd <= limit)
	{

		if(cnt == 0)
			printf("|");//draw the frame.
		printf("%3d", dd);
		if(cnt == 6)
		{
			printf("|\n");//draw the frame.
			cnt = 0;
		}

		else
		{
			cnt = cnt + 1;
			printf(" | ");//draw the frame.
		}
		dd = dd + 1;
	}

	while(ww != 0)
	{
		if(ww == 1)
			printf("   |\n");//draw the frame.
		else
			printf("    | ");//draw the frame.
		ww = ww - 1;
	}

	printf(" --------------------------------------- ");//draw the frame.
}

int findFirstDayOfWeek(int mm, int yy)
{
	int day = 1;
	int i = 1900;
	if(yy >= 1900)
	{
		while(i < yy)
		{
			if(LeapYear(i))
				day = day + 366;
			else if(!LeapYear(i))
				day = day + 365;
			i++;
		}

		int j = 1;

		while(j < mm)
		{
			if(bigMonth(j))
				day = day + 31;
			else if(leapMonth(j, yy))
				day = day + 29;
			else if(notleapMonth(j, yy))
				day = day + 28;
			else
				day = day + 30;
			j++;
		}

		day = day % 7;
		return day;
	}

	else if(yy < 1900)
	{
		while(i > yy)
		{
			if(LeapYear(i))
				day = day - 366;
			else if(!LeapYear(i))
				day = day - 365;
			i--;
		}

	int j = 1;

	while(j < mm)
		{
			if(bigMonth(j))
				day = day + 31;
			else if(leapMonth(j, yy))
				day = day + 29;
			else if(notleapMonth(j, yy))
				day = day + 28;
			else
				day = day + 30;
			j++;
		}

		day = (7 - (-1 * day)%7)%7;
		return day;
	}
}