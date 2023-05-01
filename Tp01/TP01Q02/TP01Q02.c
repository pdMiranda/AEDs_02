#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>


#define NUMLINHA    1000
#define TAMPALAVRA  100

bool isFim(char s[]){
    return (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

bool isPalindrome(char s[]){
    bool isPal = true;
    int cont = 0;
    for(int i =  0; i < strlen(s) - 1; i++){
        if(s[i]!= s[strlen(s)- i - 1]){
            cont++;
        }
    }
    if(cont != 0){
        isPal = false;
    }
    return isPal;
}

int main(){
    char entrada[NUMLINHA][TAMPALAVRA];
    int respostas[10000];
    int numEntradas = 0;
    do{
        scanf("%[^\n]%*c", entrada[numEntradas]);
        if(isPalindrome(entrada[numEntradas])) respostas[numEntradas] = 1;
        else respostas[numEntradas] = 0;
    }while(isFim(entrada[numEntradas++]) == false);
    numEntradas--;

    for(int i = 0; i < numEntradas; i++){
        if(respostas[i] == 1) printf("SIM\n");
        else printf("NAO\n");
    }

    return 0;
}