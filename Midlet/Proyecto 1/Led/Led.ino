int led = 7;
int boton = 5;

int estado = 0;
int estadobtn = 0;

void setup()
{
  Serial.begin(9600);
  pinMode(led, OUTPUT);  
  pinMode(boton, INPUT);
    
}

void loop()
{
  int val = digitalRead(boton);  
  if (val == HIGH) 
    {           
          if(estadobtn == 0)
            {
              digitalWrite(led, HIGH); 
              estadobtn = 1;               
              Serial.print("ON ");
            }
          else
            {
              digitalWrite(led, LOW); 
              estadobtn = 0;               
              Serial.print("OFF ");              
            }  
          delay(300);
    }
   
  if(Serial.available()>0)
  {
    estado = Serial.read();
    Serial.print(estado);
  }
  switch(estado)
  {  
    case 'a':
    digitalWrite(led, HIGH);
    estadobtn = 1;
    break;
    case 'b':
    digitalWrite(led, LOW);
    estadobtn = 0;
    break;
  }
  estado = 0;
}


