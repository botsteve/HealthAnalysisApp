import os
import time
import serial
import string
import pynmea2
import requests
import json
import Adafruit_MCP9808.MCP9808 as MCP9808

serArd= serial.Serial('/dev/ttyACM1', 57600)
sensor = MCP9808.MCP9808()
sensor.begin()
urlTemperature = 'http://192.168.43.103:8080/temperature'
urlEMG = 'http://192.168.43.103:8080/emg'
urlEKG = 'http://192.168.43.103:8080/ekg'
headers = {'content-type':'application/json'}


def c_to_f(c):
	return c * 9.0 / 5.0 + 32.0

while True:
	dataout = pynmea2.NMEAStreamReader()
	temp = sensor.readTempC()
	
	if(serArd.in_waiting >0):
	        line = serArd.readline()
        	print(line)
		if(line[0:3]=='ECG'):
			print("ECG")
			ekg = requests.post(urlEKG,line[4:],headers=headers)
			print(ekg.text)
		elif(line[0:3]=='EMG'):
			print("EMG")
			voltageEmg = line[4:] * ( 5 / 1024)
			emg = requests.post(urlEMG,voltageEmg,headers=headers)
			print(emg.text)
		
	x = requests.post(urlTemperature, json=temp)
	print(x.text)
	time.sleep(10.0)
	#print('Temperature: {0:0.3F}*C / {1:0.3F}*F'.format(temp, c_to_f(temp)))
