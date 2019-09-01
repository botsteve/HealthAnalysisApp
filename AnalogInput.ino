#include <eHealth.h>

int sensorPin = A0;
int sensorValue = 0;  // variable to store the value coming from the sensor

void setup() {
  // declare the ledPin as an OUTPUT:
  Serial.begin(9600);;  
}

void loop() {
  // read the value from the sensor:
  float ECG = eHealth.getECG();
  sensorValue = analogRead(sensorPin);    
  
             
  Serial.print("EMG=");
  Serial.println(sensorValue);
  
  Serial.print("ECG=");
  Serial.print(ECG, 2);
  delay(400);  
    
}

