import os
import time
import serial
import string
import pynmea2
import requests
import json
import Adafruit_MCP9808.MCP9808 as MCP9808


port="/dev/ttyS0"
serArd= serial.Serial('/dev/ttyACM0', 9600)
#ser = serial.Serial(port, baudrate = 9600, timeout=0.5)
sensor = MCP9808.MCP9808()
sensor.begin()
urlGps = 'http://192.168.43.103:8080/gps'
urlTemperature = 'http://192.168.43.103:8080/temperature'
urlEMG = 'http://192.168.43.103:8080/emg'
urlEKG = 'http://192.168.43.103:8080/ekg'
headers = {'content-type':'application/json'}


def c_to_f(c):
	return c * 9.0 / 5.0 + 32.0

class GPS(object):
	latitude = 0
	longitude = 0
	laltitude = 0
	def __init__(self, latitude, longitude, altitude):
		self.latitude = latitude
   		self.longitude = longitude
   		self.altitude = altitude

while True:
	dataout = pynmea2.NMEAStreamReader()
	temp = sensor.readTempC()
	
	if(serArd.in_waiting >0):
        	line = serArd.readline()
        	print(line)
		if(line[0:3]=='ECG'):
			ekg = requests.post(urlEKG,line[4:],headers=headers)
			print(ekg.text)
		elif(line[0:3]=='EMG'):
			emg = requests.post(urlEMG,line[4:],headers=headers)
			print(emg.text)
		elif(newdata[0:6] == '$GPGGA'):
			newmsg = pynmea2.parse(newdata)
			tempLocation = GPS(newmsg.latitude, newmsg.longitude, newmsg.altitude)
			newGpsTemp =  {
			"latitude": newmsg.latitude,
			"longitude": newmsg.longitude,
			"altitude": newmsg.altitude
			}
			print(newGpsTemp) 
        		print(" " +str(tempLocation.latitude) + " " + str(tempLocation.longitude) + " " + str(tempLocation.altitude))
			y = requests.post(urlGps, json=newGpsTemp)
			lat  = newmsg.latitude
			print(lat)
			lng  = newmsg.longitude
			print(lng)
		
	x = requests.post(urlTemperature, json=temp)
	print(x.text)
	#print('Temperature: {0:0.3F}*C / {1:0.3F}*F'.format(temp, c_to_f(temp)))
	time.sleep(10.0)
