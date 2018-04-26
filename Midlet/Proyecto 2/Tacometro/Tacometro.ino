#include <SoftwareSerial.h>
#include <LiquidCrystal.h>
SoftwareSerial BTserial(1, 0); // RX | TX

const int rs = 53, en = 51, d4 = 49, d5 = 47, d6 = 45, d7 = 43;
LiquidCrystal lcd(rs, en, d4, d5, d6, d7);

int aspas = 2;
int boton = 3;
int RPM = 0;
volatile int contador = 0;  // Variable entera que se almacena en la RAM del Micro

void setup() 
  {
    Serial.begin(115200);
    lcd.begin(16,2);
    BTserial.begin(9600);
    attachInterrupt(0, interrupcion0, RISING);  // Interrupcion 0 (pin2) 
    pinMode(boton, INPUT);
  }       // LOW, CHANGE, RISING, FALLING

  
void loop() 
  {
     int val = digitalRead(boton);  
      if (val == LOW) 
        {    
          Serial.print("\nPuchado");    
              if(aspas == 2)
                {
                  aspas = 3;                  
                }
              else
                {
                  aspas = 2;                  
                }
          delay(300);   
                                                     
        }
    delay(999);          
     // retardo de casi 1 segundo
    RPM = contador * (60 / aspas);
    //Serial.print(RPM); // Como son dos interrupciones por vuelta (contador * (60/aspas))
    //Serial.println(" RPM"); //  El numero 2 depende del numero aspas de la hélice del motor en prueba
    
    lcd.clear();
    lcd.print(RPM);
    lcd.print(" RPM");
    lcd.setCursor(0,1);
    lcd.print("Aspas: ");
    lcd.print(aspas);
 //   BTserial.write(RPM);        
    if(RPM > 0)
      {
        BTserial.print(RPM, DEC); 
        Serial.println("Enviando ");
        Serial.print(RPM);;
      }   
    contador = 0;    
    RPM = 0;
  }

  
void interrupcion0()
  {   // Funcion que se ejecuta durante cada interrupion
    contador++;   // Se incrementa en uno el contador
  }
  

