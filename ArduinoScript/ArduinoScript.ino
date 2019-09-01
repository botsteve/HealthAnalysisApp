#include <eHealth.h>
#include <Adafruit_GPS.h>
#include <SoftwareSerial.h>


// Connect the GPS Power pin to 5V
// Connect the GPS Ground pin to ground
// Connect the GPS TX (transmit) pin to Digital 8
// Connect the GPS RX (receive) pin to Digital 7

// You can change the pin numbers to match your wiring:
SoftwareSerial mySerial(8, 7);

#define PMTK_SET_NMEA_UPDATE_1HZ  "$PMTK220,1000*1F"
#define PMTK_SET_NMEA_UPDATE_5HZ  "$PMTK220,200*2C"
#define PMTK_SET_NMEA_UPDATE_10HZ "$PMTK220,100*2F"

// turn on only the second sentence (GPRMC)
#define PMTK_SET_NMEA_OUTPUT_RMCONLY "$PMTK314,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0*29"
// turn on GPRMC and GGA
#define PMTK_SET_NMEA_OUTPUT_RMCGGA "$PMTK314,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0*28"
// turn on ALL THE DATA
#define PMTK_SET_NMEA_OUTPUT_ALLDATA "$PMTK314,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0*28"
// turn off output
#define PMTK_SET_NMEA_OUTPUT_OFF "$PMTK314,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0*28"

#define PMTK_Q_RELEASE "$PMTK605*31"


int sensorPin = A0;
int sensorValue = 0;  // variable to store the value coming from the sensor

unsigned long delay1 = 10000;
unsigned long delay2 = 1800000; //30 minutes in miliseconds
unsigned long t1, t2;

void setup() {
  t1 = t2 = millis();
  while (!Serial); // wait for Serial to be ready

  Serial.begin(57600); // this baud rate doesn't actually matter!
  mySerial.begin(9600);
  delay(100);
  Serial.println("Get version!");
  mySerial.println(PMTK_Q_RELEASE);

  // you can send various commands to get it started
  //mySerial.println(PMTK_SET_NMEA_OUTPUT_RMCGGA);
  mySerial.println(PMTK_SET_NMEA_OUTPUT_ALLDATA);

  mySerial.println(PMTK_SET_NMEA_UPDATE_1HZ); 
}

void loop() {
  if(millis() - t1 > delay1) { //this will be executed every delay1 ms
    getMedicalParameters();
    t1 = millis();
  }

  getGpsLocation();

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

void getGpsLocation (void) {
  if (Serial.available()) {
    char c = Serial.read();
    Serial.write(c);
    mySerial.write(c);
  }
  if (mySerial.available()) {
    char c = mySerial.read();
    Serial.write(c);
  }
}



