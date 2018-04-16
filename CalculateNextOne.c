#include<stdio.h>
#define N 5

char f[N];

int input();
int output();
int nextOne();
int reverse(int i);
int swap(int i, int j);
int findTheLastIncrease();
int findTheLastOverx(int x);

int main() {
	input();
	while(nextOne()){
	output();
	}
}

int input() {
	int j = 0;
	while(j != N) {
		scanf("%c", &f[j]);
		j = j + 1;
	}
}

int findTheLastIncrease() {
	int i = 1, temp = 0;
	while(i != N) {
		if(f[i] > f[i-1])
			temp = i;
		i = i + 1;
	}
	return temp;
}

int findTheLastOverx(int x) {
	//scanf("%c", &x);
	int j = 0, temp = 0;
	while(j != N) {
		if(x < f[j])
			temp = j;
		j = j + 1;
	}
	return temp;
}

int reverse(int i) {
	int k = 0;
	while(k != (N-i)/2) {
		swap(N - 1 - k, i + k);
		k = k + 1;
	}
}

int nextOne() {
	int i = findTheLastIncrease();
	if(i != 0) {
		int j = findTheLastOverx(f[i-1]);
		swap(j, i-1);
		reverse(i);
		return 1;
	}

	else if(i == 0)
		return 0;
}

int swap(int i, int j) {
	int temp = f[i];
	f[i] = f[j];
	f[j] = temp;
}

int output() {
	printf("%s\n", f);
}