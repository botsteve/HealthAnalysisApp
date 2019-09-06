#include <eHealth.h>
#include <SoftwareSerial.h>

int sensorPin = A0;
int sensorValue = 0;  // variable to store the value coming from the sensor

unsigned long delay1 = 10000;
unsigned long delay2 = 1800000; s
unsigned long t1, t2;

void setup() {
  t1 = t2 = millis();
  while (!Serial); // wait for Serial to be ready

  Serial.begin(57600); 

}

void loop() {
  if(millis() - t1 > delay1) { //this will be executed every delay1 ms
    getMedicalParameters();
    t1 = millis();
  }


}

void getMedicalParameters (void) {
  float ECG = eHealth.getECG();
  sensorValue = analogRead(sensorPin);
  Serial.println('------------------------------------------');  
  Serial.println(' ');
  Serial.print("EMG=");
  Serial.println(sensorValue);

  Serial.print("ECG=");
  Serial.println(ECG, 2);
  Serial.println('-------------------------------------------'); 
}

