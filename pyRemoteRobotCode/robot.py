from networktables import NetworkTable

class Robot:
	table = None

	def __init__(self, ip):
		NetworkTable.setIPAddress(ip)
		NetworkTable.setClientMode()
		NetworkTable.initialize()
		self.table = NetworkTable