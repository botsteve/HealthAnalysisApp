import os
import time
import serial
import string
import pynmea2
import requests
import json

serLeo= serial.Serial('/dev/ttyACM0', 57600)
urlGps = 'http://192.168.43.103:8080/gps'
headers = {'content-type':'application/json'}

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
	if(serLeo.in_waiting >0):
		gpsLine = serLeo.readline()
		print(gpsLine)
		if(gpsLine[0:6] == '$GPGGA'):
			print("GPS CASE")
			newmsg = pynmea2.parse(gpsLine)
			tempLocation = GPS(newmsg.latitude, newmsg.longitude, newmsg.altitude)
			newGpsTemp =  {
			"latitude": newmsg.latitude,
			"longitude": newmsg.longitude,
			"altitude": newmsg.altitude
			}
			print(newGpsTemp) 
        	print(" " +str(tempLocation.latitude) + " " + str(tempLocation.longitude) + " " + str(tempLocation.altitude))
			y = requests.post(urlGps, json=newGpsTemp)
			print(y.text)
			time.sleep(10.0)
