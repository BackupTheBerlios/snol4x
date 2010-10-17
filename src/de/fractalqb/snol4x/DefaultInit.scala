package de.fractalqb.snol4x

class DefaultInit extends Initialize {
	def initialize() {
		Facet.TOPIC += PrintStreamChannel.ERR
	}
}