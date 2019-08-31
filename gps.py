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
ser = serial.Serial(port, baudrate = 9600, timeout=0.5)
sensor = MCP9808.MCP9808()
sensor.begin()
url = 'http://192.168.43.103:8080/gps'
url = 'http://192.168.43.103:8080/temperature'

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
	newdata = ser.readline()
	temp = sensor.readTempC()
	
	if(ser.in_waiting >0):
        	line = ser.readline()
        	print(line)


	x = requests.post(url, json=temp)
	print(x.text)
	print('Temperature: {0:0.3F}*C / {1:0.3F}*F'.format(temp, c_to_f(temp)))
	time.sleep(10.0)

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
