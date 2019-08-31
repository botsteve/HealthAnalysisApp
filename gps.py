import os
import time
import serial
import string
import pynmea2
import requests
import json

url = 'http://192.168.43.103:8080/gps'

class GPS(object):
	latitude = 0
	longitude = 0
	laltitude = 0
	def __init__(self, latitude, longitude, altitude):
		self.latitude = latitude
   		self.longitude = longitude
   		self.altitude = altitude

while True:
	port="/dev/ttyS0"
	ser = serial.Serial(port, baudrate = 9600, timeout=0.5)
	dataout = pynmea2.NMEAStreamReader()
	newdata = ser.readline()
	
	print(" GET LAT AND LONG")
	
	if newdata[0:6] == '$GPGGA':
		newmsg = pynmea2.parse(newdata)
		temp = GPS(newmsg.latitude, newmsg.longitude, newmsg.altitude)
		newTemp =  {
			"latitude": newmsg.latitude,
			"longitude": newmsg.longitude,
			"altitude": newmsg.altitude
		}
		print(newTemp) 
                print(" " +str(temp.latitude) + " " + str(temp.longitude) + " " + str(temp.altitude))
		x = requests.post(url, json=newTemp)
		lat  = newmsg.latitude
		print(lat)
		lng  = newmsg.longitude
		print(lng)
		time.sleep(10)
