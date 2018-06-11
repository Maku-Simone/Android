//#include <SoftwareSerial.h>
//SoftwareSerial BTserial(1, 0); // RX | TX

int up = 8, down = 9, left = 10, right = 11, front = 12, back = 13;
int dir = 0;
void setup() 
  {
    Serial.begin(9600);    
    //BTserial.begin(9600);    
    pinMode(up, OUTPUT);    
    pinMode(down, OUTPUT);    
    pinMode(left, OUTPUT);    
    pinMode(right, OUTPUT);    
    pinMode(front, OUTPUT);    
    pinMode(back, OUTPUT);    
   
  }       // LOW, CHANGE, RISING, FALLING

  
void loop() 
  {    
     if(Serial.available()>0)
        {          
          dir = Serial.read();          
        }
     switch(dir)
      {
        case 'u': //arriba
          digitalWrite(up, HIGH); 
          delay(400);
          digitalWrite(up, LOW); 
          Serial.print("Arriba");
        break;
        case 'd': //abajo
          digitalWrite(down, HIGH); 
          delay(400);
          digitalWrite(down, LOW); 
          Serial.print("Abajo");
        break;
        case 'l': //izq
          digitalWrite(left, HIGH); 
          delay(400);
          digitalWrite(left, LOW); 
          Serial.print("Izquierda");
        break;
        case 'r': //der
          digitalWrite(right, HIGH);
          delay(400); 
          digitalWrite(right, LOW); 
          Serial.print("Derecha");
        break;
        case 'b': //tras
          digitalWrite(back, HIGH); 
          delay(400);
          digitalWrite(back, LOW); 
          Serial.print("Atrás");
        break;
        case 'f': //tras
          digitalWrite(front, HIGH); 
          delay(400);
          digitalWrite(front, LOW); 
          Serial.print("Adelante");
        break;                
      } 
      delay(500); 
  }

 
