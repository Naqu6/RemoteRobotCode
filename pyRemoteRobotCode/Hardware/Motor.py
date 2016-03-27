# Motor.py
# Author: Ryan Ehrlich
# Package: pyRemoteRobotCode


class Talon:

	table = None
	port = None


	def __init__(self, port, robot, inital_value = 0.0):
		self.table = robot.table.getTable("Talon")
		self.port = port
		self.table.putNumber(port, inital_value)

	def set(self, value):
		self.table.putNumber(self.port, value)

	def get(self):
		value = self.table.getNumber(self.port, -1000)
		if value == -1000:
			return None
		return value


class TalonSRX:

	table = None
	port = None


	def __init__(self, port, robot, inital_value = 0.0):
		self.table = robot.table.getTable("TalonSRX")
		self.port = port
		self.table.putNumber(port, inital_value)

	def set(self, value):
		self.table.putNumber(self.port, value)

	def get(self):
		value = self.table.getNumber(self.port, -1000)
		if value == -1000:
			return None
		return value


class Victor:

	table = None
	port = None


	def __init__(self, port, robot, inital_value = 0.0):
		self.table = robot.table.getTable("Victor")
		self.port = port
		self.table.putNumber(port, inital_value)

	def set(self, value):
		self.table.putNumber(self.port, value)

	def get(self):
		value = self.table.getNumber(self.port, -1000)
		if value == -1000:
			return None
		return value