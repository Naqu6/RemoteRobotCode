# Sensors.py
# Author: Ryan Ehrlich
# pyRemoteRobot Code


class Encoder:

	table = None
	port = None

	def __init__(self, portA, portB, robot):
		self.table = robot.table.getTable("Encoder")
		self.port = str(portA)
		self.table.putNumber(str(portB), portB - portA)

	def read(self):
		return self.table.getNumber(self.port, 0.0)

	def zero(self):
		self.table.putBoolean(self.port)
		